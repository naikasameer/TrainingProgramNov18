package com.mastek.inventory;

import java.util.Set;

import javax.transaction.Transactional;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/products/")
public class ProductAccessAPI {

	ProductJPARepository repository;

	public ProductJPARepository getRepository() {
		return repository;
	}

	@Autowired
	public void setRepository(ProductJPARepository repository) {
		this.repository = repository;
	}
	
	IngredientJPARepository ingredRepository;
	
	public IngredientJPARepository getIngredRepository() {
		return ingredRepository;
	}

	@Autowired
	public void setIngredRepository(IngredientJPARepository ingredRepository) {
		this.ingredRepository = ingredRepository;
	}

	// Url: http://localhost:9900/products/list
	@Path("/list")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Iterable<Product> listProducts(){
		return getRepository().findAll();
	}
	
	@POST
	@Path("/register")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	public Product addProduct(@BeanParam Product newProduct) {
		getRepository().save(newProduct);
		return newProduct;
	}

	@DELETE
	@Path("/delete")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Product deleteProduct(int productId) {
		Product deleteProduct = getRepository().findById(productId).get();
		System.out.println(deleteProduct);
		getRepository().delete(deleteProduct);
		return deleteProduct;
	}
	
	 // ensure all the operations are done as one unit of transaction
	@Transactional // within the same session
	public void addNewIngredientToProduct(int productId, int ingredId) {
		Ingredient i = getIngredRepository().findById(ingredId).get();
		Product p = getRepository().findById(productId).get();
		
		if(!p.getIngredients().contains(i)) {
			p.getIngredients().add(i);
		}
		//i.getProducts().add(p);
		getRepository().save(p);
	} 
	
	@Transactional
	public Set<Ingredient> getIngredients(int productId){
		Product p = getRepository().findById(productId).get();
		
		if(!p.getIngredients().isEmpty()) {
			return p.getIngredients();
		}else {
			return null;
		}
	}
	
	
	
	
	
}
