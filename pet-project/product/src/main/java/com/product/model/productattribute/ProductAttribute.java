package com.product.model.productattribute;

import com.product.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_attribute")
public class ProductAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany
    private List<ProductAttributeValue> productAttributeValues;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProductAttribute that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getProductAttributeValues(), that.getProductAttributeValues());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getProductAttributeValues());
    }
}
