package com.invoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.invoice.entity.InvoiceEntity;
import com.invoice.repository.InvoiceRepository;

@Service
public class InvoiceService {
	
	@Autowired
    InvoiceRepository repository;
	
	public List<InvoiceEntity> getAllInvoices() {
	    return repository.findAll();
    }
    
    public InvoiceEntity save(InvoiceEntity invoice) {
    	repository.save(invoice);
		return invoice;
    }
     
    public InvoiceEntity getInvoiceById(Long id) {
    	InvoiceEntity invoice = repository.findById(id);
        return invoice;
    }
}