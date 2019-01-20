package com.mastek.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IngredientAccessAPI {
	
	IngredientJPARepository repository;
	
	
	
	public IngredientJPARepository getRepository() {
		return repository;
	}


	@Autowired
	public void setRepository(IngredientJPARepository repository) {
		this.repository = repository;
	}


	public Ingredient findById(int id) {
		return getRepository().findById(id).get(); 
	}
	
	public Ingredient add(Ingredient i) {
		return getRepository().save(i);
	}

}
