package com.product.viewmodel;

public record ProductThumbnailVm(
        long id,
        String name,
        Double price,
        String thumbnailUrl
) {
}
