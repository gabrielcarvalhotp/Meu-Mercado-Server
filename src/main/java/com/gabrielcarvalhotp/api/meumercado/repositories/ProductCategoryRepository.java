package com.gabrielcarvalhotp.api.meumercado.repositories;

import com.gabrielcarvalhotp.api.meumercado.domains.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, UUID> {
    @Query("select pc from ProductCategory pc order by pc.ordernation")
    List<ProductCategory> findAllOrdered();
}
