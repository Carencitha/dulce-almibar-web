package com.jdc.dulcealmibar.repository;

import com.jdc.dulcealmibar.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PagoRepository extends JpaRepository<Pago, Long> {

    Optional<Pago> findByPedidoId(Long pedidoId);

    boolean existsByPedidoId(Long pedidoId);
}