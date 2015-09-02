package br.com.fiorilli.proj04.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import br.com.fiorilli.proj04.daos.CategoryDao;	
import br.com.fiorilli.proj04.models.Category;	
import br.com.fiorilli.proj04.models.Product;	
import br.com.fiorilli.proj04.daos.ProductDao;	


@Model
@Transactional
public class ProductController {
	
	@Inject
	private ProductDao productDao;
	private Product product = new Product();
	private List<Product> products = new ArrayList<>();
	
	@Inject
	private CategoryDao categoryDao;
	private List<Category> categories = new ArrayList<>();
	
	private Integer idToEdit;
	
	public Integer getIdToEdit() {
		return idToEdit;
	}

	public void setIdToEdit(Integer idToEdit) {
		this.idToEdit = idToEdit;
	}
	
	public List<Product> getProducts(){
		return this.products;
	}
	
	public List<Category> getCategories(){
		return this.categories;
	}	
		
	public void setProduct(Product product){
		this.product = product;
	}
	
	public Product getProduct(){
		return this.product;
	}
	
	@PostConstruct
	private void postConstruct() {
		products.addAll(productDao.all());
		categories.addAll(categoryDao.all());
		product.setCategory(new Category());
	}	
	
	public void loadDetails(){
		this.product = productDao.findById(idToEdit);
	}
	
	public String save() {
		productDao.save(product);
		return "/products/list?faces-redirect=true";
	}

	public String update(Integer id) {
		product.setId(id);
		productDao.update(product);
		return "/products/list?faces-redirect=true";
	}

	public String remove(Integer id) {
		Product product = productDao.findById(id);
		productDao.remove(product);
		return "/products/list?faces-redirect=true";
	}		
	
	

}
