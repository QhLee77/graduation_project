package com.nbclass.service.impl;

import com.nbclass.mapper.PermissionMapper;
import com.nbclass.model.Permission;
import com.nbclass.service.PermissionService;
import com.nbclass.util.CoreConst;
import com.nbclass.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
/**
 * @version V1.0
 * @date 2020年8月11日
 * @author hkx
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    /**
     * 根据用户id查询权限集合
     * @param userId
     * @return set
     */
    @Override
    public Set<String> findPermsByUserId(String userId) {
        return permissionMapper.findPermsByUserId(userId);
    }

    /**
     * 查询全部权限
     * @param status
     * @return list
     */
    @Override
    public List<Permission> selectAll(Integer status) {
        return permissionMapper.selectAllPerms(status);
    }

    /**
     * 查询全部菜单
     * @param status
     * @return list
     */
    @Override
    public List<Permission> selectAllMenuName(Integer status) {
        return permissionMapper.selectAllMenuName(status);
    }


    /**
     * 根据用户id查询权限集合
     * @param userId
     * @return list
     */
    @Override
    public List<Permission> selectMenuByUserId(String userId) {
        return permissionMapper.selectMenuByUserId(userId);
    }

    /**
     * 插入权限
     * @param permission
     * @return int
     */
    @Override
    public int insert(Permission permission) {
        Date date = new Date();
        permission.setPermissionId(UUIDUtil.getUniqueIdByUUId());
        permission.setStatus(CoreConst.STATUS_VALID);
        permission.setCreateTime(date);
        permission.setUpdateTime(date);
        return permissionMapper.insert(permission);
    }
    /**
     * 根据权限id更新状态
     * @param permissionId
     * @param status
     * @return int
     */
    @Override
    public int updateStatus(String  permissionId,Integer status) {
        return permissionMapper.updateStatusByPermissionId(permissionId,status);
    }

    /**
     * 根据权限id查询权限
     * @param permissionId
     * @return permission
     */

    @Override
    public Permission findByPermissionId(String permissionId) {
        return permissionMapper.selectByPermissionId(permissionId);
    }

    /**
     * 根据id查询权限
     * @param id
     * @return permission
     */
    @Override
    public Permission findById(Integer id) {
        Permission permission = new Permission();
        permission.setId(id);
        return permissionMapper.selectByPrimaryKey(permission);
    }

    /**
     * 更新权限
     * @param permission
     * @return int
     */
    @Override
    public int updateByPermissionId(Permission permission) {
        return permissionMapper.updateByPermissionId(permission);
    }


    /**
     * 查询子权限条数
     * @param permissionId
     * @return int
     */
    @Override
    public int selectSubPermsByPermissionId(String permissionId) {
        return permissionMapper.selectSubPermsByPermissionId(permissionId);
    }
}
