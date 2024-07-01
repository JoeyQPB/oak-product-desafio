package com.oak.product.service;

import org.springframework.http.HttpStatus;

public record ServiceResponse<E> (HttpStatus httpStatus, E body) {
}
