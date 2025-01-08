package TODO.SB_Angular.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import TODO.SB_Angular.entities.TODO;
import TODO.SB_Angular.service.ToDoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoController {
	@Autowired
	ToDoService todoService;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/users/{username}/todos")
	public List<TODO> getAllToDo(@PathVariable("username") String name) {
		return todoService.getAllToDo(name);

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/users/{username}/addToDo")
	@Transactional
	public ResponseEntity<TODO> saveTodo(@Valid @RequestBody TODO td) {
		// return todoService.save(td);
		TODO savedTodo = todoService.save(td); // Save and retrieve the saved object
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedTodo.getId())
				.toUri();
		return ResponseEntity.created(location).body(savedTodo);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(path = "/users/{username}/todos/{id}")
	@Transactional
	public ResponseEntity<Void> deleteTodo(@PathVariable("id") int data_id) {
		todoService.deleteById(data_id);
		return ResponseEntity.noContent().build();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(path = "/users/{username}/todos_update/{id}")
	@Transactional
	public ResponseEntity<TODO> updateTodo(@Valid @RequestBody TODO td, @PathVariable("id") Integer data_id) {
		if (data_id != null) {
			TODO temp = todoService.findTODOByID(data_id);
			if(temp==null) {
				return ResponseEntity.notFound().build();
			}
			temp = td;
			todoService.save(temp);
			return ResponseEntity.ok(temp);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
