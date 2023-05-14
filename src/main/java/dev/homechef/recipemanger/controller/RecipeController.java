package dev.homechef.recipemanger.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import dev.homechef.recipemanger.model.Recipe;
import dev.homechef.recipemanger.service.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

	private RecipeService recipeService;

	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@GetMapping("/{Id}")
	public Recipe getByID(@PathVariable String Id) {
		return recipeService.getRecipeById(Id);
	}

	@GetMapping
	public List<Recipe> getAll() {
		return recipeService.getAllRecipe();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Recipe insert(@RequestBody Recipe recipe) {
		return recipeService.addRecipe(recipe);
	}

	@PutMapping
	public Recipe modify(@RequestBody Recipe recipe) {
		return recipeService.updateRecipe(recipe);
	}

	@DeleteMapping("/{id}")
	public String deleteRecipe(@PathVariable String id) {
		return recipeService.deleteRecipe(id);
	}

}
