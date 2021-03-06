package mixedconfig;

import com.xiaoxiya.chapter02.mixedconfig.MediaPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author luopeng
 * @date 2019/9/9 11:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/mixedconfig/cdplayerConfig.xml")
public class ImportJavaConfigTest {
    @Autowired
    private MediaPlayer player;


    @Test
    public void play() {
        player.play();
    }
}
