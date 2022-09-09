package com.devstefane.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devstefane.dsmeta.entities.Sale;
import com.devstefane.dsmeta.repositories.SaleRepository;


@Service
public class SalesService {

	@Autowired
	private SaleRepository repository;
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = minDate.equals("") ? today.minusYears(1): LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today: LocalDate.parse(maxDate);
		
		return repository.findSales(min, max, pageable);
	}
	
}
