package com.product.viewmodel;

import java.util.List;

public record ProductListGetFromCategoryVm(
        List<ProductListThumbnailVm> productList,
        int pageSize,
        int pageNumber,
        int totalPages,
        int totalElements,
        boolean lastPage
) {

}
