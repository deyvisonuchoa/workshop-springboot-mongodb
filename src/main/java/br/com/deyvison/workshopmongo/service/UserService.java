package br.com.deyvison.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.deyvison.workshopmongo.domain.User;
import br.com.deyvison.workshopmongo.dto.UserDTO;
import br.com.deyvison.workshopmongo.repository.UserRepository;
import br.com.deyvison.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	public UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException("Usuario não encontrado") );
	}
	
	public User insert(User user) {
		return repo.save(user);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User updateUser(User user) {
		User newUser = findById(user.getId());
		updateData(user, newUser);
		return repo.save(newUser);
	}

	private void updateData(User user, User newUser) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}
}
