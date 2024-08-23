package hn.lenguajes.reposicion.reposicion.Modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="posiciones")
@Data
public class Posiciones {

    @Id
    @Column(name="codigoEquipo")
    private int codigoEquipo;

    @OneToOne
    @JoinColumn(name="codigoEquipo", referencedColumnName = "codigoEquipo", insertable = false, updatable = false)
    private Equipos equipo;

    private int empates;
    
    private int ganados;

    private int perdidos;

    private int golesFavor;

    private int golesContra;

    private int puntos;
    
}
