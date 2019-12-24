package marcopolo.jpaspringdata;

import marcopolo.jpaspringdata.domain.Spittle;

import java.util.List;



public interface SpittleRepositoryCustom {

  List<Spittle> findRecent();

  List<Spittle> findRecent(int count);

}