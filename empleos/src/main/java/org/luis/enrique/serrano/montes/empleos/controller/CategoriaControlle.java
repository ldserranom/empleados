package org.luis.enrique.serrano.montes.empleos.controller;

import java.util.List;

import org.luis.enrique.serrano.montes.empleos.model.Categoria;
import org.luis.enrique.serrano.montes.empleos.service.IntCategorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/categoria")
@Controller
public class CategoriaControlle {
    @Autowired
	private IntCategorias categoriaService;
    
    @GetMapping("/index")
    public String mostrarIndex(Model model) {
    	List<Categoria>lista = categoriaService.obtenerTodas();
    	//System.out.println(lista);
    	for(Categoria c : lista) {
    		System.out.println(c.getNombre());
    	}
    	model.addAttribute("categorias", lista);
    	model.addAttribute("total", categoriaService.obtenerTodas().size());
    	return "categorias/listaCategorias";
    }
    //*********************************************************************
    @GetMapping("/crear")
    public String nuevaCategoria(){
    	return "categorias/formCategoria";
    }
    //**********************************************************************
   /* @PostMapping("/guardar")
    public String guardarCategoria( 
    	@RequestParam("nombre") String nombre,
    	@RequestParam("descripcion")String descripcion){
    		//recibo datos
    		Categoria c = new Categoria();
    		c.setId(categoriaService.obtenerTodas().size()+1);
    		c.setNombre(nombre);
    		c.setDescripcion(descripcion);
    		//System.out.println(c);
    		categoriaService.agregar(c);
    		//guardar

    		
    		//generacion de una peticion a nivel de metodo
    		return "redirect:/categoria/index";
    }*/
    
    @PostMapping("/guardar")
    public String guardar(Categoria categoria) {
    	System.out.println(categoria);
       if(categoria.getId)
    	return "redirect:/categoria/index";
    }
    
    @GetMapping("/eliminar")
    public String eliminarCategoria(@RequestParam("id")int idCategoria){
    	categoriaService.eliminar(idCategoria);
    	return "redirect:/categoria/index";
    }
    @GetMapping("/buscar")
    public String buscar(@RequestParam("id") int idCategoria,Model model) {
    	Categoria categoria = categoriaService.buscarPorId(idCategoria);
    	
    	model.addAttribute("categoria", categoria);
    	return "categorias/formCategoria";
    }
   
}
