package com.product.service;
import org.apache.commons.collections4.CollectionUtils;

import com.product.exception.BadRequestException;
import com.product.exception.NotFoundException;
import com.product.model.*;
import com.product.repository.*;
import com.product.utils.MessageUtils;
import com.product.viewmodel.ProductPostVm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final ProductImageRepository productImageRepository;
    private final MaterialRepository materialRepository;
    private final ProductRelatedRepository productRelatedRepository;


    public Product create(ProductPostVm productPostVm) {
        validExitsNameProduct(productPostVm);
        Product product = buildMainProduct(productPostVm);
        setBrand(productPostVm.brandId(), product);
        setMaterial(productPostVm.materialId(), product);
        setProductCategory(productPostVm.categoryIds(), product);



    }








    private Product buildMainProduct(ProductPostVm productPostVm) {
        return Product.builder()
                .name(productPostVm.name())
                .sku(productPostVm.sku())
                .price(productPostVm.price())
                .description(productPostVm.description())
                .sortDescription(productPostVm.sortDescription())
                .gtin(productPostVm.gtin())
                .slug(productPostVm.slug())
                .taxClassId(productPostVm.taxId())
                .metaTitle(productPostVm.metaTitle())
                .metaKeywords(productPostVm.metaKeyword())
                .metaDescription(productPostVm.metaDescription())
                .isAllowedToOrder(productPostVm.isAllowedToOrder())
                .isVisibleIndividually(productPostVm.isVisibleIndividually())
                .stockTrackingEnabled(productPostVm.stockTrackingEnable())
                .thumbnailMediaId(productPostVm.thumbnailMediaId())
                .dimensionUnit(productPostVm.dimensionUnit())
                .width(productPostVm.width())
                .height(productPostVm.height())
                .color(productPostVm.color())
                .brand(brandRepository.findByBrandId(productPostVm.brandId()))
                .productCategories(List.of())
                .build();
    }

    private void validExitsNameProduct(ProductPostVm mainProduct) {
      if (!checkNameProduct(mainProduct.name(),mainProduct.id())) {
          throw new BadRequestException(MessageUtils.ERROR_CODE.PRODUCT_EXIST_NAME);
      }
    }



    private boolean checkNameProduct(String nameProduct,Long id) {
        return productRepository.existsByName(nameProduct,id) != null ? true : false;
    }




    private void setBrand(Long id,Product product) {
        Brand brand = brandRepository.findById(id).get();
        if (id == null || product.getBrand() != null) {
            throw new NotFoundException("Brand is not found");
        }
        product.setBrand(brand);
    }

    private void setMaterial(Long id,Product product) {
        Material material = materialRepository.findById(id).get();
        if (id == null || product.getMaterial() != null) {
            throw new NotFoundException("Material is not found");
        }
        product.setMaterial(material);
    }

    private void createProductRelated(ProductPostVm productRated,Product productMain) {
        if (CollectionUtils.isEmpty(productRated.productRelatedIds())) {
            return;
        }
        List<Product> products = productRepository.findAllByIds(productRated.productRelatedIds());
        List<ProductRelated> productRelateds = new ArrayList<>();
        for (Product product : products) {
            productRelateds.add(ProductRelated.builder()
                            .product(productMain)
                            .productRelated(product)
                            .build());
        }
        productRelatedRepository.saveAll(productRelateds);

    }

    private List<ProductCategory> setProductCategory(List<Long> vmProductCategories,Product productMain) {
        List<ProductCategory> productCategoriesList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(vmProductCategories)) {
            List<Long> productCategoriesIds = productMain.getProductCategories()
                    .stream().map(ProductCategory::getId).collect(Collectors.toList());
            if (!CollectionUtils.isEqualCollection(vmProductCategories,productCategoriesIds)) {
                    List<Category> categories = categoryRepository.findAllById(vmProductCategories);
                    if (CollectionUtils.isEmpty(categories)) {
                        throw new NotFoundException(MessageUtils.ERROR_CODE.CATEGORY_NOT_FOUND,vmProductCategories);
                    }else if (vmProductCategories.size() > categories.size()) {
                        throw new BadRequestException(MessageUtils.ERROR_CODE.CATEGORY_NOT_FOUND,vmProductCategories);
                    }
                    for (Category category : categories) {
                        ProductCategory productCategory = new ProductCategory();
                        productCategory.setCategory(category);
                        productCategory.setProduct(productMain);
                        productCategoriesList.add(productCategory);
                    }
            }
        }
        return productCategoriesList;
    }










//    public ProductListGetFromCategoryVm pageableProductsFromCategory(int page, int size, String slug) {
//        List<ProductThumbnailVm> productThumbnailVms = new ArrayList<>();
//        Pageable pageable = PageRequest.of(page, size);
//        Page<ProductCategory> productCategoriesPage;
//        Category category = categoryRepository.findBySlug(slug)
//                .orElseThrow(() -> new NotFoundException("Category not found"));
//        productCategoriesPage = productCategoryRepository.findByCategoryName(category.getName(), pageable);
//        List<ProductCategory> productCategories = productCategoriesPage.getContent();
//        List<Product> products = productCategories
//                .stream().map(ProductCategory::getProduct)
//                .collect(Collectors.toList());
//        for (Product product : products) {
//            productThumbnailVms.add(new ProductThumbnailVm(product.getId(),product.getName(),product.getPrice(),product.getThumbnailMediaId()))
//        }
//    }

}
