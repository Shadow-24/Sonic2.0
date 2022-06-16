package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Instrumento;
import pe.edu.upc.demo.repositories.IInstrumentoRepository;
import pe.edu.upc.demo.serviceinterfaces.IInstrumentoService;

@Service
public class InstrumentoImpl implements IInstrumentoService {

	@Autowired
	private IInstrumentoRepository instrumentoRepository;

	@Override
	public void insert(Instrumento instrumento) {
		// TODO Auto-generated method stub
		instrumentoRepository.save(instrumento);
	}

	@Override
	public List<Instrumento> list() {
		// TODO Auto-generated method stub
		return instrumentoRepository.findAll();
	}

	@Override
	public void delete(int idInstrumento) {
		// TODO Auto-generated method stub
		instrumentoRepository.deleteById(idInstrumento);
	}

	@Override
	public Optional<Instrumento> listId(int idInstrumento) {
		// TODO Auto-generated method stub
		return instrumentoRepository.findById(idInstrumento);
	}

	@Override
	public void update(Instrumento form_page) {
		// TODO Auto-generated method stub
		instrumentoRepository.save(form_page);
	}

}
