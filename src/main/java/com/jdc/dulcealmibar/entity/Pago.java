package com.jdc.dulcealmibar.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false, unique = true)
    private Pedido pedido;

    @Column(nullable = false, length = 50)
    private String metodoPago;

    @Column(nullable = false)
    private Double valorPagado;

    @Column(nullable = false, length = 50)
    private String estadoPago = "PENDIENTE";

    @Column(length = 120)
    private String referenciaPago;

    @Column(nullable = false)
    private LocalDateTime fechaPago = LocalDateTime.now();
}