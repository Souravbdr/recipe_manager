package dev.homechef.recipemanger.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	public String id;
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	@DBRef
	private List<Recipe> recipes;
}
