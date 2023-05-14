package dev.homechef.recipemanger.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.homechef.recipemanger.model.Recipe;
import dev.homechef.recipemanger.model.User;
import dev.homechef.recipemanger.service.RecipeService;
import dev.homechef.recipemanger.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	private RecipeService recipeService;
	
	public UserController(UserService userService, RecipeService recipeService) {
		this.userService = userService;
		this.recipeService = recipeService;
	}
	
	@GetMapping("/{Id}")
	public User getUserByID(@PathVariable String Id) {
		return userService.getUserById(Id);
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User insert(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PutMapping
	public User modify(@RequestBody User user) {
		Recipe recipe = recipeService.addRecipe(user.getRecipes().get(0));
		user.getRecipes().get(0).setId(recipe.getId());
		return userService.updateRecipe(user);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable String id) {
		return userService.deleteUser(id);
	}
}
