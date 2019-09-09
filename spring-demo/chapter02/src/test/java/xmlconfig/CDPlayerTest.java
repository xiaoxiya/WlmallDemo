package xmlconfig;

import com.xiaoxiya.chapter02.xmlconfig.CompactDisc;
import com.xiaoxiya.chapter02.xmlconfig.MediaPlayer;
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
 * @date 2019/8/22 15:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/xmlconfig/soundsystem1.xml")
public class CDPlayerTest {

    public final Logger log = LoggerFactory.getLogger(CDPlayerTest.class);

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
