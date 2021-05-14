package com.devsuperior.dsvendas.dto;

import java.time.LocalDate;

import com.devsuperior.dsvendas.entities.Sale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaleDTO {
	
	private Long id;	
	private Integer visited;
	private Integer deals;
	private Double amount;
	private LocalDate date;
	
	private SellerDTO sellerDTO;
	
	public SaleDTO(Sale entity) {
		id = entity.getId();
		visited = entity.getVisited();
		deals = entity.getDeals();
		amount = entity.getAmount();
		date = entity.getDate();
		sellerDTO = new SellerDTO(entity.getSeller());
	}
}
