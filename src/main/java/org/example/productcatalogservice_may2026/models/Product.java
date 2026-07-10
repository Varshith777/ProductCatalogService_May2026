package org.example.productcatalogservice_may2026.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends BaseModel {
    private String description;

    private String imageUrl;

    private Double price;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Category category;

    private Double primeSaleDiscount;
}
