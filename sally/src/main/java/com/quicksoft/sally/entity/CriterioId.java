package com.quicksoft.sally.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CriterioId implements Serializable{
	
	private static final long serialVersionUID = -7731568729788630804L;

	@Column(name="id_criterio")
	private Integer idCriterio;

	@Column(name="id_cliente")
	private Integer idCliente;
	
	@Column(name="id_plantilla")
	private Integer idPlantilla;
	
	public CriterioId() {
		
	}
	
	public CriterioId(Integer idCriterio, Integer idCliente, Integer idPlantilla) {
		super();
		this.idCriterio = idCriterio;
		this.idCliente = idCliente;
		this.idPlantilla = idPlantilla;
	}

	public Integer getIdCriterio() {
		return idCriterio;
	}

	public void setIdCriterio(Integer idCriterio) {
		this.idCriterio = idCriterio;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdPlantilla() {
		return idPlantilla;
	}

	public void setIdPlantilla(Integer idPlantilla) {
		this.idPlantilla = idPlantilla;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
