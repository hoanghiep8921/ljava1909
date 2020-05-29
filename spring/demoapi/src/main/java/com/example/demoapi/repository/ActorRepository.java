package com.example.demoapi.repository;

import com.example.demoapi.model.Actor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends MongoRepository<Actor,String> {
//    @Query("id : {0},name:{1}")
//    Actor getAllActor(String id,String name);
}
