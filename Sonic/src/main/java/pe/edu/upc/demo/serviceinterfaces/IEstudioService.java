package pe.edu.upc.demo.serviceinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Estudio;

public interface IEstudioService {
    public void insert(Estudio estudio);

    public List<Estudio> list();

    public void delete(int CEstudio);

    Optional<Estudio> listId(int CEstudio);

    public void update(Estudio estudio);
}
