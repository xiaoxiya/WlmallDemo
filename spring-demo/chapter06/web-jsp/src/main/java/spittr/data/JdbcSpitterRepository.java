package spittr.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import spittr.Spitter;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author luopeng
 * @date 2019/10/4 16:40
 */
@Repository
public class JdbcSpitterRepository implements SpitterRepository {

    private JdbcOperations jdbc;

    @Autowired
    public JdbcSpitterRepository(JdbcOperations jdbc){
        this.jdbc = jdbc;
    }

    public Spitter save(Spitter spitter) {
        jdbc.update("insert into Spitter (username, password, first_name, last_name, email) " +
                "values (?, ?, ?, ?, ?)",
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFirstName(),
                spitter.getLastName(),
                spitter.getEmail());
        return spitter;
    }

    public Spitter findByUsername(String username) {
        return jdbc.queryForObject("select id, username, password, first_name, email from Spitter where username = ?", new SpitterRowMapper(), username);
    }

    private static class SpitterRowMapper implements RowMapper<Spitter> {

        public Spitter mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Spitter( resultSet.getLong("id"),
                                resultSet.getString("username"),
                                null,
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name"),
                                resultSet.getString("email"));

        }
    }
}
