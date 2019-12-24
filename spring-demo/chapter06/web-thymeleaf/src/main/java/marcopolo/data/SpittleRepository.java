package marcopolo.data;

import marcopolo.Spittle;

import java.util.List;

/**
 * @author luopeng
 * @date 2019/9/28 20:29
 */
public interface SpittleRepository {
    /**
     *
     * @param max 所返回的 Spittle中，Spittle ID属性的最大值
     * @param count 要返回 多少个Spittle对象
     * @return
     */
    List<Spittle> findSpittles(long max, int count);

    List<Spittle> findRecentSpittles();

    Spittle findOne(long id);

    void save(Spittle spittle);
}
