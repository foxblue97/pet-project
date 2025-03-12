package com.product.viewmodel;

import com.product.dimension.DimensionUnit;
import com.product.valid.ProductPriceValid;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record ProductPostVm(
        Long id,
        @NotBlank
        String name,
        @NotBlank
        String sku,
        @ProductPriceValid
        Double price,
        String description,
        String sortDescription,
        String gtin,
        String slug,
        Long taxId,
        String metaTitle,
        String metaDescription,
        String metaKeyword,
        Boolean hasOption,
        Boolean isAllowedToOrder,
        Boolean isPublished,
        Boolean isVisibleIndividually,
        Boolean stockTrackingEnable,
        Long thumbnailMediaId,
        @Enumerated(EnumType.STRING)
        DimensionUnit dimensionUnit,
        Double length,
        Double width,
        Double height,
        String color,
        Long brandId,
        Long materialId,
        Long thumbnailId,
        List<Long> categoryIds,
        List<Long> productImageIds,
        List<Long> productRelatedIds
) {
}
