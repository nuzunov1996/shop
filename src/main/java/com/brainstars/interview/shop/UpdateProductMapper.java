package com.brainstars.interview.shop;

import com.brainstars.interview.shop.models.DTOs.product.UpdateProductDTO;
import com.brainstars.interview.shop.models.domains.Product;

import java.time.LocalDate;
import java.util.Objects;

public class UpdateProductMapper {
    public static Product map(Product product, UpdateProductDTO dto) {
        if (dto.getId() != 0)
            product.setId(dto.getId());

        if (Objects.nonNull(dto.getName()))
            product.setName(dto.getName());

        if (Objects.nonNull(dto.getCategory()))
            product.setCategory(dto.getCategory());

        if (Objects.nonNull(dto.getDescription()))
            product.setCategory(dto.getDescription());

        product.setLastModifiedDate(LocalDate.now());

        return product;
    }
}
