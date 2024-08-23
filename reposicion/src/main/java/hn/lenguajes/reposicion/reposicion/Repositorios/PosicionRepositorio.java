package hn.lenguajes.reposicion.reposicion.Repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import hn.lenguajes.reposicion.reposicion.Modelos.Posiciones;

public interface PosicionRepositorio extends JpaRepository<Posiciones, Integer> {
    
}
