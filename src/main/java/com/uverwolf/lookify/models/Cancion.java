package com.uverwolf.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="canciones")
public class Cancion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Size(min=5)
	private String nombre;
	
	@Size(min=5)
	private String artista;
	
	@Min(1)
	@Max(10)
	private int rating;
	
	//COLUMNAS DE CREACION  Y ACTUALIZACION AUTOMATICA
	//updatable=false para no poder ser cambiado una vez creado
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	public Cancion() {
		super();
	}
	public Cancion(@Size(min = 5) String nombre, @Size(min = 5) String artista, @Min(1) @Max(10) int rating) {
		super();
		this.nombre = nombre;
		this.artista = artista;
		this.rating = rating;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}	
	//campos automaticos
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
