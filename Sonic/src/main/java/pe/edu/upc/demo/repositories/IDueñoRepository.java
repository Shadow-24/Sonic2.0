package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Distrito;
import pe.edu.upc.demo.entities.Dueño;


@Repository
public interface IDueñoRepository extends JpaRepository<Dueño, Integer>{
	
}
