package com.Fabio.JavaBootCamp.RecipeApplication.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Fabio.JavaBootCamp.RecipeApplication.service.FileService;
import com.Fabio.JavaBootCamp.RecipeApplication.service.RecipePOJO;

@RestController
public class FileController {
	@Autowired
	private FileService fileService;
		 
	@GetMapping("/all-recipes")
	public List<RecipePOJO> readAllRecipes() throws IOException{
		List<RecipePOJO> fileReader = fileService.fileReader()
												  .stream()
												  .collect(Collectors.toList());
		return fileReader;
	}
	
	@GetMapping("/gluten-free")
	public List<RecipePOJO> readGlutenFree() throws IOException{
		List<RecipePOJO> fileReader = fileService.fileReader()
												  .stream()
												  .filter(o -> o.getGlutenFree().equals(true))
												  .collect(Collectors.toList());
		return fileReader;
	}

	@GetMapping("/vegan")
	public List<RecipePOJO> readVegan() throws IOException{
		List<RecipePOJO> fileReader = fileService.fileReader()
												  .stream()
												  .filter(o -> o.getVegan().equals(true))
												  .collect(Collectors.toList());
		return fileReader;
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<RecipePOJO> readVeganAndGlutenFree() throws IOException{
		List<RecipePOJO> fileReader = fileService.fileReader()
				  .stream()
				  .filter(o -> o.getVegan().equals(true)&& o.getGlutenFree().equals(true))
				  .collect(Collectors.toList());
		return fileReader;
	}

	@GetMapping("/vegetarian")
	public List<RecipePOJO> readVegetarian() throws IOException{
		List<RecipePOJO> fileReader = fileService.fileReader()
												  .stream()
												  .filter(o -> o.getVegetarian().equals(true))
												  .collect(Collectors.toList());
		return fileReader;
	}
		
}
