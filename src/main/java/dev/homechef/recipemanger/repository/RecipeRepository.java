package dev.homechef.recipemanger.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.homechef.recipemanger.model.Recipe;

public interface RecipeRepository extends MongoRepository<Recipe, String>{
	
}
