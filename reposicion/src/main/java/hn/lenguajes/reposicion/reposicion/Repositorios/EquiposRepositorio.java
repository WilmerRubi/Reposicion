package hn.lenguajes.reposicion.reposicion.Repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hn.lenguajes.reposicion.reposicion.Modelos.Equipos;

@Repository
public interface EquiposRepositorio extends JpaRepository<Equipos, Integer>{
    
}
