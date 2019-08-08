package com.xiaoxiya.wlmalldemoweb.controller;

import com.xiaoxiya.wlmalldemomodel.dao.UmsAdminMapper;
import com.xiaoxiya.wlmalldemomodel.entity.UmsAdmin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试生成swagger接口文档控制类
 * @author luopeng
 * @date 2019/8/8 11:13
 */
@Api(tags = "TestSwaggerController", description = "测试swagger2接口生成文档")
@Controller
@RequestMapping("/springbootdemo")
public class TestSwaggerController {
    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @ApiOperation("获取数据库数据")
    @ResponseBody
    @RequestMapping(value = "getUmsAdminInfo", method = RequestMethod.GET)
    public UmsAdmin getUmsAdminInfo() {
        return umsAdminMapper.selectByPrimaryKey(1L);
    }
}
