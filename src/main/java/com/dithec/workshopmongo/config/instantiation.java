package com.dithec.workshopmongo.config;

import com.dithec.workshopmongo.domain.Post;
import com.dithec.workshopmongo.domain.User;
import com.dithec.workshopmongo.dto.AuthorDTO;
import com.dithec.workshopmongo.dto.CommentDTO;
import com.dithec.workshopmongo.repository.PostRepository;
import com.dithec.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.jws.soap.SOAPBinding;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration//toda vez que iniciar o projeto o spring vai executar os comandos dessa classe de configuração
public class instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        //Incluiu os Usuários
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        //Salvou os Usuários
        userRepository.saveAll(Arrays.asList(maria,alex,bob));

        //Incluiu os posts
        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São paulo.Abraçõs", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        //Inclui os COmentários
        CommentDTO comment1 = new CommentDTO("Boa Viagem Mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO comment2 = new CommentDTO("Aproveite!", sdf.parse("22/03/2018"), new AuthorDTO(alex));
        CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));

        //Inclui os comentários dentros dos posts
        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().addAll(Arrays.asList(comment3));

        //Slavou os Posts
        postRepository.saveAll(Arrays.asList(post1, post2));

        //Incluiu os posts no Usuário Maria
        maria.getPosts().addAll(Arrays.asList(post1, post2));
        //Salvou os posts no user mario
        userRepository.save(maria);



    }
}
