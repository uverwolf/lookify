package com.uverwolf.lookify.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.uverwolf.lookify.models.Cancion;

public interface CancionRepository extends CrudRepository<Cancion, Long>{
	
	List<Cancion> findAll();
	List<Cancion> findByArtista(String busqueda);
	List<Cancion> findTop10ByOrderByRatingDesc();
}	