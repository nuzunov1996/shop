package com.brainstars.interview.shop.models.DTOs.product;


import java.util.ArrayList;
import java.util.List;


public class AllProductsDTO
{
    private long totalRecords;

    List<ProductDTO> products;


    public long getTotalRecords()
    {
        return totalRecords;
    }


    public void setTotalRecords(long totalRecords)
    {
        this.totalRecords = totalRecords;
    }


    public List<ProductDTO> getProducts()
    {
        return new ArrayList<>(products);
    }


    public void setProducts(List<ProductDTO> products)
    {
        this.products = new ArrayList<>(products);
    }
}
