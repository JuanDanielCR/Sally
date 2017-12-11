package com.quicksoft.sally.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.quicksoft.sally.entity.Cliente;
import com.quicksoft.sally.entity.Plantilla;
import com.quicksoft.sally.model.PlantillaModel;
import com.quicksoft.sally.repository.PlantillaRepository;
import com.quicksoft.sally.service.PlantillaService;

@Service("plantillaService")
public class PlantillaImpl implements PlantillaService{

	@Autowired
	@Qualifier("plantillaRepository")
	private PlantillaRepository plantillaRepository;
	
	public List<PlantillaModel> getPlantillas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plantilla agregarPlantilla(Plantilla plantilla, Cliente cliente) {
		plantilla.setIdCreador(cliente.getIdCliente());
		plantilla.setIsPropia(1);
		plantilla.setEstatus(1);
		plantilla.setCliente(cliente);
		return plantillaRepository.save(plantilla);
	}

	@Override
	public Plantilla actualizarPlantilla(Plantilla plantilla) {
		return plantillaRepository.save(plantilla);
	}
}
