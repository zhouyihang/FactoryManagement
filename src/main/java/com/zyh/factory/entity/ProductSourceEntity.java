package com.zyh.factory.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Yihang
 *
 */
@Entity
@Table(name = "productSource")
public class ProductSourceEntity {

//    @Column
//    private String sourceId;
    @Id
    @GeneratedValue
    private long productSourceId;
    @Column
    private long quantity;
    @ManyToOne
    @JsonIgnore
    private ProductEntity product;
    @ManyToOne
    private SourceEntity source;
    
//	public String getSourceId() {
//		return sourceId;
//	}
//	public void setSourceId(String sourceId) {
//		this.sourceId = sourceId;
//	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public SourceEntity getSource() {
		return source;
	}
	public void setSource(SourceEntity source) {
		this.source = source;
	}
	public long getProductSourceId() {
		return productSourceId;
	}
	public void setProductSourceId(long productSourceId) {
		this.productSourceId = productSourceId;
	}
	public ProductEntity getProduct() {
		return product;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
    

}
