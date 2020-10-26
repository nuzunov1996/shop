package com.brainstars.interview.shop.models.domains;


public class ProductsByCategory
{
    private String category;

    private long productsAvailable;


    public ProductsByCategory()
    {
    }


    public ProductsByCategory(String category, long productsAvailable)
    {
        this.category = category;
        this.productsAvailable = productsAvailable;
    }


    public String getCategory()
    {
        return category;
    }


    public void setCategory(String category)
    {
        this.category = category;
    }


    public long getProductsAvailable()
    {
        return productsAvailable;
    }


    public void setProductsAvailable(long productsAvailable)
    {
        this.productsAvailable = productsAvailable;
    }
}
