package com.zyh.factory.entity;

import java.sql.Date;
import javax.persistence.Column;
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
@Table(name = "workTable")
public class WorkEntity {

    @Id
    @GeneratedValue
    private long workId;
//    @Column
//    private String productId;
    @Column
    private String status;
    @Column
    private Date expectDeliverDate;
    @Column
    private Date planDeliverDate;
    @Column
    private Date actualDeliverDate;
    
    @ManyToOne
    private ProductEntity product;
    
    @ManyToOne
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getExpectDeliverDate() {
		return expectDeliverDate;
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

    

}