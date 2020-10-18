package br.com.deyvison.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.deyvison.workshopmongo.domain.Post;
import br.com.deyvison.workshopmongo.domain.User;
import br.com.deyvison.workshopmongo.repository.PostRepository;
import br.com.deyvison.workshopmongo.repository.UserRepository;

@Configuration
public class Instanciation implements CommandLineRunner{

	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post p1 = new Post(null, sdf.parse("18/07/2018"), "partiu Viagem", "Vou viajão para sp , abraços", maria);
		Post p2 = new Post(null, sdf.parse("15/03/2018"), "Bom dia", "Hoje eu acordei feliz!", maria);
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		postRepository.saveAll(Arrays.asList(p1,p2));
		
	}

}
