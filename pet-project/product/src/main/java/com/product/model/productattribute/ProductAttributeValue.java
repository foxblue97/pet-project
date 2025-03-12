package com.product.model.productattribute;

import com.product.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_attribute_value")
public class ProductAttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "product_attribute_value",nullable = false)
    private ProductAttribute attribute;

    private String value;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProductAttributeValue that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getProduct(), that.getProduct()) && Objects.equals(getAttribute(), that.getAttribute()) && Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProduct(), getAttribute(), getValue());
    }
}
