package com.jdc.dulcealmibar.service;

import com.jdc.dulcealmibar.entity.Factura;
import com.jdc.dulcealmibar.entity.Pedido;
import com.jdc.dulcealmibar.repository.FacturaRepository;
import com.jdc.dulcealmibar.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FacturaService {

    private final FacturaRepository facturaRepository;
    private final PedidoRepository pedidoRepository;

    public FacturaService(FacturaRepository facturaRepository,
                          PedidoRepository pedidoRepository) {
        this.facturaRepository = facturaRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public List<Factura> listarTodas() {
        return facturaRepository.findAll();
    }

    public List<Factura> listarPorCliente(String correoCliente) {
        return facturaRepository.findByCorreoCliente(correoCliente);
    }

    public Factura buscarPorId(Long id) {
        return facturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
    }

    public Factura buscarPorPedido(Long pedidoId) {
        return facturaRepository.findByPedidoId(pedidoId)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada para este pedido"));
    }

    public Factura generarFactura(Long pedidoId) {

        if (facturaRepository.existsByPedidoId(pedidoId)) {
            throw new RuntimeException("Este pedido ya tiene una factura generada");
        }

        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        if (pedido.getTotal() == null || pedido.getTotal() <= 0) {
            throw new RuntimeException("El pedido no tiene un total válido");
        }

        double subtotal = pedido.getTotal();
        double iva = subtotal * 0.19;
        double total = subtotal + iva;

        String numeroFactura = generarNumeroFactura();

        Factura factura = Factura.builder()
                .numeroFactura(numeroFactura)
                .pedido(pedido)
                .nombreCliente(pedido.getNombreCliente())
                .correoCliente(pedido.getCorreoCliente())
                .telefonoCliente(pedido.getTelefonoCliente())
                .direccionCliente(pedido.getDireccionCliente())
                .subtotal(subtotal)
                .iva(iva)
                .total(total)
                .estadoFactura("GENERADA")
                .fechaEmision(LocalDateTime.now())
                .build();

        return facturaRepository.save(factura);
    }

    private String generarNumeroFactura() {
        String numero;
        do {
            numero = "FAC-" + System.currentTimeMillis();
        } while (facturaRepository.existsByNumeroFactura(numero));

        return numero;
    }
}