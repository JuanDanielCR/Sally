package com.quicksoft.sally.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quicksoft.sally.entity.Criterio;
import com.quicksoft.sally.service.PlantillaService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
	
	@Autowired
	@Qualifier("plantillaService")
	private PlantillaService plantillaService;
	
	private List<Criterio> criterios= new ArrayList();
	
	
	@PostMapping("/addCriterio")
	public String agregarCriterio(@RequestBody List<Criterio> crit){
		crit.addAll(criterios);
		
		return "Agregados correctamente";
	}
}
