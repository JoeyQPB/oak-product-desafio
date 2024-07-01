package com.oak.product.model.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductDto (@NotBlank String name,
                          @NotBlank String description,
                          @Min(0) @Nullable BigDecimal price,
                          @NotBlank String availableToSell) {
}
