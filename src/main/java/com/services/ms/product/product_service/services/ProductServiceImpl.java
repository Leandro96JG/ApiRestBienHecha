package com.services.ms.product.product_service.services;

import com.services.ms.product.product_service.exceptions.CategoryNotFoundException;
import com.services.ms.product.product_service.exceptions.ProductNotFoundExceptions;
import com.services.ms.product.product_service.mappers.ProductMapper;
import com.services.ms.product.product_service.model.dto.CreateProductRequest;
import com.services.ms.product.product_service.model.dto.ProductResponse;
import com.services.ms.product.product_service.model.entity.Product;
import com.services.ms.product.product_service.repository.CategoryRepository;
import com.services.ms.product.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponse findById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toProductResponse)
                .orElseThrow(ProductNotFoundExceptions::new);
    }

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> findAllByCategoryId(Long categoryId) {

        return categoryRepository.findById(categoryId)
                .map(productRepository::findAllByCategory)
                .map(products -> products.stream()
                        .map(productMapper::toProductResponse)
                        .collect(Collectors.toList())
                    ).orElseThrow(ProductNotFoundExceptions::new);
    }

    @Override
    public ProductResponse save(CreateProductRequest productRequest) {
       //antes de guardar hay que ver si existe la categoria
        return categoryRepository.findById(productRequest.getCategoryId())
                .map(category -> {
                    Product product = new Product();
                    product.setName(productRequest.getName());
                    product.setDescription(productRequest.getDescription());
                    product.setPrice(productRequest.getPrice());
                    product.setCategory(category);
                    product.setStatus(Boolean.TRUE);
                    return productRepository.save(product);
                })
                .map(productMapper::toProductResponse)
                .orElseThrow();
    }

    @Override
    public ProductResponse update(Long id, CreateProductRequest productRequest) {
        //Son dos map. uno valida la categoria
        return productRepository.findById(id)
                .map(product -> categoryRepository
                        .findById(productRequest.getCategoryId())
                        .map(category -> {
                            product.setName(productRequest.getName());
                            product.setDescription(productRequest.getDescription());
                            product.setPrice(productRequest.getPrice());
                            product.setCategory(category);
                            return productRepository.save(product);
                        })
                        .orElseThrow(CategoryNotFoundException::new))
                .map(productMapper::toProductResponse)
                .orElseThrow(ProductNotFoundExceptions::new);
    }

    @Override
    public void deleteById(Long id) {
        if (productRepository.findById(id).isEmpty())
            throw new ProductNotFoundExceptions();
        productRepository.deleteById(id);
    }
}
