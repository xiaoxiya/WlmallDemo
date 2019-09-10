package profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author luopeng
 * @date 2019/9/10 15:10
 */


public class DataSourceConfigTest {

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes = DataSourceConfig.class)
    @ActiveProfiles("dev")
    public static class DataSourceConfigDevTest {
        @Autowired
        private DataSource dataSource;

        @Test
        public void test() {
           assertNotNull(dataSource);
           JdbcTemplate jdbc = new JdbcTemplate(dataSource);
           List<String> results = jdbc.query("select id, name from Things", new RowMapper<String>() {
               @Nullable
               public String mapRow(ResultSet resultSet, int i) throws SQLException {
                   return resultSet.getLong("id") + ":" + resultSet.getString("name");
               }
           });

           assertEquals(1,results.size());
           assertEquals("1:A", results.get(0));
       }

    }

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes = DataSourceConfig.class)
    @ActiveProfiles("prod")
    public static class DataSourceConfigProdTest {
        @Autowired
        private DataSource dataSource;

        @Test
        public void test() {
            assertNull(dataSource);
        }

    }

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration("classpath:profile/dataSourceConfig.xml")
    @ActiveProfiles("dev")
    public static class DataSourceConfigXmlDevTest {
        @Autowired
        private DataSource dataSource;

        @Test
        public void test() {
            assertNotNull(dataSource);
            JdbcTemplate jdbc = new JdbcTemplate(dataSource);
            List<String> results = jdbc.query("select id, name from Things", new RowMapper<String>() {
                @Nullable
                public String mapRow(ResultSet resultSet, int i) throws SQLException {
                    return resultSet.getLong("id") + ":" + resultSet.getString("name");
                }
            });

            assertEquals(1,results.size());
            assertEquals("1:A", results.get(0));
        }

    }

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration("classpath:profile/dataSourceConfig.xml")
    @ActiveProfiles("prod")
    public static class DataSourceConfigXmlProdTest {
        @Autowired(required = false)
        private DataSource dataSource;

        @Test
        public void test() {
            assertNull(dataSource);
        }

    }

}
