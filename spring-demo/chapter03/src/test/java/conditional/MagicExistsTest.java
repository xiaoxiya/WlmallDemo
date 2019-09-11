package conditional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author luopeng
 * @date 2019/9/11 11:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MagicBean.class)
public class MagicExistsTest {
    @Autowired
    private ApplicationContext context;


    @Test
    public void test() {
         assertTrue(context.containsBean("magicBean"));
         //assertNotNull(context.containsBean("magicBean"));
    }
}
