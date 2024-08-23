package hn.lenguajes.reposicion.reposicion.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.lenguajes.reposicion.reposicion.Modelos.Equipos;
import hn.lenguajes.reposicion.reposicion.Servicios.EquiposServicio;

@RestController
@RequestMapping("/api/equipos")
public class EquiposController {

    @Autowired
    private EquiposServicio equiposServicio;

    @GetMapping
    public List<Equipos> obtenerEquipos() {
        return equiposServicio.obtenerEquipos();
    
}
    @GetMapping("/{codigoEquipo}")
    public ResponseEntity<Equipos> obtenerEquipoPorId(@PathVariable int codigoEquipo) {
        Equipos equipo = equiposServicio.obtenerEquipoPorId(codigoEquipo);
        if (equipo != null) {
            return ResponseEntity.ok(equipo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
       @PostMapping
    public ResponseEntity<Equipos> crearEquipo(@RequestBody Equipos equipo) {
        try {
            Equipos nuevoEquipo = equiposServicio.crearEquipo(equipo);
            return new ResponseEntity<>(nuevoEquipo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{codigoEquipo}")
    public ResponseEntity<Void> eliminarEquipo(@PathVariable int codigoEquipo) {
        boolean eliminado = equiposServicio.eliminarEquipo(codigoEquipo);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
