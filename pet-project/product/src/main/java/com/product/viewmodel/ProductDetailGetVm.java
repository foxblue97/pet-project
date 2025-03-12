package com.product.viewmodel;

import com.product.dimension.DimensionUnit;

public record ProductDetailGetVm(
        Long id,
        String name,
        String description,
        String sortDescription,
        String sku,
        String gtin,
        String slug,
        String taxClassId,
        String metaDescription,
        String metaTitle,
        String metaKeyword,
        boolean hasOptions,
        boolean isAllowedToOrder,
        boolean isPublished,
        boolean isFeatured,
        boolean isVisibleIndividually,
        boolean stockTrackingEnabled,
        Long stockQuantity,
        DimensionUnit dimensionUnit,
        Double length,
        Double width,
        Double height,
        String color,
        Long  brandId,
        Long materialId,
        Double price,
        Long thumbnailMediaId
) {




}
