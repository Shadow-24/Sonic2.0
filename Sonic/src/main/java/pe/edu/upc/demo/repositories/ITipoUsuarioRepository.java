package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Tipo_Usuario;

@Repository
public interface ITipoUsuarioRepository extends JpaRepository<Tipo_Usuario, Integer> {

}
