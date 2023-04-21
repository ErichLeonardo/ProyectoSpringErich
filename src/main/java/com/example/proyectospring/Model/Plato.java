package com.example.proyectospring.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Platos")
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String nombre;

    @Column(name = "precio")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private double precio;

    @ManyToMany(mappedBy = "platos")
    private Set<Cliente> clientes = new LinkedHashSet<>();

}
