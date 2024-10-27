package com.services.ms.product.product_service.services;

import com.services.ms.product.product_service.model.dto.CreateProductRequest;
import com.services.ms.product.product_service.model.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse findById(Long id);

    List<ProductResponse> findAll();

    List<ProductResponse> findAllByCategoryId(Long categoryId);

    ProductResponse save(CreateProductRequest productRequest);

    ProductResponse update(Long id, CreateProductRequest productRequest);

    void deleteById(Long id);

}
