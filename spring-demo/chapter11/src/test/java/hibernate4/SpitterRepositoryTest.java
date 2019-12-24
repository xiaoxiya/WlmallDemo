package hibernate4;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import marcopolo.hibernate4.RepositoryConfig;
import marcopolo.hibernate4.SpittrRepository;
import marcopolo.hibernate4.domain.Spitter;

import java.util.List;

/**
 * @author luopeng
 * @date 2019/11/17 22:09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepositoryConfig.class)
public class SpitterRepositoryTest {

    @Autowired
    SpittrRepository spitterRepositry;

    @Test
    @Transactional
    public void findAll() {
        List<Spitter> spitters = spitterRepositry.findAll();
        Assert.assertEquals(4, spitters.size());
        assertSpittr(0, spitters.get(0));
        assertSpittr(1, spitters.get(1));
        assertSpittr(2, spitters.get(2));
        assertSpittr(3, spitters.get(3));
    }

    private static void assertSpittr(int i, Spitter spitter) {
        assertSpittr(i, spitter, "Newbie");
    }

    private static void assertSpittr(int expectedSpitterIndex, Spitter actual, String expectedStatus) {
        Spitter expected = SPITTERS[expectedSpitterIndex];
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getUsername(), actual.getUsername());
        Assert.assertEquals(expected.getPassword(), actual.getPassword());
        Assert.assertEquals(expected.getFullName(), actual.getFullName());
        Assert.assertEquals(expected.getEmail(), actual.getEmail());
        Assert.assertEquals(expected.isUpdateByEmail(), actual.isUpdateByEmail());
    }

    private static Spitter[] SPITTERS = new Spitter[6];

    @BeforeClass
    public static void before() {
        SPITTERS[0] = new Spitter(1L, "habuma", "password", "Craig Walls",
                "craig@habuma.com", false);
        SPITTERS[1] = new Spitter(2L, "mwalls", "password", "Michael Walls",
                "mwalls@habuma.com", true);
        SPITTERS[2] = new Spitter(3L, "chuck", "password", "Chuck Wagon",
                "chuck@habuma.com", false);
        SPITTERS[3] = new Spitter(4L, "artnames", "password", "Art Names",
                "art@habuma.com", true);
        SPITTERS[4] = new Spitter(5L, "newbee", "letmein", "New Bee",
                "newbee@habuma.com", true);
        SPITTERS[5] = new Spitter(4L, "arthur", "letmein", "Arthur Names",
                "arthur@habuma.com", false);
    }
}
