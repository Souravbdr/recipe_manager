package dev.homechef.recipemanger.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.homechef.recipemanger.model.Recipe;
import dev.homechef.recipemanger.repository.RecipeRepository;

@Service
public class RecipeService {

	private RecipeRepository recipeRepository;

	public RecipeService(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	public Recipe getRecipeById(String Id) {
		return recipeRepository.findById(Id).get();
	}

	public Recipe addRecipe(Recipe recipe) {
		recipe.setId(UUID.randomUUID().toString().split("-")[0]);
		recipeRepository.save(recipe);
		return recipe;
	}

	public List<Recipe> getAllRecipe() {
		return recipeRepository.findAll();
	}

	public Recipe updateRecipe(Recipe recipe) {
		Recipe existing = recipeRepository.findById(recipe.getId()).get();
		existing.setTitle(recipe.getTitle());
		existing.setDescription(recipe.getDescription());
		existing.setIngredients(recipe.getIngredients());
		recipeRepository.save(existing);
		return existing;
	}

	public String deleteRecipe(String id) {
		recipeRepository.deleteById(id);
		return id;
	}
}
