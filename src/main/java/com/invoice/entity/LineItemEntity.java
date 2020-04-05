package com.invoice.entity;

import java.math.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "lineitems")
public class LineItemEntity {
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(generator = "gen")
	private Long id;
	private Long quantity;
	private String description;
	private BigDecimal unitPrice;
	
	public Long getId() {
	    return this.id;
    }

    public void setId(Long id) {
    	this.id = id;
    }
    
	public Long getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public BigDecimal getLineItemTotal() {
		return this.unitPrice.multiply(new BigDecimal(this.quantity));
	}
}