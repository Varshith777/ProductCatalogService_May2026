package org.example.productcatalogservice_may2026.repos;

import org.example.productcatalogservice_may2026.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product,Long> {
    Product save(Product product);

    Optional<Product> findById(Long id);

    List<Product> findAll();

    void deleteById(Long id);

    Page<Product> findByNameEquals(String query, Pageable pageable);

    //List<Product> findByNameContains(String query);
}
