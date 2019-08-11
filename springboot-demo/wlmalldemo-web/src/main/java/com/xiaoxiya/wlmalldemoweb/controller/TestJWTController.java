package com.xiaoxiya.wlmalldemoweb.controller;

import com.xiaoxiya.wlmalldemo.service.UmsAdminService;
import com.xiaoxiya.wlmalldemocommon.common.Result;
import com.xiaoxiya.wlmalldemomodel.dto.UmsAdminLoginParam;
import com.xiaoxiya.wlmalldemomodel.entity.UmsAdmin;
import com.xiaoxiya.wlmalldemomodel.entity.UmsPermission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luopeng
 * @date 2019/8/10 22:09
 */
@Controller
@Api(tags = "TestJWTController", description = "后台用户管理")
@RequestMapping("/admin")
public class TestJWTController {
    @Autowired
    private UmsAdminService adminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Result<UmsAdmin> register(@RequestBody UmsAdmin umsAdminParam, BindingResult result) {
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) {
            Result.error();
        }
        return Result.success(umsAdmin);
    }

    @ApiOperation(value = "登录以后返回token")
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return Result.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead", tokenHead);
        return Result.success(tokenMap);
    }

    @ApiOperation(value = "获取用户所有权限（包括+-权限）")
    @ResponseBody
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    public Result<List<UmsPermission>> getPermissonList(@PathVariable Long adminId) {
        List<UmsPermission> permissionList = adminService.getPermissionList(adminId);
        return  Result.success(permissionList);
    }
}
