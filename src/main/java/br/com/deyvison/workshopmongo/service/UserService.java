package br.com.deyvison.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.deyvison.workshopmongo.domain.User;
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
}
