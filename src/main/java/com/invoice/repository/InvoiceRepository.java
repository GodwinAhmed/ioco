package com.invoice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.invoice.entity.InvoiceEntity;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Integer> {

	@SuppressWarnings("unchecked")
	InvoiceEntity save(InvoiceEntity invoice);

	List<InvoiceEntity> findAll();

	InvoiceEntity findById(Long id);
}