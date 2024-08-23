package hn.lenguajes.reposicion.reposicion.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.lenguajes.reposicion.reposicion.Modelos.Posiciones;
import hn.lenguajes.reposicion.reposicion.Servicios.PosicionesServicio;

@RestController
@RequestMapping("/api/posiciones")
public class PosicionesController {
    @Autowired
        private PosicionesServicio posicionServicio;

    @GetMapping
    public List<Posiciones> obtenerTodasLasPosiciones() {
        return PosicionesServicio.obtenerTodasLasPosiciones();
    }

    @GetMapping("/{codigoEquipo}")
    public ResponseEntity<Posiciones> obtenerPosicionId(@PathVariable int codigoEquipo) {
        Posiciones posicion = posicionServicio.obtenerPosicionId(codigoEquipo);
        return posicion != null ? ResponseEntity.ok(posicion) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Posiciones crearPosicion(@RequestBody Posiciones posicion) {
        return posicionServicio.crearPosicion(posicion);
    }

    @DeleteMapping("/{codigoEquipo}")
    public ResponseEntity<Void> eliminarPosicion(@PathVariable int codigoEquipo) {
        boolean eliminado = posicionServicio.eliminarPosicion(codigoEquipo);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
}
