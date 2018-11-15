package app.state;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends JpaRepository<State, String> {

	
}
