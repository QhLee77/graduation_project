package com.nbclass.service;

import com.github.pagehelper.PageInfo;
import com.nbclass.model.FileInfo;
import com.nbclass.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileInfoService {
    /**
     *   分页查询 文件信息
     * @param limit  分页大小
     * @param pageNo 页码
     * @param example 查询条件
     * @return
     */
    public PageInfo<FileInfo> findFileInfo(int limit,int pageNo, FileInfo example,boolean diGui);

    /**
     * 分页查询 我上传的文件
     * @param limit
     * @param pageNo
     * @return
     */

    PageInfo<FileInfo> findMyUploadFileInfo(User user, int limit, int pageNo);

    /**
     * 添加文件
     * @param fileInfo 文件
     * @return
     */
    public int addFileInfo(FileInfo fileInfo);

    /**
     * 根据 id 删除
     * @param id 文件id,支持批量删除
     * @return
     */
    public int deleteFileInfo(String... id);

    /**
     * 根据id 更改文件信息
     * @param fileInfo  文件信息
     * @return
     */
    public int updateFileInfo(FileInfo fileInfo);

    FileInfo saveFile(FileInfo fileInfo, MultipartFile multipartFile);

    FileInfo findFileInfoById(String id);
    List<FileInfo> findFileInfoByIds(String[] fids);

    List<FileInfo> findFileInfoByCategoryIds(String... categoryIds);

    FileInfo updateFile(FileInfo fileInfo, MultipartFile multipartFile);
}
