package com.jdc.dulcealmibar.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "facturas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String numeroFactura;

    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false, unique = true)
    private Pedido pedido;

    @Column(nullable = false, length = 120)
    private String nombreCliente;

    @Column(nullable = false, length = 150)
    private String correoCliente;

    @Column(length = 30)
    private String telefonoCliente;

    @Column(length = 200)
    private String direccionCliente;

    @Column(nullable = false)
    private Double subtotal;

    @Column(nullable = false)
    private Double iva;

    @Column(nullable = false)
    private Double total;

    @Column(nullable = false, length = 50)
    private String estadoFactura = "GENERADA";

    @Column(nullable = false)
    private LocalDateTime fechaEmision = LocalDateTime.now();
}