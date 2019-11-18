package spittr.jpaspringdata;

import spittr.jpaspringdata.domain.Spittle;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



public class SpittleRepositoryImpl implements SpittleRepositoryCustom {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<Spittle> findRecent() {
    return findRecent(10);
  }

  @Override
  public List<Spittle> findRecent(int count) {
    return (List<Spittle>) entityManager.createQuery("select s from Spittle s order by s.postedTime desc")
        .setMaxResults(count)
        .getResultList();
  }
  
}
