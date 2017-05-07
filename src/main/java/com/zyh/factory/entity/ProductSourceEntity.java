package com.zyh.factory.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class ProductSourceEntity  implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//    @Column
//    private String sourceId;
    @Id
    @GeneratedValue
    private long productSourceId;
    @Column
    private int quantity;
    @Column
    private String sourceColor;
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    private ProductEntity product;
    @ManyToOne(cascade=(CascadeType.ALL))
    private SourceEntity source;
    
//	public String getSourceId() {
//		return sourceId;
//	}
//	public void setSourceId(String sourceId) {
//		this.sourceId = sourceId;
//	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
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

	public String getSourceColor() {
		return sourceColor;
	}
	public void setSourceColor(String sourceColor) {
		this.sourceColor = sourceColor;
	}

}
