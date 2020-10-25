package com.brainstars.interview.shop.controllers.product;

import com.brainstars.interview.shop.exceptions.InsufficientQuantityException;
import com.brainstars.interview.shop.exceptions.ProductDoesntExistException;
import com.brainstars.interview.shop.models.DTOs.product.DeleteProductDTO;
import com.brainstars.interview.shop.models.DTOs.product.AddProductDTO;
import com.brainstars.interview.shop.models.DTOs.product.ProductDTO;
import com.brainstars.interview.shop.models.DTOs.product.UpdateProductDTO;
import com.brainstars.interview.shop.models.domains.Product;
import com.brainstars.interview.shop.services.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody AddProductDTO dto) {
        Product product = productService.addProduct(dto);
        if (Objects.isNull(product))
            return ResponseEntity.badRequest().body(Map.of("message", "The product was NOT added successfully"));

        return ResponseEntity.ok().body(Map.of("message", "The product was added successfully"));
    }

    @DeleteMapping("/product")
    public ResponseEntity<?> deleteProduct(@RequestBody DeleteProductDTO dto) {
        try
        {
            productService.deleteDTO(dto);
            return ResponseEntity.ok().body(Map.of("message", "The product was deleted successfully"));
        }
        catch (ProductDoesntExistException e)
        {
            LOGGER.error(e.getMessage(), e);
        }

        return ResponseEntity.badRequest().body(Map.of("message", "The product wasn't deleted successfully"));
    }

    @PatchMapping("/product")
    public ResponseEntity<?> updateProduct(@RequestBody UpdateProductDTO dto) {
        try {
            productService.update(dto);
            return ResponseEntity.ok().body(Map.of("message", "The product was deleted successfully"));
        } catch (ProductDoesntExistException e) {
            LOGGER.error(e.getMessage(), e);
        }

        return ResponseEntity.badRequest().body(Map.of("message", "The product was NOT added successfully"));
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts(@RequestParam int page,
                                            @RequestParam int pageSize,
                                            @RequestParam String orderBy,
                                            @RequestParam String direction) {

        List<ProductDTO> products = productService.getProducts(page, pageSize, orderBy, direction);

        return ResponseEntity.ok().body(Map.of("totalRecords", products.size(),
                "products", products));
    }

    @PostMapping("/product/{id}/{amount}")
    public ResponseEntity<?> orderProducts(@RequestParam long id, @RequestParam int amount) {
        try {
            productService.orderProduct(id, amount);
            return ResponseEntity.ok().body(Map.of("message", "The ordering was successfully"));
        } catch (ProductDoesntExistException | InsufficientQuantityException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return ResponseEntity.ok().body(Map.of("message", "The ordering wasn't successfully"));

    }

    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategories() {
        return ResponseEntity.ok(productService.getCategories());
    }
}
