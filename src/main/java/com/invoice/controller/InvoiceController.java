package com.invoice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoice.entity.InvoiceEntity;
import com.invoice.service.InvoiceService;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
	
	@Autowired
    InvoiceService invoiceService;
	
	@PostMapping
	public ResponseEntity<InvoiceEntity> addInvoice(@RequestBody InvoiceEntity invoice) {		
		InvoiceEntity record = invoiceService.save(invoice);
		return new ResponseEntity<InvoiceEntity>(record, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<InvoiceEntity>> viewAllInvoices() {
		List<InvoiceEntity> list = invoiceService.getAllInvoices();
        return new ResponseEntity<List<InvoiceEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{invoiceId}")
	public ResponseEntity<InvoiceEntity> viewInvoice(@PathVariable Long invoiceId) {
		InvoiceEntity invoice = invoiceService.getInvoiceById(invoiceId);
		return new ResponseEntity<InvoiceEntity>(invoice, new HttpHeaders(), HttpStatus.OK);
	}
}