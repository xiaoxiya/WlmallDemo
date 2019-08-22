package autoconfig;

import com.xiaoxiya.chapter02.autoconfig.CDPlayerConfig;
import com.xiaoxiya.chapter02.autoconfig.CompactDisc;
import com.xiaoxiya.chapter02.autoconfig.MediaPlayer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author luopeng
 * @date 2019/8/22 15:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
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
