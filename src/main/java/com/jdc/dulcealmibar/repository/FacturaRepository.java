package com.jdc.dulcealmibar.repository;

import com.jdc.dulcealmibar.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

    List<Factura> findByCorreoCliente(String correoCliente);

    Optional<Factura> findByPedidoId(Long pedidoId);

    boolean existsByPedidoId(Long pedidoId);

    boolean existsByNumeroFactura(String numeroFactura);
}