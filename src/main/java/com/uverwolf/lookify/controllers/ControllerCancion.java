package com.uverwolf.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uverwolf.lookify.models.Cancion;
import com.uverwolf.lookify.services.CancionService;

@Controller
public class ControllerCancion {
	private final CancionService servicios;	
	
	public ControllerCancion(CancionService servC) {
		this.servicios = servC;
	}
	
	@GetMapping("")
	public String index() {
		return "/vistas/index.jsp";
	}
	
	//AGREGAR
	@GetMapping("/canciones/nueva")
	public String agregar(@ModelAttribute("cancionValida") Cancion song) {
		return "/vistas/agregar.jsp";
	}
	@PostMapping("/canciones/nueva")
	public String agregar(@Valid @ModelAttribute("cancionValida")Cancion song,BindingResult resultado) {
		if(resultado.hasErrors()) {
			return "/vistas/agregar.jsp";
		}else {
			servicios.agregar(song);
			return "redirect:/dashboard";
		}
	}
	
	
	@GetMapping("/dashboard")
	public String dashboard(Model modelo) {
		List<Cancion> listaCanciones = servicios.todas();
		modelo.addAttribute("canciones", listaCanciones);
		return "vistas/dashboard.jsp";
	}
	//BUSCADOR
	@PostMapping("/busqueda")
	public String busquedaEspecifica(Model modelo,@RequestParam("nombre")String nombre) {
	
		List<Cancion> listado= servicios.verT(nombre);
		if(listado.size()<=0) {
			return"redirect:/createError";
		}else {
			modelo.addAttribute("listadoArtista", listado);
			modelo.addAttribute("nombreArtista", nombre);
			return "/vistas/busqueda.jsp";
		}

	}
	@DeleteMapping("/canciones/{id}")
	public String borrar(@PathVariable("id") Long id) {
		servicios.eliminar(id);
		return "redirect:/dashboard";
	}
	@GetMapping("/busqueda/topTen")
	public String topTen(Model modelo) {
		List<Cancion>topTen=servicios.topTen();
		modelo.addAttribute("topTen", topTen);
		return "/vistas/topTen.jsp";
	}
	@GetMapping("/canciones/{id}")
	public String verUna(@PathVariable("id")Long id, Model modelo) {
		modelo.addAttribute("cancionE", servicios.verUna(id));
		return "/vistas/ver.jsp";
	}
	
	
	
	//ERROR EN EL BUSCADOR
	@GetMapping("/createError")
	public String flashMessages(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "No existe ese artista en la lista");
        return "redirect:/dashboard";
	}

}
