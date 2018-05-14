package com.example.listty.repository;

import com.example.listty.model.Region;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegionRepository extends MongoRepository<Region,String> {

}
