package com.oak.product.model;

import com.oak.product.model.dto.ProductDto;
import com.oak.product.model.enuns.AvailableToSell;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "product_tb")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = true)
    private BigDecimal price;

    @Column(name = "availableToSell", nullable = false)
    private AvailableToSell availableToSell;

    public ProductModel(ProductDto dto) {
        this.name = dto.name();
        this.description = dto.description();
        this.price = dto.price();
        this.availableToSell = AvailableToSell.fromString(dto.availableToSell());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductModel that = (ProductModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", availableToSell=" + availableToSell +
                '}';
    }
}
