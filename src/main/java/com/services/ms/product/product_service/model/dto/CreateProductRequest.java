package com.services.ms.product.product_service.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class CreateProductRequest {

    @NotEmpty(message = "El campo name no puede ser vacio")
    private String name;

    private String description;

    @NotNull(message = "El campo precio no puede ser Nulo")
    private BigDecimal price;

    @NotNull(message = "El campo category no puede ser Nulo")
    private Long categoryId;
}
