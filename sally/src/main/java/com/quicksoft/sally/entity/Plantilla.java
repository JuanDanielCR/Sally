package com.quicksoft.sally.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="plantilla")
public class Plantilla implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8202798191849681732L;

	@Id
	@GeneratedValue
	@Column(name="id_plantilla")
	private Integer idPlantilla;
	
	@Column(name="objetivo")
	private String objetivo;
	
	@Column(name="version")
	private Integer version;
	
	@Column(name="isPropia")
	private Integer isPropia;
	
	@Column(name="estatus")
	private Integer estatus;
	
	@Column(name="id_creador")
	private Integer idCreador;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@ManyToMany
	@JoinTable(name="plantilla_tipo")
	private List<Tipo> tipos;
	
	@OneToMany(mappedBy="plantilla", fetch=FetchType.LAZY)
	private List<Criterio> criterios;
	
	private Integer numCriterios;
	
	public Plantilla() {
		
	}

	public Plantilla(Integer idPlantilla, String objetivo, Integer version, Integer isPropia, Integer estatus,
			Integer idCreador, Cliente cliente, List<Tipo> tipos, List<Criterio> criterios, Integer numCriterios) {
		super();
		this.idPlantilla = idPlantilla;
		this.objetivo = objetivo;
		this.version = version;
		this.isPropia = isPropia;
		this.estatus = estatus;
		this.idCreador = idCreador;
		this.cliente = cliente;
		this.tipos = tipos;
		this.criterios = criterios;
		this.numCriterios = numCriterios;
	}

	public Integer getIdPlantilla() {
		return idPlantilla;
	}
	public void setIdPlantilla(Integer idPlantilla) {
		this.idPlantilla = idPlantilla;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getIsPropia() {
		return isPropia;
	}
	public void setIsPropia(Integer isPropia) {
		this.isPropia = isPropia;
	}
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
	public Integer getIdCreador() {
		return idCreador;
	}
	public void setIdCreador(Integer idCreador) {
		this.idCreador = idCreador;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Tipo> getTipos() {
		return tipos;
	}

	public void setTipos(List<Tipo> tipos) {
		this.tipos = tipos;
	}

	public Integer getNumCriterios() {
		return numCriterios;
	}

	public void setNumCriterios(Integer numCriterios) {
		this.numCriterios = numCriterios;
	}

	public List<Criterio> getCriterios() {
		return criterios;
	}

	public void setCriterios(List<Criterio> criterios) {
		this.criterios = criterios;
	}
	
	
}
