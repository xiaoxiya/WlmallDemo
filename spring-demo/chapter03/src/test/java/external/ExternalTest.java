package external;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 * @author luopeng
 * @date 2019/9/11 16:03
 */
public class ExternalTest {

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes=ExpressiveConfig.class)
    public static class InjectFromProperties {

        @Autowired
        private BlankDisc blankDisc;

        @Test
        public void assertBlankDiscProperties() {
            assertEquals("The Beatles", blankDisc.getArtist());
            assertEquals("Sgt. Peppers Lonely Hearts Club Band", blankDisc.getTitle());
        }

    }

    public static class InjectFromPropertiesWithRequiredProperties {

        @Test(expected=BeanCreationException.class)
        public void assertBlankDiscProperties() {
            new AnnotationConfigApplicationContext(ExpressiveRequireConfig.class);
        }

    }

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration("classpath:external/dadaConfig.xml")
    public static class InjectFromProperties_XMLConfig {

        @Autowired
        private BlankDisc blankDisc;

        @Test
        public void assertBlankDiscProperties() {
            assertEquals("The Beatles", blankDisc.getArtist());
            assertEquals("Sgt. Peppers Lonely Hearts Club Band", blankDisc.getTitle());
        }

    }

}
