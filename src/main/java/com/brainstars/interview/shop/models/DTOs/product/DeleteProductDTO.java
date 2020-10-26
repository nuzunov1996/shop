package com.brainstars.interview.shop.models.DTOs.product;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class DeleteProductDTO
{
    @NotNull
    @Min(0)
    @JsonProperty(defaultValue = "id")
    private Long id;


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
}
