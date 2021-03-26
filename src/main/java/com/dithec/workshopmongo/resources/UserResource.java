package com.dithec.workshopmongo.resources;


import com.dithec.workshopmongo.domain.User;
import com.dithec.workshopmongo.dto.UserDTO;
import com.dithec.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService service;


    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {

//        User maria = new User("1", "Maria Miranda", "tadsdinael@gmail.com");
//        User alex = new User("1", "Alex Miranda", "tadsdinael@gmail.com");
//
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(item -> new UserDTO(item)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);
    }


}
