package hn.lenguajes.reposicion.reposicion.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.lenguajes.reposicion.reposicion.Modelos.Posiciones;
import hn.lenguajes.reposicion.reposicion.Repositorios.PosicionesRepositorio;

@Service
public class PosicionesServicio {

    @Autowired
    private static PosicionesRepositorio posicionesRepositorio;

    public static List<Posiciones> obtenerTodasLasPosiciones() {
        return posicionesRepositorio.findAll();
    }

    public Posiciones crearPosicion(Posiciones posicion) {
        return posicionesRepositorio.save(posicion);
    }

    public boolean eliminarPosicion(int codigoEquipo) {
        if (posicionesRepositorio.existsById(codigoEquipo)) {
            posicionesRepositorio.deleteById(codigoEquipo);
            return true;
        }
        return false;
    
}
public Posiciones obtenerPosicionId(int codigoEquipo) {
    return posicionesRepositorio.findById(codigoEquipo).orElse(null);

}

}


