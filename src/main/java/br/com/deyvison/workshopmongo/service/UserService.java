package br.com.deyvison.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.deyvison.workshopmongo.domain.User;
import br.com.deyvison.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	public UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
