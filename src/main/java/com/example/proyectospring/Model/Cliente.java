package com.example.proyectospring.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JdbcTypeCode(SqlTypes.TINYINT)
    private int id;

    @Column(name = "nombre")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String nombre;

    @Column(name = "telefono")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String telefono;

    @ManyToMany
    @JoinTable(name = "clientes_platos",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "platos_id"))
    private Set<Plato> platos = new LinkedHashSet<>();


}
