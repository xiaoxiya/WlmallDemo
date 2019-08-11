package com.xiaoxiya.wlmalldemo.service;

import com.xiaoxiya.wlmalldemomodel.entity.UmsAdmin;
import com.xiaoxiya.wlmalldemomodel.entity.UmsPermission;

import java.util.List;

/**
 * 后台管理员
 * @author luopeng
 * @date 2019/8/9 16:30
 */
public interface UmsAdminService {
    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdmin umsAdmin);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 获取用户所有权限（包括角色权限+-权限）
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
