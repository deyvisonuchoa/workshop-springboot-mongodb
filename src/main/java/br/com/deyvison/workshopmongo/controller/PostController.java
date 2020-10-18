package br.com.deyvison.workshopmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.deyvison.workshopmongo.controller.util.URL;
import br.com.deyvison.workshopmongo.domain.Post;
import br.com.deyvison.workshopmongo.service.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostController {
	
	@Autowired
	public PostService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findAll(){
		List<Post> list = service.findAll();
		//List<PostDTO> listDTO = list.stream().map( u -> new PostDTO(u)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
		//text = URL.decodeParam(text);		
		List<Post> list = service.findByTitle(text);		
		return ResponseEntity.ok().body(list);
	}
	
}
