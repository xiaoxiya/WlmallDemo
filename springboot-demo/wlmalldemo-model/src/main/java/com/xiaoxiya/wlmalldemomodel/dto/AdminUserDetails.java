package com.xiaoxiya.wlmalldemomodel.dto;

import com.xiaoxiya.wlmalldemomodel.entity.UmsAdmin;
import com.xiaoxiya.wlmalldemomodel.entity.UmsPermission;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author luopeng
 * @date 2019/8/9 15:39
 * springSecurity需要的用户详情
 */
public class AdminUserDetails implements UserDetails {

    private UmsAdmin umsAdmin;
    private List<UmsPermission> permissionList;

    public AdminUserDetails(UmsAdmin umsAdmin, List<UmsPermission> permissionList) {
        this.umsAdmin = umsAdmin;
        this.permissionList = permissionList;
    }

    /**
     * 授予权限
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissionList.stream()
                  .filter(permission -> permission.getValue() != null)
                  .map(permission -> new SimpleGrantedAuthority(permission.getValue()))
                  .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }

    /**
     * 返回true表示不过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    /**
     * 返回true表示不加锁
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 返回true表示不禁用
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return umsAdmin.getStatus().equals(1);
    }
}
