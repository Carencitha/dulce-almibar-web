package com.jdc.dulcealmibar.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "insumos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Insumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del insumo es obligatorio")
    @Column(nullable = false, length = 120)
    private String nombre;

    @NotNull(message = "La cantidad es obligatoria")
    @Column(nullable = false)
    private Integer cantidad;

    @NotBlank(message = "La unidad de medida es obligatoria")
    @Column(nullable = false, length = 50)
    private String unidadMedida;

    @NotNull(message = "El stock mínimo es obligatorio")
    @Column(nullable = false)
    private Integer stockMinimo;

    @Column(length = 150)
    private String proveedor;

    @Column(nullable = false)
    private Boolean activo = true;
}