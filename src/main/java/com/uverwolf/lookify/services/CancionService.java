package com.uverwolf.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.uverwolf.lookify.models.Cancion;
import com.uverwolf.lookify.repositories.CancionRepository;

@Service
public class CancionService {
	private final CancionRepository repoCanciones;
	
	public CancionService(CancionRepository repoSong) {
		this.repoCanciones=repoSong;
	}
	
	//Ver 
	public List<Cancion> todas(){
		return repoCanciones.findAll();
		
	}
	//Agregar
	public Cancion agregar(Cancion song) {
		return repoCanciones.save(song);
	}
	
	//VER una
	public Cancion verUna(Long id) {
		Optional<Cancion> song = repoCanciones.findById(id);
		if(song.isPresent()) {
			return song.get();
		}else {
			return null;
		} 
	}
	public List<Cancion> verT(String busqueda) {
		return repoCanciones.findByArtista(busqueda);
	}
	public Cancion actualizar(Cancion datos) {
		Optional<Cancion> song = repoCanciones.findById(datos.getId());
		if(song.isPresent()) {
			song.get().setArtista(datos.getArtista());
			song.get().setNombre(datos.getNombre());
			song.get().setRating(datos.getRating());
			
			return repoCanciones.save(song.get());
		}else {
			return null;
		}
	}
	public void eliminar(Long id) {
		repoCanciones.deleteById(id);
	}

	public List<Cancion> topTen() {
	return 	repoCanciones.findTop10ByOrderByRatingDesc();
	
	}
}
