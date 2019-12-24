package marcopolo.jpahibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import marcopolo.jpahibernate.SpitterRepository;
import marcopolo.jpahibernate.domain.Spitter;


@Repository
public class JpaSpitterRepository implements SpitterRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public long count() {
		return findAll().size();
	}

	@Override
	public Spitter save(Spitter spitter) {
		entityManager.persist(spitter);
		return spitter;
	}

	@Override
	public Spitter findOne(long id) {
		return entityManager.find(Spitter.class, id);
	}

	@Override
	public Spitter findByUsername(String username) {		
		return (Spitter) entityManager.createQuery("select s from Spitter s where s.username=?").setParameter(1, username).getSingleResult();
	}

	@Override
	public List<Spitter> findAll() {
		return (List<Spitter>) entityManager.createQuery("select s from Spitter s").getResultList();
	}
	
}
