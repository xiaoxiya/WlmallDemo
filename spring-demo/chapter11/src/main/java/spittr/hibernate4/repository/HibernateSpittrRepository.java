package spittr.hibernate4.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import spittr.hibernate4.SpittrRepository;
import spittr.hibernate4.domain.Spitter;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;


/**
 * @author luopeng
 * @date 2019/11/17 20:08
 */
@Repository
public class HibernateSpittrRepository implements SpittrRepository {

    private SessionFactory sessionFactory;

    @Inject
    public HibernateSpittrRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public Spitter save(Spitter spitter) {
        Serializable id = currentSession().save(spitter);
        return new Spitter((Long) id,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail(),
                spitter.isUpdateByEmail());
    }

    @Override
    public Spitter findOne(long id) {
        return (Spitter) currentSession().get(Spitter.class, id);
    }

    @Override
    public Spitter findByUsername(String username) {
        return (Spitter) currentSession().createCriteria(Spitter.class).add(Restrictions.eq("username", username));
    }

    @Override
    public List<Spitter> findAll() {
        return (List<Spitter>) currentSession().createCriteria(Spitter.class).list();
    }
}
