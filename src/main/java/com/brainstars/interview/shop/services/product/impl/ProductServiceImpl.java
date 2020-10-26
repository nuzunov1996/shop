package com.brainstars.interview.shop.services.product.impl;


import com.brainstars.interview.shop.utils.UpdateProductMapper;
import com.brainstars.interview.shop.exceptions.InsufficientQuantityException;
import com.brainstars.interview.shop.exceptions.ProductDoesntExistException;
import com.brainstars.interview.shop.models.DTOs.product.AddProductDTO;
import com.brainstars.interview.shop.models.DTOs.product.DeleteProductDTO;
import com.brainstars.interview.shop.models.DTOs.product.ProductDTO;
import com.brainstars.interview.shop.models.DTOs.product.UpdateProductDTO;
import com.brainstars.interview.shop.models.domains.Product;
import com.brainstars.interview.shop.models.domains.ProductsByCategory;
import com.brainstars.interview.shop.repositories.product.ProductRepository;
import com.brainstars.interview.shop.services.product.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService
{

    private final ProductRepository productRepository;

    private static final ModelMapper mapper = new ModelMapper();


    public ProductServiceImpl(ProductRepository productRepository)
    {

        this.productRepository = productRepository;
    }


    @Override
    public Product addProduct(AddProductDTO dto)
    {

        Product product = mapper.map(dto, Product.class);
        return productRepository.save(product);
    }


    @Override
    public void deleteDTO(DeleteProductDTO dto)
    {
        Optional<Product> productOptional = productRepository.findById(dto.getId());
        if (productOptional.isEmpty())
            throw new ProductDoesntExistException();

        productRepository.deleteById(dto.getId());
    }


    @Override
    public Product update(UpdateProductDTO dto)
    {
        Optional<Product> productOptional = productRepository.findById(dto.getId());

        if (productOptional.isEmpty())
            throw new ProductDoesntExistException();

        return productRepository.save(UpdateProductMapper.map(productOptional.get(), dto));
    }


    @Override
    public List<ProductDTO> getProducts(int page, int pageSize, String orderBy, String direction)
    {

        Pageable pageable =
                PageRequest.of(page, pageSize,
                        Sort.by(Sort.Direction.valueOf(direction.toUpperCase()), orderBy).descending());

        return productRepository.findAllBy(pageable).stream().map(p -> mapper.map(p, ProductDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public void orderProduct(long id, int amount)
    {
        Optional<Product> product = productRepository.findById(id);

        if (product.isEmpty())
            throw new ProductDoesntExistException();

        Product productOrdered = product.get();
        int productQuantity = productOrdered.getQuantity();
        if (productQuantity >= amount)
        {
            productOrdered.setQuantity(productQuantity - amount);
            productRepository.save(productOrdered);
        }
        else
            throw new InsufficientQuantityException();

    }


    @Override
    public List<ProductsByCategory> getCategories()
    {
        return productRepository.getProductsByCategory();
    }
}
