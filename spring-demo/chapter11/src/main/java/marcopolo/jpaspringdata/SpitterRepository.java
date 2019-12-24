package marcopolo.jpaspringdata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import marcopolo.jpaspringdata.domain.Spitter;


/**
 * Repository interface with operations for {@link Spitter} persistence.
 * @author habuma
 */
public interface SpitterRepository extends JpaRepository<Spitter, Long>, SpitterSweeper {
	  
	Spitter findByUsername(String username);
	
	List<Spitter> findByUsernameOrFullNameLike(String username, String fullName);

}
