package br.com.deyvison.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.deyvison.workshopmongo.domain.Post;
import br.com.deyvison.workshopmongo.repository.PostRepository;
import br.com.deyvison.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	public PostRepository repo;
	
	public List<Post> findAll(){
		return repo.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException("Post não encontrado") );
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
}
