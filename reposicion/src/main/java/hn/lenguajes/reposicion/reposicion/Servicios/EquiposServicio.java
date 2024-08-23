package hn.lenguajes.reposicion.reposicion.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.lenguajes.reposicion.reposicion.Modelos.Equipos;

import hn.lenguajes.reposicion.reposicion.Repositorios.EquiposRepositorio;
import hn.lenguajes.reposicion.reposicion.Repositorios.PosicionesRepositorio;

@Service
public class EquiposServicio {

    @Autowired
    private EquiposRepositorio equiposRepositorio;

    @Autowired
    private PosicionesRepositorio posicionesRepositorio;

    public List<Equipos> obtenerEquipos() {
        return equiposRepositorio.findAll();
    
    }
    public Equipos obtenerEquipoPorId(int codigoEquipo) {
        return equiposRepositorio.findById(codigoEquipo).orElse(null);

        }
    public Equipos crearEquipo(Equipos equipo) {
        return equiposRepositorio.save(equipo);

        }
    public boolean eliminarEquipo(int codigoEquipo) {
        if (posicionesRepositorio.existsById(codigoEquipo)) {
            return false;
        }
        if (equiposRepositorio.existsById(codigoEquipo)) {
            equiposRepositorio.deleteById(codigoEquipo);
            return true;
            }
        return false;

}

}
