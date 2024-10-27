package com.services.ms.product.product_service.mappers;

import com.services.ms.product.product_service.model.dto.CategoryResponse;
import com.services.ms.product.product_service.model.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponse toCategoryResponse(Category category);
}
