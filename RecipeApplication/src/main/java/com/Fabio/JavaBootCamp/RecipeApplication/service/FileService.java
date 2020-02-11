package com.Fabio.JavaBootCamp.RecipeApplication.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

@Service
public class FileService {
	
	public List<RecipePOJO> fileReader() throws IOException {
		Reader in = new FileReader("recipes.txt");
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withIgnoreSurroundingSpaces().parse(in);
		
		List<RecipePOJO> receipeList = new ArrayList<>();
		
		for (CSVRecord record : records) {
		    Integer cookMin = Integer.parseInt(record.get(0));
		    Boolean dairyFree = Boolean.parseBoolean(record.get(1));
		    Boolean glutenFree = Boolean.parseBoolean(record.get(2));
		    String inst = record.get(3);
		    Double prepMin = Double.parseDouble(record.get(4));
		    Double price = Double.parseDouble(record.get(5));
		    Integer readyInMin = Integer.parseInt(record.get(6));
		    Integer serv = Integer.parseInt(record.get(7));
		    Double spoon = Double.parseDouble(record.get(8));
		    String title = record.get(9);
		    Boolean vegan = Boolean.parseBoolean(record.get(10));
		    Boolean vegetarian = Boolean.parseBoolean(record.get(11));
		    
		    receipeList.add(new RecipePOJO(cookMin, dairyFree, glutenFree, inst, prepMin, price, readyInMin,
		    serv, spoon, title, vegan, vegetarian));
		    
		}
		return receipeList;
		
	}
	
}
