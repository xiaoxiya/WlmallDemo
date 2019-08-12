package com.xiaoxiya.wlmalldemoweb;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
 * @author luopeng
 * @date 2019/8/12 10:34
 * SpringBoot测试,@webappconfigruation 开启web上下文测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class MockMvcWebTests {
    /**
     * 注入webApplicationContext
     */
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setMockMvc() {
        //设置MockMvc
        mockMvc = MockMvcBuilders
            .webAppContextSetup(webApplicationContext)
            .build();
    }


    @Test
    public void testLlogin() throws Exception {
        String userinfo = "{\"password\":\"123456\",\"username\":\"test\"}";
        //1、mockMvc.perform执行一个请求；
        //2、MockMvcRequestBuilders.post("/admin/login")构造一个post请求
        //3、ResultActions.andExpect添加执行完成后的断言
        //status.isOK()用来验证返回码是否为200
        //jsonPath用来验证返回的json数据中的值是否符合我们的预期
        //4、ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情
        //比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
        //5、ResultActions.andReturn 表示执行完成后返回相应的结果
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/admin/login")
            .contentType(MediaType.APPLICATION_JSON)
            .content(userinfo))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn();
        System.out.println(result.getResponse().getContentAsString());

    }
}
