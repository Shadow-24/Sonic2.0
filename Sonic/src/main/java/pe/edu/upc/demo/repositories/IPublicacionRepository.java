package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Publicacion;

@Repository
public interface IPublicacionRepository extends JpaRepository<Publicacion, Integer> {

}
