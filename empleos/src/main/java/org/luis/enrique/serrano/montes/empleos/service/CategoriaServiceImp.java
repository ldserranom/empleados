package org.luis.enrique.serrano.montes.empleos.service;

import java.util.LinkedList;
import java.util.List;

import org.luis.enrique.serrano.montes.empleos.model.Categoria;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImp implements IntCategorias {

	// Agragar atributo
		private List<Categoria>lista = null;
				
		//Metodo constructor
				
		public CategoriaServiceImp() {
			lista = new LinkedList<Categoria>();
			//una instancia
			Categoria c1 = new Categoria();
			c1.setId(1);
			c1.setNombre("Tecnologias");
			c1.setDescripcion("Relacionado con informatica, Telecomunicaciones, IoT");
		
			Categoria c2 = new Categoria();
			c2.setId(2);
			c2.setNombre("Educacion");
			c2.setDescripcion("Relacionado con educacion publica y privada");
			
			Categoria c3 = new Categoria();
			c3.setId(3);
			c3.setNombre("Inteligencia Artificial");
			c3.setDescripcion("Relacionado con todas las ramas de la ingenieria");
		
		    lista.add(c1);
		    lista.add(c2);
		    lista.add(c3);
		}
				
		@Override
		public List<Categoria> obtenerTodas() {
			// TODO Auto-generated method stub
			return lista;
		}

		@Override
		public void agregar(Categoria categoria) {
			lista.add(categoria);

		}

		@Override
		public Categoria buscarPorId(Integer idCategoria) {
			for(Categoria categoria:lista) {
				if(categoria.getId()==idCategoria) {
					return categoria;
				}
			}
			return null;
		}

		@Override
		public void eliminar(Integer idCategoria) {
			// TODO Auto-generated method stub
			lista.remove(buscarPorId(idCategoria));

		}

	@Override
	public int totalCategoria() {
      return  lista.size();
	}

	@Override
	public void modificar(Integer posicion, Categoria categoria) {
		// TODO Auto-generated method stub
	lista.add(posicion,categoria);
	}

	@Override
	public int buscarPosicion(Categoria categoria) {
	int index=0;
	Categoria aux=null;
	int posicion=-1;
	while(index<lista.size()) {
		aux=lista.get(index);
		if(aux.getId()==categoria.getId()) {
			posicion=index;
			break;
		}
		index++;
	}
	return posicion;
	
	}
   
}
