package com.product.repository;

import com.product.model.ProductRelated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRelatedRepository extends JpaRepository<ProductRelated, Long> {
}
