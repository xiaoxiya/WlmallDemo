package autoconfig;

import com.xiaoxiya.chapter02.autoconfig.CompactDisc;
import com.xiaoxiya.chapter02.autoconfig.MediaPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * @author luopeng
 * @date 2019/8/22 16:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/autoconfig/soundsystem.xml")
public class CDPlayerXMLConfigTest {
    public final Logger log = LoggerFactory.getLogger(CDPlayerXMLConfigTest.class);

    @Autowired
    private MediaPlayer player;

    @Autowired
    private CompactDisc cd;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }
    @Test
    public void play() {
        player.play();
    }
}
