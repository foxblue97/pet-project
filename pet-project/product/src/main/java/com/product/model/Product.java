package com.product.model;

import com.product.dimension.DimensionUnit;
import com.product.listener.AbstractEntityListener;
import com.product.model.productattribute.ProductAttribute;
import com.product.model.productattribute.ProductAttributeValue;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.internal.build.AllowNonPortable;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@Table(name = "product")
@AllArgsConstructor
public class Product  extends AbstractEntityListener {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String sortDescription;
    private String sku;
    private String gtin;
    private String slug;
    private Long taxClassId;
    private String metaDescription;
    private String metaTitle;
    private String metaKeywords;
    private boolean hasOptions;
    private boolean isAllowedToOrder;
    private boolean isPublished;
    private boolean isFeatured;
    private boolean isVisibleIndividually;
    private boolean stockTrackingEnabled;
    private Long stockQuantity;
    private Double price;
    private Long thumbnailMediaId;

    private DimensionUnit dimensionUnit;
    private Double length;
    private Double width;
    private Double height;
    private String color;

    @ManyToOne()
    @JoinColumn(name = "product_brand")
    private Brand brand;


    @OneToMany
    @Builder.Default
    private List<ProductAttribute> productAttributes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "product_material")
    private Material material;

    @OneToMany
    @Builder.Default
    private List<ProductCategory> productCategories = new ArrayList<>();


    @OneToMany(mappedBy = "product")
    @Builder.Default
    private List<ProductImage> productImages = new ArrayList<>();


}
