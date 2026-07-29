package com.github.destroyex.gestionpedidos.dao;

import com.github.destroyex.gestionpedidos.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
