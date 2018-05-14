package com.example.listty.repository;

import com.example.listty.model.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ListRepository extends MongoRepository<List,String> {

}
