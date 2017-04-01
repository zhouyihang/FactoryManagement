package com.zyh.factory.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productManagement")
public class ProductEntity {

    @Id
    @GeneratedValue
    private String productId;
    @Column
    private String productName;
    @Column
    private String productUnit;
    @Column
    private int speedQuantity;
    @Column
    private int speedSecond;
    @Embedded
    private List<ProductSourceEntity> productSourceEntity;
    
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductUnit() {
		return productUnit;
	}
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	public int getSpeedQuantity() {
		return speedQuantity;
	}
	public void setSpeedQuantity(int speedQuantity) {
		this.speedQuantity = speedQuantity;
	}
	public int getSpeedSecond() {
		return speedSecond;
	}
	public void setSpeedSecond(int speedSecond) {
		this.speedSecond = speedSecond;
	}
	public List<ProductSourceEntity> getProductSource() {
		return productSourceEntity;
	}
	public void setProductSource(List<ProductSourceEntity> productSourceEntity) {
		this.productSourceEntity = productSourceEntity;
	}

    
}
