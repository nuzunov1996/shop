package com.brainstars.interview.shop.models.domains;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "products")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "created_date")
    private LocalDate dateCreated;

    @Column(name = "last_modified_date")
    private LocalDate lastModifiedDate;


    public Product()
    {
        this.dateCreated = LocalDate.now();
        this.lastModifiedDate = LocalDate.now();
        this.quantity = 1;
    }


    public long getId()
    {
        return id;
    }


    public void setId(long id)
    {
        this.id = id;
    }


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public String getCategory()
    {
        return category;
    }


    public void setCategory(String category)
    {
        if (Objects.nonNull(category))
            this.category = category;
    }


    public String getDescription()
    {
        return description;
    }


    public void setDescription(String description)
    {
        this.description = description;
    }


    public int getQuantity()
    {
        return quantity;
    }


    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }


    public LocalDate getDateCreated()
    {
        return dateCreated;
    }


    public void setDateCreated(LocalDate dateCreated)
    {
        this.dateCreated = dateCreated;
    }


    public LocalDate getLastModifiedDate()
    {
        return lastModifiedDate;
    }


    public void setLastModifiedDate(LocalDate lastModifiedDate)
    {
        this.lastModifiedDate = lastModifiedDate;
    }
}
