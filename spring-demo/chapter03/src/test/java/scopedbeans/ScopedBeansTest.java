package scopedbeans;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.Assert.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author luopeng
 * @date 2019/9/11 15:24
 */
public class ScopedBeansTest {

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes=ComponentScannedConfig.class)
    public static class ComponentScannedScopedBeanTest {

        @Autowired
        private ApplicationContext context;

        @Test
        public void testProxyScope() {
            Notepad notepad1 = context.getBean(Notepad.class);
            Notepad notepad2 = context.getBean(Notepad.class);
            assertNotSame(notepad1, notepad2);
        }

        @Test
        public void testSingletonScope() {
            UniqueThings thing1 = context.getBean(UniqueThings.class);
            UniqueThings thing2 = context.getBean(UniqueThings.class);
            assertSame(thing1, thing2);
        }

    }

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration("classpath:scopedbeans/scopedBeans.xml")
    public static class XMLConfigScopedBeanTest {

        @Autowired
        private ApplicationContext context;

        @Test
        public void testProxyScope() {
            Notepad notepad1 = context.getBean(Notepad.class);
            Notepad notepad2 = context.getBean(Notepad.class);
            assertNotSame(notepad1, notepad2);
        }

        @Test
        public void testSingletonScope() {
            UniqueThings thing1 = context.getBean(UniqueThings.class);
            UniqueThings thing2 = context.getBean(UniqueThings.class);
            assertSame(thing1, thing2);
        }

    }


}
