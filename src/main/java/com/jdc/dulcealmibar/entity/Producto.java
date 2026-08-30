package com.jdc.dulcealmibar.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del producto es obligatorio")
    @Column(nullable = false, length = 120)
    private String nombre;

    @NotBlank(message = "La descripción es obligatoria")
    @Column(nullable = false, length = 300)
    private String descripcion;

    @NotBlank(message = "La categoría es obligatoria")
    @Column(nullable = false, length = 80)
    private String categoria;

    @NotNull(message = "El precio es obligatorio")
    @Column(nullable = false)
    private Double precio;

    @NotNull(message = "El stock es obligatorio")
    @Column(nullable = false)
    private Integer stock;

    @Column(length = 20)
    private String imagenEmoji;

    @Column(nullable = false)
    private Boolean activo = true;
}