package com.mastek.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class InventoryApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =
				SpringApplication.run(InventoryApplication.class, args);
		
		ProductAccessAPI productAPI = ctx.getBean(ProductAccessAPI.class);
		IngredientAccessAPI iAPI = ctx.getBean(IngredientAccessAPI.class);
		
		/*Product newProduct = new Product();
		newProduct.setName("Mouse");
		newProduct.setUnitPrice(2332);
		
		productAPI.addProduct(newProduct);
		
		for(Product p: productAPI.listProducts()) {
			System.out.println(p);
		}*/
		
		Ingredient i = new Ingredient();
		i.setAmount(2);
		i.setName("Pepper");
		
		//i = iAPI.add(i);
		
		productAPI.addNewIngredientToProduct(2, 2);
				
	}
}

