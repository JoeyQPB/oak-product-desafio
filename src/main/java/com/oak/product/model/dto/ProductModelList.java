package com.oak.product.model.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ProductModelList (@NotBlank String name,
                                @NotBlank BigDecimal price) {
}
