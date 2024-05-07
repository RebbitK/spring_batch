package com.sparta.springbatch.domain.inventory.repository;

import com.sparta.springbatch.domain.inventory.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long>,InventoryRepositoryCustom {

}

