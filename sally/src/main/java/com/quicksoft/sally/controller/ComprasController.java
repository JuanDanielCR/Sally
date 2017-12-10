package com.quicksoft.sally.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.quicksoft.sally.entity.Cliente;
import com.quicksoft.sally.entity.Plantilla;
import com.quicksoft.sally.model.CompraModel;
import com.quicksoft.sally.service.ComprasService;

@Controller
@RequestMapping("/compras")
@SessionAttributes("clienteSession")
public class ComprasController {
	@Autowired
	@Qualifier("comprasService")
	private ComprasService comprasService;
	
	@PostMapping("/plantilla")
	public String comprarPlantilla(@ModelAttribute("compraModel") CompraModel compraModel) {
		Cliente cliente = new Cliente();
		Plantilla plantilla = new Plantilla();
		plantilla = comprasService.comprarPlantilla(cliente, plantilla);
		return null;
	}
}
