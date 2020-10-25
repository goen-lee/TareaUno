package com.escalab.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.model.Supervisor;
import com.escalab.repo.ISupervisorRepo;
import com.escalab.service.ISupervisorService;

@Service
public class SupervisorServiceImpl implements ISupervisorService {

	@Autowired
	private ISupervisorRepo repo;
	
	@Override
	public Supervisor registrar(Supervisor obj) {
		return repo.save(obj);
	}
	
	@Override
	public Supervisor modificar(Supervisor obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Supervisor> listar(){
		return repo.findAll();
	}
	
	public Supervisor leerPorId(Integer id) {
		Optional<Supervisor> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Supervisor();
	}

	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
