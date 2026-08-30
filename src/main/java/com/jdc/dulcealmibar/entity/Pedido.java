package com.jdc.dulcealmibar.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nombreCliente;

    @Column(nullable = false, length = 150)
    private String correoCliente;

    @Column(length = 30)
    private String telefonoCliente;

    @Column(length = 200)
    private String direccionCliente;

    @Column(length = 300)
    private String observaciones;

    @Builder.Default
    @Column(nullable = false)
    private Double total = 0.0;

    @Builder.Default
    @Column(nullable = false, length = 50)
    private String estado = "PENDIENTE";

    @Builder.Default
    @Column(nullable = false)
    private LocalDateTime fechaPedido = LocalDateTime.now();

    @Builder.Default
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detalles = new ArrayList<>();
}