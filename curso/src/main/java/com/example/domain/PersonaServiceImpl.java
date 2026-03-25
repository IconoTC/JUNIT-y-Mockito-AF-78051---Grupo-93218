package com.example.domain;

import java.util.List;

import com.example.ejemplos.Persona;

public class PersonaServiceImpl implements PersonaService {
	private PersonasRepository dao;
	
	public PersonaServiceImpl(PersonasRepository dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<Persona> getAll() {
		return dao.read();
	}

	@Override
	public Persona getOne(Integer key) {
		return dao.read(key);
	}

	@Override
	public Persona add(Persona item) {
		if(item == null)
			throw new IllegalArgumentException("El argumento no puede ser nulo.");
		// aplica reglas de negocio
		return dao.save(item);
	}

	@Override
	public Persona change(Persona item) {
		if(item == null)
			throw new IllegalArgumentException("El argumento no puede ser nulo.");
		// aplica reglas de negocio
		return dao.save(item);
	}

	@Override
	public void delete(Persona item) {
		if(item == null)
			throw new IllegalArgumentException("El argumento no puede ser nulo.");
		// aplica reglas de negocio
		dao.delete(item);
	}

	@Override
	public void deleteById(Integer key) {
		// aplica reglas de negocio
		deleteById(key);
	}

}
