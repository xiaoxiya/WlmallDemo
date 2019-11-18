package spittr.hibernate4.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import spittr.hibernate4.SpittleRepository;
import spittr.hibernate4.domain.Spittle;

import java.io.Serializable;
import java.util.List;

/**
 * @author luopeng
 * @date 2019/11/17 20:19
 */
@Repository
public class HibernateSpittleRepository implements SpittleRepository {

    private SessionFactory sessionFactory;

    public HibernateSpittleRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    private Criteria spittleCriteria() {
        return currentSession()
                .createCriteria(Spittle.class)
                .addOrder(Order.desc("postedTime"));
    }

    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public List<Spittle> findRecent() {
        return findRecent(10);
    }

    @Override
    public List<Spittle> findRecent(int count) {
        return (List<Spittle>) spittleCriteria()
                .setMaxResults(count)
                .list();
    }

    @Override
    public Spittle findOne(long id) {
        return (Spittle) currentSession().get(Spittle.class, id);
    }

    @Override
    public Spittle save(Spittle spittle) {
        Serializable id = currentSession().save(spittle);
        return new Spittle((Long) id,
                spittle.getSpitter(),
                spittle.getMessage(),
                spittle.getPostedTime());
    }

    @Override
    public List<Spittle> findBySpitterId(long spitterId) {
        return spittleCriteria().add(Restrictions.eq("spitter.id", spitterId)).list();
    }

    @Override
    public void delete(long id) {
        currentSession().delete(findOne(id));
    }

    @Override
    public List<Spittle> findAll() {
        return spittleCriteria().list();
    }
}
