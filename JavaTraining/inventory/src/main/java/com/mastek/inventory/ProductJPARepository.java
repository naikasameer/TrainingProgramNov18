package com.mastek.inventory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductJPARepository extends CrudRepository<Product,Integer>{
	
}
