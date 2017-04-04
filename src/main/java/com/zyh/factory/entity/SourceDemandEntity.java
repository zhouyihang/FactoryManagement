package com.zyh.factory.entity;

import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Yihang
 *
 */
@Entity
@Table(name = "sourceDemand")
public class SourceDemandEntity {


    @Id
    @GeneratedValue
    private long demandId;
    @Column
    private long sourceId;
    @Column
    private String sourceName;
    @Column
    private int quantity;
    @Column
    private String sourceColor;
    @Column
    private String sourceUnit;
    @Column
    private BigDecimal totalPrice;
    @Column
    private String providerName;
    @Column
    private long workId;
    @Column
    private long orderId;
    @Column
    private String demandStatus;
    @Column
    private Date expectDeliverDate;
    @Column
    private Date actualDeliverDate;
    @Column
    private String demandRemark;
    @Column
    private String createBy;
    @Column
    private String deliveryBy;
    
    
	public long getDemandId() {
		return demandId;
	}
	public void setDemandId(long demandId) {
		this.demandId = demandId;
	}
	public long getWorkId() {
		return workId;
	}
	public void setWorkId(long workId) {
		this.workId = workId;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getDemandStatus() {
		return demandStatus;
	}
	public void setDemandStatus(String demandStatus) {
		this.demandStatus = demandStatus;
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
	public String getDemandRemark() {
		return demandRemark;
	}
	public void setDemandRemark(String demandRemark) {
		this.demandRemark = demandRemark;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getDeliveryBy() {
		return deliveryBy;
	}
	public void setDeliveryBy(String deliveryBy) {
		this.deliveryBy = deliveryBy;
	}
	public long getSourceId() {
		return sourceId;
	}
	public void setSourceId(long sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceColor() {
		return sourceColor;
	}
	public void setSourceColor(String sourceColor) {
		this.sourceColor = sourceColor;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSourceUnit() {
		return sourceUnit;
	}
	public void setSourceUnit(String sourceUnit) {
		this.sourceUnit = sourceUnit;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
    
    
}
