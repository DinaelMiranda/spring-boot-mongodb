package com.dithec.workshopmongo.config;

import com.dithec.workshopmongo.domain.User;
import com.dithec.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;

@Configuration//toda vez que iniciar o projeto o spring vai executar os comandos dessa classe de configuração
public class instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));

    }
}
