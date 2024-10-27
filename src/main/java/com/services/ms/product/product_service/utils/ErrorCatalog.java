package com.services.ms.product.product_service.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {
    //Errores en los productos
    PRODUCT_NOT_FOUND("ERR_PROD_001","Product not found"),
    PRODUCT_INVALID("ERR_PROD_002","Invalid product parameters"),

    //Errores en las categorias
    CATEGORY_NOT_FOUND("ERR_CAT_001","Category not found"),

    //Errores genericos
    GENERIC_ERROR("ERR_GEN_001","An unexpected error occurred");

    private final String code;

    private final String message;

    ErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
