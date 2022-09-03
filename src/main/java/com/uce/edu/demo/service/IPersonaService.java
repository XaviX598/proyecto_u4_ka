package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaService {

	public void guardar(Persona p);

	public void actualizar(Persona p);

	public void eliminar(Integer id);

	public Persona buscar(Integer id);

	public List<Persona> buscarTodos();

}
