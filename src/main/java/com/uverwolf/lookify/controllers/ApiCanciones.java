package com.uverwolf.lookify.controllers;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uverwolf.lookify.models.Cancion;
import com.uverwolf.lookify.services.CancionService;

@RestController
public class ApiCanciones {
	
	private final CancionService serviciosCancion;
	
	public ApiCanciones(CancionService servSong) {
		this.serviciosCancion=servSong;
	}
	
	@GetMapping("/api/canciones")
	public List<Cancion> verTodas(){
		return serviciosCancion.todas();
	}
	
	@PostMapping("/api/canciones")
	public Cancion agregar(@RequestParam(value="nombre") String nombre, @RequestParam(value="artista") String artista,
			@RequestParam(value="rating") int rating) {
		Cancion song = new Cancion(nombre, artista, rating);
		return serviciosCancion.agregar(song);
		}
	@GetMapping("/api/canciones/{id}")
	public  Cancion verUna(@PathVariable("id") Long id) {
		Cancion songF = serviciosCancion.verUna(id);
		return songF;
	}
	//Actualizar
	@PutMapping("/api/canciones/{id}")
	public Cancion actualizar(@PathVariable("id")Long id, @RequestParam("nombre") String nombre,
			@RequestParam("artista")String artista,@RequestParam("rating")int rating) {
		Cancion songA = new Cancion(nombre, artista, rating);
		songA.setId(id);
		return serviciosCancion.actualizar(songA);
	}
	//eliminar
	@RequestMapping(value="/api/canciones/{id}",method = RequestMethod.DELETE)
	public void eliminar(@PathVariable("id")Long id) {
		serviciosCancion.eliminar(id);
	}
}
