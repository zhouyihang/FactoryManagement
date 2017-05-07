package com.zyh.factory.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orderTable")
public class OrderEntity implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
    private Long orderId;
    @Column
    private String orderName;
    @Column
    private String orderStatus;
    @Column
    private Date expectDeliverDate;
    @Column
    private Date actualDeliverDate;
    @Column
    private String remark;
    
    @OneToMany(fetch=FetchType.LAZY, cascade=(CascadeType.ALL), mappedBy="order")
    private List<WorkEntity> orderWorks;
    

	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
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
	public List<WorkEntity> getOrderWorks() {
		return orderWorks;
	}
	public void setOrderWorks(List<WorkEntity> orderWorks) {
		this.orderWorks = orderWorks;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
    
    

}
