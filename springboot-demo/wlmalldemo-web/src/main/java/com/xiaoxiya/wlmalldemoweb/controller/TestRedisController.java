package com.xiaoxiya.wlmalldemoweb.controller;

import com.xiaoxiya.wlmalldemo.service.UmsMemberService;
import com.xiaoxiya.wlmalldemomodel.Comment.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author luopeng
 * @date 2019/8/8 21:45
 */
@Controller
@Api(tags = "TestRedisController", description = "会员登录注册管理")
@RequestMapping("/springbootdemo")
public class TestRedisController {

    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuth", method = RequestMethod.GET)
    @ResponseBody
    public Result getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }
    @ApiOperation("判断验证码是否正确")
    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.POST)
    @ResponseBody
    public Result verifyAuthCode(@RequestParam String telphone, @RequestParam String authCode) {
        return memberService.verifyAuthCode(telphone, authCode);
    }


}
