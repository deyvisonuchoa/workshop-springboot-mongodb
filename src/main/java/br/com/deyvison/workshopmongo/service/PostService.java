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
		return obj.orElseThrow( () -> new ObjectNotFoundException("Usuario não encontrado") );
	}
	
	public Post insert(Post user) {
		return repo.save(user);
	}
	
//	public Post fromDTO(PostDTO objDto) {
//		return new Post(objDto.getId(), objDto.getName(), objDto.getEmail());
//	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Post updatePost(Post user) {
		Post newPost = findById(user.getId());
		updateData(user, newPost);
		return repo.save(newPost);
	}

	private void updateData(Post user, Post newPost) {
//		newPost.setName(user.getName());
//		newPost.setEmail(user.getEmail());
	}
}
