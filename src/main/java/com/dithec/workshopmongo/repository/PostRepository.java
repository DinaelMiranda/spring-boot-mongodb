package com.dithec.workshopmongo.repository;

import com.dithec.workshopmongo.domain.Post;
import com.dithec.workshopmongo.domain.User;
import javafx.geometry.Pos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
