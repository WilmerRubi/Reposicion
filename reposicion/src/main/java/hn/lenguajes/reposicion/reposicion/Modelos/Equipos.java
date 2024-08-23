package hn.lenguajes.reposicion.reposicion.Modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "equipos")
@Data
public class Equipos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigoEquipo")
    private int codigoEquipo;

    private String nombre;

    private double ataque;

    private double defensa;
}
