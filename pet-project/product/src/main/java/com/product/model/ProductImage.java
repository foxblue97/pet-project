package com.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.product.model.media.Media;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "product_image")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    @Column(name = "media_id")
    private List<Media> media;


    @ManyToOne()
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;


}
