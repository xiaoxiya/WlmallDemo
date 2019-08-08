package com.xiaoxiya.wlmalldemoweb;

import com.xiaoxiya.wlmalldemomodel.dao.UmsAdminMapper;
import com.xiaoxiya.wlmalldemomodel.entity.UmsAdmin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.xiaoxiya.wlmalldemomodel.dao")
public class WlmalldemowebApplicationTests {

	@Autowired
	private UmsAdminMapper umsAdminMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test1(){
		UmsAdmin umsAdmin= umsAdminMapper.selectByPrimaryKey(1L);
		System.out.println(umsAdmin);
	}

}
