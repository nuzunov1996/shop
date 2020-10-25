package com.brainstars.interview.shop.models.DTOs.product;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddProductDTO {

    @NotNull
    @NotBlank
    @JsonProperty(defaultValue = "name")
    private String name;

    @NotNull
    @NotBlank
    @JsonProperty(defaultValue = "category")
    private String category;

    @NotNull
    @NotBlank
    @JsonProperty(defaultValue = "description")
    private String description;

    @NotNull
    @Size(min = 0)
    @JsonProperty(defaultValue = "quantity")
    private int quantity;

    @JsonGetter
    public String getName() {
        return name;
    }

    @JsonSetter
    public void setName(String name) {
        this.name = name;
    }

    @JsonGetter
    public String getCategory() {
        return category;
    }

    @JsonSetter
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonGetter
    public String getDescription() {
        return description;
    }

    @JsonSetter
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonGetter
    public int getQuantity() {
        return quantity;
    }

    @JsonSetter
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
