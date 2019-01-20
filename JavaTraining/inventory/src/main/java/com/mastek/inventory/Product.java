package com.mastek.inventory;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="SPRING_BOOT_PRODUCTS")
@XmlRootElement // enable Java Object to XML data 
public class Product {

	int productId;

	//GET: QueryParam(<name>)
	//POST: FormParam(<name>)
	@FormParam("name") 
	String name;
	
	@FormParam("price")
	double unitPrice;
	
	Set<Ingredient> ingredients =  new HashSet<>();
	
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="SPRING_BOOT_INGRED_CHARTS",
	joinColumns=@JoinColumn(name="FK_ProductID"),
	inverseJoinColumns=@JoinColumn(name="FK_IngredientId"))
	@XmlTransient
	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}	
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", unitPrice=" + unitPrice + "]";
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
}
