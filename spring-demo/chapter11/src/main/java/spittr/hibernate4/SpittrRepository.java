package spittr.hibernate4;

import spittr.hibernate4.domain.Spitter;

import java.util.List;

/**
 * @author luopeng
 * @date 2019/11/17 20:10
 */
public interface SpittrRepository {
    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();
}
