package com.quicksoft.sally.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SolucionId implements Serializable{
	
	private static final long serialVersionUID = -7013499564110566486L;

	@Column(name="id_solucion")
	private Integer idSolucion;
	
	@Column(name="id_plantilla")
	private Integer idPlantilla;
	
	@Column(name="id_cliente")
	private Integer idCliente;
	
	@Column(name="id_criterio")
	private Integer idCriterio;
	
	public SolucionId() {
		
	}
	
	

	public SolucionId(Integer idSolucion, Integer idPlantilla, Integer idCliente, Integer idCriterio) {
		super();
		this.idSolucion = idSolucion;
		this.idPlantilla = idPlantilla;
		this.idCliente = idCliente;
		this.idCriterio = idCriterio;
	}



	public Integer getIdSolucion() {
		return idSolucion;
	}

	public void setIdSolucion(Integer idSolucion) {
		this.idSolucion = idSolucion;
	}

	public Integer getIdPlantilla() {
		return idPlantilla;
	}

	public void setIdPlantilla(Integer idPlantilla) {
		this.idPlantilla = idPlantilla;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public Integer getIdCriterio() {
		return idCriterio;
	}

	public void setIdCriterio(Integer idCriterio) {
		this.idCriterio = idCriterio;
	}
	
}
