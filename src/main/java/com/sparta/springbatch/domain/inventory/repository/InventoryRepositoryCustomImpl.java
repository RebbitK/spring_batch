package com.sparta.springbatch.domain.inventory.repository;

import com.sparta.springbatch.global.config.JpaConfig;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class InventoryRepositoryCustomImpl implements InventoryRepositoryCustom{

	private final JpaConfig jpaConfig;

	private final EntityManager entityManager;
}
