package com.dithec.workshopmongo.services;

import com.dithec.workshopmongo.domain.Post;
import com.dithec.workshopmongo.domain.User;
import com.dithec.workshopmongo.dto.UserDTO;
import com.dithec.workshopmongo.repository.PostRepository;
import com.dithec.workshopmongo.repository.UserRepository;
import com.dithec.workshopmongo.services.exception.ObjectNotFoundException;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public List<Post> findAll() {
        return repo.findAll();
    }

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
//
//    public List<Post> findByTitle(String text) {
//        return repo.findByTitleContainingIgnoreCase(text);
//    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }


}
