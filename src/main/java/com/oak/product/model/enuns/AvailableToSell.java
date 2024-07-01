package com.oak.product.model.enuns;

public enum AvailableToSell {
    YES,
    NO;

    public static AvailableToSell fromString(String value) {
        return switch (value.toLowerCase()) {
            case "yes" -> YES;
            case "no" -> NO;
            default -> throw new IllegalArgumentException("Unknown value: " + value);
        };
    }
}
