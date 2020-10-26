package com.brainstars.interview.shop.models.DTOs.product;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class UpdateProductDTO
{
    @NotNull
    @Min(0)
    @JsonProperty(defaultValue = "id")
    private Long id;

    @JsonProperty(defaultValue = "name")
    private String name;

    @JsonProperty(defaultValue = "category")
    private String category;

    @JsonProperty(defaultValue = "description")
    private String description;


    @JsonGetter
    public long getId()
    {
        return id;
    }


    @JsonSetter
    public void setId(long id)
    {
        this.id = id;
    }


    @JsonGetter
    public String getName()
    {
        return name;
    }


    @JsonSetter
    public void setName(String name)
    {
        this.name = name;
    }


    @JsonGetter
    public String getCategory()
    {
        return category;
    }


    @JsonSetter
    public void setCategory(String category)
    {
        this.category = category;
    }


    @JsonGetter
    public String getDescription()
    {
        return description;
    }


    @JsonSetter
    public void setDescription(String description)
    {
        this.description = description;
    }
}
