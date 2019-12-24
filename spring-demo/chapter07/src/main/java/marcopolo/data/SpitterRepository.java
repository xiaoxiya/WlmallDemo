package marcopolo.data;

import marcopolo.Spitter;

/**
 * @author luopeng
 * @date 2019/10/1 21:32
 */
public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}
