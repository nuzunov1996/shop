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

    @Query("select new com.brainstars.interview.shop.models.domains.ProductsByCategory(" +
            "p.category, count(p)) " +
            "from Product p " +
            "group by p.category")
    List<ProductsByCategory> getProductsByCategory();
}
