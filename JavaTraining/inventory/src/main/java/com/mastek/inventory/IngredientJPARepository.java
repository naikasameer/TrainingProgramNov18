package com.mastek.inventory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface IngredientJPARepository extends CrudRepository<Ingredient, Integer>{

}
