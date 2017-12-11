package com.quicksoft.sally.service;

import java.util.List;

import com.quicksoft.sally.entity.Cliente;
import com.quicksoft.sally.entity.Plantilla;

public interface PlantillaService {
	public abstract List<Plantilla> getPlantillas(Cliente cliente);
	public abstract Plantilla agregarPlantilla(Plantilla plantilla, Cliente cliente);
	public abstract Plantilla actualizarPlantilla(Plantilla plantilla);
}
