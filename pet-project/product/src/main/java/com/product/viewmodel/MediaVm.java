package com.product.viewmodel;

public record MediaVm(
        Long id,
        String caption,
        String fileName,
        String filePath,
        String mediaType
) {
}
