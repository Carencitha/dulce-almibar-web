package com.jdc.dulcealmibar.repository;

import com.jdc.dulcealmibar.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByCorreoCliente(String correoCliente);

    List<Pedido> findByEstado(String estado);
}