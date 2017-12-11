package com.quicksoft.sally.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="criterio")
public class Criterio {
	@EmbeddedId
	private CriterioId criterioId;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="ponderacion")
	private Integer ponderacion;
	
	@Column(name="contenido")
	private Double contenido;
	
	@ManyToOne()
	@JoinColumns({
		@JoinColumn(name="id_cliente", referencedColumnName="id_cliente", insertable=false, updatable=false),
		@JoinColumn(name="id_plantilla", referencedColumnName="id_plantilla", insertable=false, updatable=false)
	})
	private Plantilla plantilla;
	
	
	
	public Criterio(){
		
	}

	public Criterio(CriterioId criterioId, String descripcion, Integer ponderacion, Double contenido,
			Plantilla plantilla) {
		super();
		this.criterioId = criterioId;
		this.descripcion = descripcion;
		this.ponderacion = ponderacion;
		this.contenido = contenido;
		this.plantilla = plantilla;
	}



	public CriterioId getCriterioId() {
		return criterioId;
	}

	public void setCriterioId(CriterioId criterioId) {
		this.criterioId = criterioId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPonderacion() {
		return ponderacion;
	}

	public void setPonderacion(Integer ponderacion) {
		this.ponderacion = ponderacion;
	}

	public Double getContenido() {
		return contenido;
	}

	public void setContenido(Double contenido) {
		this.contenido = contenido;
	}

	public Plantilla getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(Plantilla plantilla) {
		this.plantilla = plantilla;
	}

	
	
}
