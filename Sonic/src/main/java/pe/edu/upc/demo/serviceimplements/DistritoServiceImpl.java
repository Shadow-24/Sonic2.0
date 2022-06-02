package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Distrito;
import pe.edu.upc.demo.repositories.IDistritoRepository;
import pe.edu.upc.demo.serviceinterfaces.IDistritoService;

@Service
public class DistritoServiceImpl implements IDistritoService {

	@Autowired
	private IDistritoRepository distritoRepository;

	@Override
	public void delete(int CDistrito) {
		distritoRepository.deleteById(CDistrito);
		;
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(Distrito d) {
		// TODO Auto-generated method stub
		distritoRepository.save(d);
	}

	@Override
	public List<Distrito> list() {
		// TODO Auto-generated method stub
		return distritoRepository.findAll();
	}

	@Override
	public void update(Distrito distrito) {
		// TODO Auto-generated method stub
		distritoRepository.save(distrito);

	}

	@Override
	public Optional<Distrito> listId(int CDistrito) {
		// TODO Auto-generated method stub
		return distritoRepository.findById(CDistrito);
	}

}
