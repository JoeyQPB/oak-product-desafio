package com.oak.product.handleErrors;

import org.springframework.http.HttpStatus;

public record RestErrorMessage<E> (HttpStatus httpStatus, E body) {
}
