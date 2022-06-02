package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.TipoInstrumento;
import pe.edu.upc.demo.repositories.ITipoInstrumentoRepository;
import pe.edu.upc.demo.serviceinterfaces.ITipoInstrumentoService;

@Service
public class TipoInstrumentoServiceImpl implements ITipoInstrumentoService {
	@Autowired
	private ITipoInstrumentoRepository tiRepository;

	@Override
	public void insert(TipoInstrumento tipoinstrumento) {
		tiRepository.save(tipoinstrumento);
	}

	@Override
	public List<TipoInstrumento> list() {
		return tiRepository.findAll();
	}

	@Override
	public void delete(int idTipoInstrumento) {
		tiRepository.deleteById(idTipoInstrumento);
	}

	@Override
	public Optional<TipoInstrumento> listId(int idTipoInstrumento) {
		return tiRepository.findById(idTipoInstrumento);
	}

	@Override
	public void update(TipoInstrumento tipoinstrumento) {
		tiRepository.save(tipoinstrumento);
	}

}
