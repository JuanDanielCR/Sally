package com.quicksoft.sally.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.quicksoft.sally.entity.Cliente;
import com.quicksoft.sally.entity.Criterio;
import com.quicksoft.sally.entity.CriterioId;
import com.quicksoft.sally.entity.Plantilla;
import com.quicksoft.sally.repository.CriterioRepository;
import com.quicksoft.sally.repository.PlantillaRepository;
import com.quicksoft.sally.service.PlantillaService;

@Service("plantillaService")
public class PlantillaImpl implements PlantillaService{

	@Autowired
	@Qualifier("plantillaRepository")
	private PlantillaRepository plantillaRepository;
	
	@Autowired
	@Qualifier("criterioRepository")
	private CriterioRepository criterioRepository;
	
	
	
	public List<Plantilla> getPlantillas(Cliente cliente) {
		List<Plantilla> resultado = plantillaRepository.findAll();
		List<Plantilla> plantillas = new ArrayList<>();
		for(Plantilla p:resultado) {
			System.out.println("paltnilla : "+p.toString()+" cliente: "+cliente.getIdCliente());
			
			if(p.getIdCreador().equals(cliente.getIdCliente())) {
				plantillas.add(p);
			}
		}
		return plantillas;
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
		int i = 0;
		for(Criterio criterio: plantilla.getCriterios()) {
			CriterioId c = new CriterioId();
			c.setIdCliente(plantilla.getCliente().getIdCliente());
			c.setIdPlantilla(plantilla.getIdPlantilla());
			c.setIdCriterio(i++);
			criterio.setPlantilla(plantilla);
			criterio.setCriterioId(c);
			criterio = criterioRepository.save(criterio);
		}
		return plantilla;
	}
}
