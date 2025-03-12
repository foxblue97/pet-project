package com.product.viewmodel;

import com.product.model.Product;

public record ProductListThumbnailVm(
    Long id,
    String name,
    String sku,
    Double price,
    String thumbnailUrl
) {
    public static ProductListThumbnailVm fromModel(Product product) {
        return new ProductListThumbnailVm(product.getId(), product.getName(), product.getSku(), product.getPrice(), product.th);
    }
}
