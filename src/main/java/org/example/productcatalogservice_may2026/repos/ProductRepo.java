package org.example.productcatalogservice_may2026.repos;

import org.example.productcatalogservice_may2026.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}
