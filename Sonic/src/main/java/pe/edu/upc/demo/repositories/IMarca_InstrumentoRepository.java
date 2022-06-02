package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demo.entities.Marca_Instrumento;

@Repository
public interface IMarca_InstrumentoRepository extends JpaRepository<Marca_Instrumento, Integer> {

}
