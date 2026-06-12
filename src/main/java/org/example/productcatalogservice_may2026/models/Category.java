package org.example.productcatalogservice_may2026.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Category extends BaseModel {
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
