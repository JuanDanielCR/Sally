package com.quicksoft.sally.service;

import java.util.List;

import com.quicksoft.sally.entity.Cliente;
import com.quicksoft.sally.entity.Plantilla;
import com.quicksoft.sally.model.PlantillaModel;

public interface PlantillaService {
	public abstract List<PlantillaModel> getPlantillas();
	public abstract Plantilla agregarPlantilla(Plantilla plantilla, Cliente cliente);
	public abstract Plantilla actualizarPlantilla(Plantilla plantilla);
}
