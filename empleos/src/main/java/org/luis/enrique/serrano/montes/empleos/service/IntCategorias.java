package org.luis.enrique.serrano.montes.empleos.service;

import java.util.List;

import org.luis.enrique.serrano.montes.empleos.model.Categoria;

public interface IntCategorias {

	public List<Categoria> obtenerTodas();
	public void agregar(Categoria categoria);
	public Categoria buscarPorId(Integer idCategoria);
	public void eliminar(Integer idCategoria);
	public int totalCategoria();
	public void modificar(Integer posicion, Categoria categoria);
	public int buscarPosicion (Categoria categoria);
	
}
