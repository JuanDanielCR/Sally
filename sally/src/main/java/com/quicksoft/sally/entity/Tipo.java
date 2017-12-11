package com.quicksoft.sally.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipoPlantilla")
public class Tipo {
	
	@Id
	@GeneratedValue
	@Column(name="id_tipo")
	private Integer idTipo;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="estatus")
	private Integer estatus;
	
	@ManyToMany(mappedBy="tipos")
	public List<Plantilla> plantillas;
	
	public Tipo() {
		
	}
	
	public Tipo(Integer idTipo, String descripcion, Integer estatus, List<Plantilla> plantillas) {
		super();
		this.idTipo = idTipo;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.plantillas = plantillas;
	}

	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public List<Plantilla> getPlantillas() {
		return plantillas;
	}

	public void setPlantillas(List<Plantilla> plantillas) {
		this.plantillas = plantillas;
	}
	
	
}
