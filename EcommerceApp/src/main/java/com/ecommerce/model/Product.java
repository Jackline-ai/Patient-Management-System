package com.ecommerce.model;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long productId;
	
private String productName;
@ManyToOne
@JoinColumn(name = "category_id", referencedColumnName = "categoryId")
@JsonIgnore
private ProductCategory category;

private String description;
private double unitPrice;
private double costPrice;
private int quantityInStock;
private int reorderLevel;
private Long supplierId;
private String barcode;

@Temporal(TemporalType.TIMESTAMP)
private Date createdAt;

@Temporal(TemporalType.TIMESTAMP)
private Date updatedAt;


@PrePersist
protected void oncreate() {
	createdAt = new Date();
	updatedAt = new Date ();
}


@PreUpdate
private void onUpdate() {
	updatedAt = new Date();
}

public Long getProductId() {
	return productId;
}

public void setProductId(Long productId) {
	this.productId = productId;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public double getUnitPrice() {
	return unitPrice;
}

public void setUnitPrice(double unitPrice) {
	this.unitPrice = unitPrice;
}

public double getCostPrice() {
	return costPrice;
}

public void setCostPrice(double costPrice) {
	this.costPrice = costPrice;
}

public int getQuantityInStock() {
	return quantityInStock;
}

public void setQuantityInStock(int quantityInStock) {
	this.quantityInStock = quantityInStock;
}

public int getReorderLevel() {
	return reorderLevel;
}

public void setReorderLevel(int reorderLevel) {
	this.reorderLevel = reorderLevel;
}

public Long getSupplierId() {
	return supplierId;
}

public void setSupplierId(Long supplierId) {
	this.supplierId = supplierId;
}

public String getBarcode() {
	return barcode;
}

public void setBarcode(String barcode) {
	this.barcode = barcode;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}

public ProductCategory category() {
	return category;
}
public void setProductCategory(ProductCategory category) {
	this.category = category;
}




}
