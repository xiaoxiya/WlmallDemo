package spittr.jpaspringdata;

import spittr.jpaspringdata.domain.Spittle;

import java.util.List;



public interface SpittleRepositoryCustom {

  List<Spittle> findRecent();

  List<Spittle> findRecent(int count);

}