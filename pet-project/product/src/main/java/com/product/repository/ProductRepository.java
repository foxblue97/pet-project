package com.product.repository;

import com.product.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select p from Product p where p.name = ?1")
    Product findProductByName(String name);

    @Query(value = "select p from Product p where p.name = :name and (:id is null or :id != p.id)")
    Product existsByName(String name,Long id);

    List<Product> findAllByIds(Iterable<Long> ids);
}
