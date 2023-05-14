package dev.homechef.recipemanger.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.homechef.recipemanger.model.User;
import dev.homechef.recipemanger.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User createUser(User user) {
		
		user.setId(UUID.randomUUID().toString().split("-")[0]);
		System.out.println(user.toString());
		userRepository.save(user);
		return user;
	}

	public User getUserById(String Id) {
		return userRepository.findById(Id).get();
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User updateRecipe(User user) {
		User existing = userRepository.findById(user.getId()).get();
		existing.setRecipes(user.getRecipes());
		userRepository.save(existing);
		return existing;
	}

	public String deleteUser(String id) {
		userRepository.deleteById(id);
		return id;
	}
}
