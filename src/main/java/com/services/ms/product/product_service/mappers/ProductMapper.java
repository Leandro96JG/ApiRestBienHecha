package com.services.ms.product.product_service.mappers;

import com.services.ms.product.product_service.model.dto.ProductResponse;
import com.services.ms.product.product_service.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.services.ms.product.product_service.utils.constants.statusProduct.ACTIVE_STATUS;
import static com.services.ms.product.product_service.utils.constants.statusProduct.INACTIVE_STATUS;

//uses para mappear una respuesta
@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ProductMapper {

    //indicamos que el target "status" va a ser mappeado mediante
    // la función en java -> mapStatus(product),
    // que recibe el mismo product del mapper
    @Mapping(target = "status", expression = "java(mapStatus(product))")
    ProductResponse toProductResponse(Product product);

    //Para cambiar el boolean a string
    default String mapStatus(Product product){
        return product.getStatus() ? ACTIVE_STATUS : INACTIVE_STATUS;
    }

}
