package com.zyh.factory.entity;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name = "workTable")
public class WorkEntity  implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long workId;
//    @Column
//    private String productId;
    @Column
    private String workStatus;
    @Column
    private int quantity;
    @Column
    private Date expectDeliverDate;
    @Column
    private Date planDeliverDate;
    @Column
    private Date actualDeliverDate;
    @Column
    private String remark;
    
    @ManyToOne
    private ProductEntity product;
    
    @ManyToOne(fetch=FetchType.LAZY,cascade=(CascadeType.ALL))
    @JsonIgnore
    private OrderEntity order;
    
	public long getWorkId() {
		return workId;
	}
	public void setWorkId(long workId) {
		this.workId = workId;
	}
//	public String getProductId() {
//		return productId;
//	}
//	public void setProductId(String productId) {
//		this.productId = productId;
//	}

	public Date getExpectDeliverDate() {
		return expectDeliverDate;
	}
	public String getWorkStatus() {
		return workStatus;
	}
	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}
	public void setExpectDeliverDate(Date expectDeliverDate) {
		this.expectDeliverDate = expectDeliverDate;
	}
	public Date getActualDeliverDate() {
		return actualDeliverDate;
	}
	public void setActualDeliverDate(Date actualDeliverDate) {
		this.actualDeliverDate = actualDeliverDate;
	}
	public Date getPlanDeliverDate() {
		return planDeliverDate;
	}
	public void setPlanDeliverDate(Date planDeliverDate) {
		this.planDeliverDate = planDeliverDate;
	}
	public OrderEntity getOrder() {
		return order;
	}
	public void setOrder(OrderEntity order) {
		this.order = order;
	}
	public ProductEntity getProduct() {
		return product;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

    

}