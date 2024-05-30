package com.proyectoGuardiasOscar.guardias.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ausencias")

public class Ausencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ausencia;

    @Column()
    private String dia_semana;

    @Column()
    private String hora;

    @Column()
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuarios usuario;

}
