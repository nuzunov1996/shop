package com.brainstars.interview.shop.repositories.product;


import com.brainstars.interview.shop.models.domains.Product;
import com.brainstars.interview.shop.models.domains.ProductsByCategory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface ProductRepository extends PagingAndSortingRepository<Product, Long>
{
    List<Product> findAllBy(Pageable pageable);

    @Query("SELECT new com.brainstars.interview.shop.models.domains.ProductsByCategory("
            + "P.category, COUNT(P)) FROM Product P GROUP BY P.category")
    List<ProductsByCategory> getProductsByCategory();
}
