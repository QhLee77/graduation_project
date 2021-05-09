package com.nbclass.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nbclass.config.FileInfoConfig;
import com.nbclass.mapper.CategoryMapper;
import com.nbclass.mapper.FileInfoMapper;
import com.nbclass.model.Category;
import com.nbclass.model.FileInfo;
import com.nbclass.model.User;
import com.nbclass.service.FileInfoService;
import com.nbclass.util.FileUtil;
import com.nbclass.util.TokenUtils;
import com.nbclass.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import java.io.File;
import java.util.*;

@Service
public class FileInfoServiceImpl implements FileInfoService {
    @Autowired
    private FileInfoMapper fileInfoMapper;
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    FileInfoConfig fileInfoConfig;

    /**
     * 分页查询 文件信息
     *
     * @param limit   分页大小
     * @param pageNo  页码
     * @param example 查询条件
     * @return
     */
    @Override
    public PageInfo<FileInfo> findFileInfo(int limit, int pageNo, FileInfo example,boolean diGui) {
        Example ex= new Example(FileInfo.class);
        Example.Criteria criteria = ex.createCriteria();
        criteria.andEqualTo("status",1).andNotEqualTo("categoryId","");
        if(example.getFileNumber()!=null){
            //  如果存在 fileNumber , 其他条件忽略
            criteria.andEqualTo("fileNumber",example.getFileNumber());
        }else{
    //        处理类别id 及是否递归，可以继续优化
            if(example.getCategoryId()!=null && example.getCategoryId().trim().length()>0){
                String categoryId = example.getCategoryId();
                if(diGui){
                    List<Category> categoryList = categoryMapper.selectCategorysByParentId(categoryId);
                    List<String> idList = new ArrayList<>();
                    for (Category category : categoryList) {
                        idList.add(category.getId());
                    }
                    criteria.andIn("categoryId",idList);
                }else{
                    criteria.andEqualTo("categoryId",categoryId);
                }

            }
    //       空间id
            if(example.getSpaceId()!=null && example.getSpaceId().trim().length()>0 ){
                criteria.andEqualTo("spaceId",example.getSpaceId());
            }

    //      文件名
            if(example.getFileName()!=null && example.getFileName().trim().length()>0 ){
                criteria.andLike("fileName","%"+example.getFileName()+"%");
            }
    //      上传者
            if(example.getCreatorName()!=null && example.getCreatorName().trim().length()>0 ){
                criteria.andLike("creatorName","%"+example.getCreatorName()+"%");
            }
    //      关键字
            if(example.getFileKeys()!=null && example.getFileKeys().trim().length()>0 ){
                criteria.andLike("fileKeys","%"+example.getFileKeys()+"%");
            }

        }
        PageHelper.startPage(pageNo,limit);
        List<FileInfo> fileInfoList = fileInfoMapper.selectByExample(ex);
        this.initIcon(fileInfoList.toArray(new FileInfo[]{}));
        PageInfo<FileInfo> fileInfoPageInfo = new PageInfo<>(fileInfoList);
        PageHelper.clearPage();
        return fileInfoPageInfo;
    }

    /**
     * 分页查询 我上传的文件
     *
     * @param limit
     * @param pageNo
     * @return
     */
    @Override
    public PageInfo<FileInfo> findMyUploadFileInfo(User user, int limit, int pageNo) {
        Example ex= new Example(FileInfo.class);
        Example.Criteria criteria = ex.createCriteria();
        criteria.andEqualTo("status",1).andEqualTo("creatorId",user.getId());
        PageHelper.startPage(pageNo,limit);
        List<FileInfo> fileInfoList = fileInfoMapper.selectByExample(ex);
        PageHelper.clearPage();
        this.initIcon(fileInfoList.toArray(new FileInfo[]{}));
        PageInfo<FileInfo> fileInfoPageInfo = new PageInfo<>(fileInfoList);
        return fileInfoPageInfo;
    }

    /**
     * 初始化文件展示的图标，在
     * @param fileInfos
     * 依据：后缀名或文件类型中 包含 doc 之类的字母
     */
    private void initIcon(FileInfo... fileInfos) {
        Map<String, String> iconMap = fileInfoConfig.getIconMap();
        if(fileInfos!=null && fileInfos.length>0){
            for (FileInfo fileInfo : fileInfos) {
                fileInfo.setFileIcon("fa-file-o");//默认图标
                String fileName = fileInfo.getFileName();
                String hz = (fileName.contains(".")?fileName.substring(fileName.lastIndexOf(".")):"").toUpperCase().trim();
                String contenttype = fileInfo.getContenttype()!=null?fileInfo.getContenttype().trim().toUpperCase():"";
                Set<String> keySet = iconMap.keySet();
                for (String  key: keySet) {
                    //key = key.toUpperCase().trim();
                    if(hz.contains(key.toUpperCase()) || contenttype.contains(key.toUpperCase())){
                        fileInfo.setFileIcon(iconMap.get(key));
                        break;
                    }
                }

            }

        }
    }

    /**
     * 添加文件
     *
     * @param fileInfo 文件
     * @return
     */
    @Override
    public int addFileInfo(FileInfo fileInfo) {
        return fileInfoMapper.insertSelective(fileInfo);
    }

    /**
     * 根据 id 删除
     *
     * @param id 文件id,支持批量删除
     * @return
     */
    @Override
    public int deleteFileInfo(String... id) {
        int count=0;
        if(id.length>0){
            for (String i : id) {
                FileInfo fileInfo = new FileInfo();
                fileInfo.setId(i);
                fileInfo.setStatus(0);
                fileInfo.setUpdatetime(new Date());
                count = count+fileInfoMapper.updateByPrimaryKeySelective(fileInfo);
            }
        }
        return count;
    }

    /**
     * 根据id 更改文件信息
     *
     * @param fileInfo 文件信息
     * @return
     */
    @Override
    public int updateFileInfo(FileInfo fileInfo) {
        return fileInfoMapper.updateByPrimaryKeySelective(fileInfo);
    }

    @Override
    public FileInfo saveFile(FileInfo fileInfo, MultipartFile multipartFile) {
        String originalFilename = multipartFile.getOriginalFilename();
        String fileMd5 = FileUtil.fileMd5(multipartFile);
        String contentType = multipartFile.getContentType();
        long size = multipartFile.getSize();

        fileInfo.setId(UUIDUtil.getUniqueIdByUUId());
        fileInfo.setFileName(originalFilename);
        fileInfo.setMd5(fileMd5);
        fileInfo.setContenttype(contentType);
        fileInfo.setSize((int) size);
        String name2Save = new StringBuilder().append(FileUtil.getNowDatePath()).append("-").append(fileMd5.substring(2,8)).append("-").append(originalFilename).toString();
        fileInfo.setPath("/"+name2Save);
        fileInfo.setStatus(1);
        fileInfo.setCreatetime(new Date());
        fileInfo.setUpdatetime(new Date());
        this.addFileInfo(fileInfo);
       // File file = new File(fileInfoConfig.getFileDir(), name2Save);
        String s = FileUtil.saveFile(multipartFile, fileInfoConfig.getFileDir() + fileInfo.getPath());
        return fileInfo;
    }

    @Override
    public FileInfo updateFile(FileInfo fileInfo, MultipartFile multipartFile) {
        if(multipartFile!=null && multipartFile.getSize()>0){
            String originalFilename = multipartFile.getOriginalFilename();
            String fileMd5 = FileUtil.fileMd5(multipartFile);
            String contentType = multipartFile.getContentType();
            long size = multipartFile.getSize();
            fileInfo.setFileName(originalFilename);
            fileInfo.setMd5(fileMd5);
            fileInfo.setContenttype(contentType);
            fileInfo.setSize((int) size);
            String name2Save = new StringBuilder().append(FileUtil.getNowDatePath()).append("-").append(fileMd5.substring(2,8)).append("-").append(originalFilename).toString();
            fileInfo.setPath("/"+name2Save);
            fileInfo.setStatus(1);
            String s = FileUtil.saveFile(multipartFile, fileInfoConfig.getFileDir() + fileInfo.getPath());
        }
        fileInfo.setUpdatetime(new Date());
        this.updateFileInfo(fileInfo);
        return fileInfo;
    }

    @Override
    public FileInfo findFileInfoById(String id) {
        return fileInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<FileInfo> findFileInfoByIds(String[] fids) {
        Example example = new Example(FileInfo.class);
        example.createCriteria().andIn("id",Arrays.asList(fids));
        return fileInfoMapper.selectByExample(example);
    }

    @Override
    public List<FileInfo> findFileInfoByCategoryIds(String... categoryIds) {
        Example example = new Example(FileInfo.class);
        example.createCriteria().andIn("categoryId",Arrays.asList(categoryIds)).andEqualTo("status",1);
        return fileInfoMapper.selectByExample(example);
    }
}
