package com.zyh.factory.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 * @author Yihang
 *
 */
@Entity
@Table(name = "sourceTable")
public class SourceEntity  implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long sourceId;
    @Column
    private String sourceName;
    @Column
    private String sourceCode;
    @Column
    private BigDecimal price;
    @Column
    private String sourceUnit;
    @Column
    private String providerName;
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="source", cascade=(CascadeType.ALL))
    @JsonIgnore
    private List<ProductSourceEntity> productSource;

    
	public long getSourceId() {
		return sourceId;
	}
	public void setSourceId(long sourceId) {
		this.sourceId = sourceId;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getSourceUnit() {
		return sourceUnit;
	}
	public void setSourceUnit(String sourceUnit) {
		this.sourceUnit = sourceUnit;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public List<ProductSourceEntity> getProductSource() {
		return productSource;
	}
	public void setProductSource(List<ProductSourceEntity> productSource) {
		this.productSource = productSource;
	}
	public String getSourceCode() {
		return sourceCode;
	}
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

    
}
