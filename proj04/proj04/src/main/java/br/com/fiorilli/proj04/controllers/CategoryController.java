package br.com.fiorilli.proj04.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import br.com.fiorilli.proj04.daos.CategoryDao;	
import br.com.fiorilli.proj04.models.Category;	


@Model
@Transactional
public class CategoryController {
	
	@Inject
	private CategoryDao categoryDao;
	private Category category = new Category();
	private List<Category> categories = new ArrayList<>();
	
	
	private Integer idToEdit;
	
	public Integer getIdToEdit() {
		return idToEdit;
	}

	public void setIdToEdit(Integer idToEdit) {
		this.idToEdit = idToEdit;
	}
	
	public List<Category> getCategories(){
		return this.categories;
	}
	
		
	public void setCategory(Category category){
		this.category = category;
	}
	
	public Category getCategory(){
		return this.category;
	}
	
	@PostConstruct
	private void postConstruct() {
		categories.addAll(categoryDao.all());
	}	
	
	public void loadDetails(){
		this.category = categoryDao.findById(idToEdit);
	}
	
	public String save() {
		categoryDao.save(category);
		return "/categories/list?faces-redirect=true";
	}

	public String update(Integer id) {
		category.setId(id);
		categoryDao.update(category);
		return "/categories/list?faces-redirect=true";
	}

	public String remove(Integer id) {
		Category category = categoryDao.findById(id);
		categoryDao.remove(category);
		return "/categories/list?faces-redirect=true";
	}		
	
	

}
