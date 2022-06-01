package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Forma_Pago;

@Repository
public interface IForma_PagoRepository extends JpaRepository<Forma_Pago, Integer> {

}
