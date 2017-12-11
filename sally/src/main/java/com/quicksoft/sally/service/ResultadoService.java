package com.quicksoft.sally.service;

import java.util.List;

import com.quicksoft.sally.model.PlantillaModel;
import com.quicksoft.sally.model.Solucion;

public interface ResultadoService {
	public abstract List<Solucion> getResultados(PlantillaModel plantilla);
}
