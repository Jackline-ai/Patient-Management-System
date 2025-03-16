package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.Product;
import com.ecommerce.model.ProductCategory;
import com.ecommerce.repository.CategoryRepository;
import com.ecommerce.repository.ProductRepository;

@Service
public class ProductManagementService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public ProductCategory createCategoryWithProducts(ProductCategory category) {
	category.getProducts().forEach(product -> product.setProductCategory(category));
	return categoryRepository.save(category);
    }

    public ProductCategory addProductToCategory(String CategoryName, List<Product> newProducts) {
	ProductCategory category = categoryRepository.findByCategoryName(CategoryName)
		.orElseThrow(() -> new RuntimeException("Category not found"));

	category.getProducts().addAll(newProducts);
	return categoryRepository.save(category);

    }

    public List<ProductCategory> getAllCategories() {
	return categoryRepository.findAll();
    }

    public List<Product> getAllProducts() {
	return productRepository.findAll();
    }

    public void deleteCategoryById(Long categoryId) {
	categoryRepository.deleteById(categoryId);
    }

}
