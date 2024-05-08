package com.sparta.springbatch.domain.inventory.repository;

import com.sparta.springbatch.domain.inventory.entity.QInventory;
import com.sparta.springbatch.domain.product.entity.QProduct;
import com.sparta.springbatch.global.config.JpaConfig;
import com.sparta.springbatch.global.entity.Deleted;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class InventoryRepositoryCustomImpl implements InventoryRepositoryCustom{

	private final JpaConfig jpaConfig;

	private final EntityManager entityManager;

	@Transactional
	@Override
	public void updateInventory(){
		jpaConfig.jpaQueryFactory()
			.update(QProduct.product)
			.set(QProduct.product.quantity,QProduct.product.quantity.add(QInventory.inventory.quantity))
			.where(
				QInventory.inventory.deleted.eq(Deleted.UNDELETE)
			).execute();
		jpaConfig.jpaQueryFactory()
			.update(QInventory.inventory)
			.set(QInventory.inventory.deleted,Deleted.DELETE)
			.where(
				QInventory.inventory.deleted.eq(Deleted.UNDELETE)
			).execute();
		entityManager.flush();
		entityManager.clear();
	}
}
