package xmlconfig;

import com.xiaoxiya.chapter02.xmlconfig.MediaPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author luopeng
 * @date 2019/9/9 10:34
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/xmlconfig/CNameSpaceValue.xml")
public class CNameSpaceValueTest {
    @Autowired
    private MediaPlayer mediaPlayer;

    @Test
    public void play() {
        mediaPlayer.play();
    }
}
