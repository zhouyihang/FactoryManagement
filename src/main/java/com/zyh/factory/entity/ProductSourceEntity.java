package com.zyh.factory.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductSourceEntity {

    @Column
    private String sourceId;
    @Column
    private long quantity;
    @Column
    private String unit;
    
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
    

}
