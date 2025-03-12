package com.product.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class ProductRelated {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Product productRelated;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProductRelated that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getProduct(), that.getProduct()) && Objects.equals(getProductRelated(), that.getProductRelated());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProduct(), getProductRelated());
    }
}
