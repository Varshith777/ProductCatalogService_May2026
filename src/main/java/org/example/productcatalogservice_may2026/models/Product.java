package org.example.productcatalogservice_may2026.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product extends BaseModel {
    private String description;

    private String imageUrl;

    private Double price;

    private Category category;
}
