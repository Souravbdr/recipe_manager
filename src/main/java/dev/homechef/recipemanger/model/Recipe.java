package dev.homechef.recipemanger.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Recipe {
	
	@Id
	private String id;
	private String title;
	private String description;
	private String ingredients;
}
