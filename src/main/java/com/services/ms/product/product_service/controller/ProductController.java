package com.services.ms.product.product_service.controller;

import com.services.ms.product.product_service.model.dto.CreateProductRequest;
import com.services.ms.product.product_service.model.dto.ProductResponse;
import com.services.ms.product.product_service.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    @GetMapping
    public List<ProductResponse> findAll(){
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable Long id){
        return this.productService.findById(id);
    }

    @GetMapping("/category/{id}")
    public List<ProductResponse> findAllByCategoryId(@PathVariable Long id){
        return this.productService.findAllByCategoryId(id);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> save(@Valid @RequestBody CreateProductRequest productRequest){
        ProductResponse response = this.productService.save(productRequest);
        //Indicamos la url donde se creó el product
        return ResponseEntity
                .created(URI.create("api/products/"+ response.getId()))
                .body(response);
    }

    @PutMapping("/{id}")
    public ProductResponse updateById(@PathVariable Long id, @Valid @RequestBody CreateProductRequest productRequest){
        return this.productService.update(id,productRequest);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id){
        this.productService.deleteById(id);
    }
}
