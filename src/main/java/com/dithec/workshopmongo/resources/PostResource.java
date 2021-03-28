package com.dithec.workshopmongo.resources;


import com.dithec.workshopmongo.domain.Post;
import com.dithec.workshopmongo.domain.User;
import com.dithec.workshopmongo.dto.UserDTO;
import com.dithec.workshopmongo.resources.utils.URL;
import com.dithec.workshopmongo.services.PostService;
import com.dithec.workshopmongo.services.UserService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URLDecoder;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService service;


    @GetMapping("{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {

        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByIdTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);

        return ResponseEntity.ok().body(list);

    }
}
