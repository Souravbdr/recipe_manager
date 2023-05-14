package dev.homechef.recipemanger.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.homechef.recipemanger.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}
