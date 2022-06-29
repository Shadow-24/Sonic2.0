package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Marca_Instrumento;
import pe.edu.upc.demo.repositories.IMarca_InstrumentoRepository;
import pe.edu.upc.demo.serviceinterfaces.IMarca_InstrumentoService;

@Service
public class Marca_InstrumentoImpl implements IMarca_InstrumentoService {

	@Autowired
	private IMarca_InstrumentoRepository marca_instrumentoRepository;

	@Override
	public void insert(Marca_Instrumento marca) {
		marca_instrumentoRepository.save(marca);

	}

	@Override
	public List<Marca_Instrumento> list() {
		// TODO Auto-generated method stub
		return marca_instrumentoRepository.findAll();
	}

	@Override
	public void delete(int idMarca_Instrumento) {
		// TODO Auto-generated method stub
		marca_instrumentoRepository.deleteById(idMarca_Instrumento);
	}

	@Override
	public Optional<Marca_Instrumento> listId(int idMarca_Instrumento) {
		// TODO Auto-generated method stub
		return marca_instrumentoRepository.findById(idMarca_Instrumento);
	}

	@Override
	public void update(Marca_Instrumento form_page) {
		// TODO Auto-generated method stub
		marca_instrumentoRepository.save(form_page);
	}

	@Override
	public List<String[]> instrumentoMarca() {
		// TODO Auto-generated method stub
		return marca_instrumentoRepository.instrumentoMarca();
	}

}
