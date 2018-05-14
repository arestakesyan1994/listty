package com.example.listty.repository;

import com.example.listty.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    User findOneByEmail(String email);

    User findOneById(String id);
}
