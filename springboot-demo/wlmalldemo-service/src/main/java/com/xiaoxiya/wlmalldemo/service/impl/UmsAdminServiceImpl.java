package com.xiaoxiya.wlmalldemo.service.impl;

import com.xiaoxiya.wlmalldemo.service.UmsAdminService;
import com.xiaoxiya.wlmalldemocommon.utils.JwtTokenUtil;
import com.xiaoxiya.wlmalldemomodel.dao.UmsAdminMapper;
import com.xiaoxiya.wlmalldemomodel.entity.UmsAdmin;
import com.xiaoxiya.wlmalldemomodel.entity.UmsAdminExample;
import com.xiaoxiya.wlmalldemomodel.entity.UmsPermission;
import com.xiaoxiya.wlmalldemomodel.mydao.UmsAdminRoleRelationDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @author luopeng
 * @date 2019/8/9 16:36
 * 无法引入lombok依赖，无法使用@slf4j注解,依赖不在公共pom文件中
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    private static final Logger log = LoggerFactory.getLogger(UmsAdminServiceImpl.class);
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UmsAdminMapper adminMapper;
    @Autowired
    private UmsAdminRoleRelationDao adminRoleRelationDao;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> adminList = adminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        }
        return null;
    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdmin) {
        UmsAdmin umsAdmin1 = new UmsAdmin();
        BeanUtils.copyProperties(umsAdmin, umsAdmin1);
        umsAdmin1.setCreateTime(new Date());
        umsAdmin1.setStatus(1);
        //查询是否有形同用户名的用户
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(umsAdmin1.getUsername());
        List<UmsAdmin> umsAdminList = adminMapper.selectByExample(example);
        if (umsAdminList.size() > 0) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin1.getPassword());
        umsAdmin1.setPassword(encodePassword);
        adminMapper.insert(umsAdmin1);
        return umsAdmin1;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            log.warn("登录异常{}",e.getMessage());
        }
        return token;
    }

    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return adminRoleRelationDao.getPermissionList(adminId);
    }

}
