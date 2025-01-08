package TODO.SB_Angular.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import TODO.SB_Angular.entities.TODO;
import TODO.SB_Angular.repositories.ToDoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class ToDoService {
	@Autowired
	ToDoRepository todoRepo;

	public List<TODO> getAllToDo(String username) {
		return todoRepo.findAll();
	}

	public TODO save(@Valid TODO td) {
		return todoRepo.save(td);
	}

	public void deleteById(int data_id) {
		todoRepo.deleteById(data_id);	
	}

	public TODO findTODOByID(Integer data_id) {
		return todoRepo.findById(data_id);
	}	
}
