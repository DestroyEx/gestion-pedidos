package com.github.destroyex.gestionpedidos.dao;

import com.github.destroyex.gestionpedidos.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
