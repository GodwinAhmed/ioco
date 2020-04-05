package com.invoice.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class InvoiceEntity extends LineItemEntity {
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(generator = "gen")
	private Long id;
	private String client;
	private Long vatRate;
	private Date invoiceDate;
	
	public Long getId() {
	    return this.id;
    }

    public void setId(Long id) {
    	this.id = id;
    }
  
	public String getClient() {
		return client;
	}
	
	public void setClient(String client) {
		this.client = client;
	}
	
	public Long getVatRate() {
		return vatRate;
	}
	
	public void setVatRate(Long vatRate) {
		this.vatRate = vatRate;
	}
	
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	
	public BigDecimal getSubTotal() {
		return this.getLineItemTotal();
	}
	
	public BigDecimal getVat() {
		return this.getSubTotal().multiply(new BigDecimal(this.getVatRate()));
	}
	
	public BigDecimal getTotal() {
		return this.getSubTotal().add(this.getVat());
	}
}
