package br.com.deyvison.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.deyvison.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

	
}
