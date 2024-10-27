package com.services.ms.product.product_service.repository;

import com.services.ms.product.product_service.model.entity.Category;
import com.services.ms.product.product_service.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findAllByCategory(Category category);
    
}
