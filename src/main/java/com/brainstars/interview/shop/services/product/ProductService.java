package com.brainstars.interview.shop.services.product;

import com.brainstars.interview.shop.models.DTOs.product.DeleteProductDTO;
import com.brainstars.interview.shop.models.DTOs.product.AddProductDTO;
import com.brainstars.interview.shop.models.DTOs.product.ProductDTO;
import com.brainstars.interview.shop.models.DTOs.product.UpdateProductDTO;
import com.brainstars.interview.shop.models.domains.Product;
import com.brainstars.interview.shop.models.domains.ProductsByCategory;

import java.util.List;

public interface ProductService {
    Product addProduct(AddProductDTO dto);

    void deleteDTO(DeleteProductDTO dto);

    Product update(UpdateProductDTO dto);

    List<ProductDTO> getProducts(int page, int pageSize, String orderBy, String direction);

    void orderProduct(long id, int amount);

    List<ProductsByCategory> getCategories();
}
