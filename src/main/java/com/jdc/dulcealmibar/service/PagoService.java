package com.jdc.dulcealmibar.service;

import com.jdc.dulcealmibar.entity.Pago;
import com.jdc.dulcealmibar.entity.Pedido;
import com.jdc.dulcealmibar.repository.PagoRepository;
import com.jdc.dulcealmibar.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PagoService {

    private final PagoRepository pagoRepository;
    private final PedidoRepository pedidoRepository;

    public PagoService(PagoRepository pagoRepository,
                       PedidoRepository pedidoRepository) {
        this.pagoRepository = pagoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public Pago registrarPago(Long pedidoId, String metodoPago, String referenciaPago) {

        if (pagoRepository.existsByPedidoId(pedidoId)) {
            throw new RuntimeException("Este pedido ya tiene un pago registrado");
        }

        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        Pago pago = Pago.builder()
                .pedido(pedido)
                .metodoPago(metodoPago)
                .valorPagado(pedido.getTotal())
                .estadoPago("PAGADO")
                .referenciaPago(referenciaPago)
                .fechaPago(LocalDateTime.now())
                .build();

        return pagoRepository.save(pago);
    }

    public Optional<Pago> buscarPorPedido(Long pedidoId) {
        return pagoRepository.findByPedidoId(pedidoId);
    }
}