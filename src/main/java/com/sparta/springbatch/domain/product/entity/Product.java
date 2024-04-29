package com.sparta.springbatch.domain.product.entity;

import com.sparta.springbatch.domain.store.entity.Store;
import com.sparta.springbatch.global.entity.Deleted;
import com.sparta.springbatch.global.entity.TimeStamped;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(indexes = {@Index(name = "idx_product_id",columnList = "id")})
public class Product extends TimeStamped {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String productName;

	private String info;

	private Long realPrice;

	private Long price;

	private Long discount;

	private Long quantity;

	@Enumerated(EnumType.STRING)
	private Deleted deleted;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	private Store store;

	public void update(){
		this.price = 12345678L;
	}
}
