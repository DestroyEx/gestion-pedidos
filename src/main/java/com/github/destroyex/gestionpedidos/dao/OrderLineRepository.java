package com.github.destroyex.gestionpedidos.dao;

import com.github.destroyex.gestionpedidos.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}
