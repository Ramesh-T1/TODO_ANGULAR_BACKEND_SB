package TODO.SB_Angular.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TODO.SB_Angular.entities.TODO;

@Repository
public interface ToDoRepository extends JpaRepository<TODO,Long> {

	List<TODO> findAll();
	TODO findById(Integer data_id);
	void deleteById(Integer data_id);
	
}
