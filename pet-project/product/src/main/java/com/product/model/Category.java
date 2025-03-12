package com.product.model;

import com.product.listener.AbstractEntityListener;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categories")
public class Category extends AbstractEntityListener {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String description;

    private String slug;

    private String metaKeyword;

    private String metaDescription;

    private Short displayOrder;

    private Boolean isPublished;

    private Long imageId;

    @ManyToOne()
    @Column(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent",cascade = CascadeType.REMOVE)
    private List<Category> children = new ArrayList<>();


    @OneToMany(mappedBy = "category")
    private List<ProductCategory> products = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Category category)) return false;
        return Objects.equals(getId(), category.getId()) && Objects.equals(getName(), category.getName()) && Objects.equals(getParent(), category.getParent()) && Objects.equals(getChildren(), category.getChildren()) && Objects.equals(getProducts(), category.getProducts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getParent(), getChildren(), getProducts());
    }
}
