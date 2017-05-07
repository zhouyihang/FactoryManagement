package com.zyh.factory.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "productTable")
public class ProductEntity  implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long productId;
    @Column
    private String productName;
    @Column
    private String productUnit;
    @Column
    private int speedQuantity;
    @Column
    private int speedSecond;
    
    @OneToMany(cascade=(CascadeType.ALL), mappedBy="product")
    private List<ProductSourceEntity> productSource;
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="product")
    @JsonIgnore
    private List<WorkEntity> work;
    

	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
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
		return productSource;
	}
	public void setProductSource(List<ProductSourceEntity> productSource) {
		this.productSource = productSource;
	}
	public List<WorkEntity> getWork() {
		return work;
	}
	public void setWork(List<WorkEntity> work) {
		this.work = work;
	}


    
}
