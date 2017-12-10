package com.quicksoft.sally.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipoPlantilla")
public class Tipo {
	@ManyToMany(mappedBy="tipos")
	public List<Plantilla> plantillas;
	
	
}
