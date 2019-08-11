package com.xiaoxiya.wlmalldemomodel.mydao;

import com.xiaoxiya.wlmalldemomodel.entity.UmsPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author luopeng
 * @date 2019/8/9 16:50
 * 后台用户与角色管理自定义Dao
 */
@Component
public interface UmsAdminRoleRelationDao {
    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
