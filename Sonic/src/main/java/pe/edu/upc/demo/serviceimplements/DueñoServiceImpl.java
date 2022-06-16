package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Distrito;
import pe.edu.upc.demo.entities.Dueño;
import pe.edu.upc.demo.repositories.IDistritoRepository;
import pe.edu.upc.demo.repositories.IDueñoRepository;
import pe.edu.upc.demo.serviceinterfaces.IDistritoService;
import pe.edu.upc.demo.serviceinterfaces.IDueñoService;

@Service
public class DueñoServiceImpl implements IDueñoService {

	@Autowired
	private IDueñoRepository dueñoRepository;

	@Override
	public void insert(Dueño d) {
		// TODO Auto-generated method stub
		dueñoRepository.save(d);
	}

	@Override
	public List<Dueño> list() {
		// TODO Auto-generated method stub
		return dueñoRepository.findAll();
	}

	@Override
	public void delete(int CDueño) {
		// TODO Auto-generated method stub
		dueñoRepository.deleteById(CDueño);
	}

	@Override
	public Optional<Dueño> listId(int CDueño) {
		// TODO Auto-generated method stub
		return dueñoRepository.findById(CDueño);
	}

	@Override
	public void update(Dueño dueño) {
		// TODO Auto-generated method stub
		dueñoRepository.save(dueño);
	}

	

	

}
