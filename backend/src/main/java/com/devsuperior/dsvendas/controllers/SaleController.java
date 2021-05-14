package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.services.SaleService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/sales")
@AllArgsConstructor
public class SaleController {
	
	private SaleService saleService;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO> sellerList = saleService.findAll(pageable);
		return ResponseEntity.ok(sellerList);
	}
	
	@GetMapping("/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller(){
		List<SaleSumDTO> list = saleService.amountGroupedBySeller();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller(){
		List<SaleSuccessDTO> list = saleService.successGroupedBySeller();
		return ResponseEntity.ok(list);
	}
}
