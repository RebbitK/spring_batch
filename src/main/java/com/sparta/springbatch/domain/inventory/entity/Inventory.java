package com.sparta.springbatch.domain.inventory.entity;

import com.sparta.springbatch.domain.product.entity.Product;
import com.sparta.springbatch.global.entity.Deleted;
import com.sparta.springbatch.global.entity.TimeStamped;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Inventory extends TimeStamped {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long quantity;

	@Enumerated(EnumType.STRING)
	private Deleted deleted;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;

}
