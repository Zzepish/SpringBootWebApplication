package com.zzepish.demo;

import com.zzepish.demo.Entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p where p.name ilike :keyword or p.brand ilike :keyword or p.category ilike :keyword or p.description ilike :keyword")
    @Transactional
    public List<Product> search(String keyword);
}
