package com.quicksoft.sally.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.quicksoft.sally.constants.Constants;
import com.quicksoft.sally.entity.Cliente;
import com.quicksoft.sally.entity.Plantilla;
import com.quicksoft.sally.service.ClienteService;
import com.quicksoft.sally.service.DashboardService;
import com.quicksoft.sally.service.PlantillaService;

@Controller
@SessionAttributes("clienteSession")
public class DashboardController {
	
	public Cliente clienteSession;
	public Cliente clienteActual;
	
	@Autowired
	@Qualifier("dashboardService")
	private DashboardService dashboardService;
	
	@Autowired
	@Qualifier("clienteService")
	private ClienteService clienteService;
	
	@Autowired
	@Qualifier("plantillaService")
	private PlantillaService plantillaService;
	
	
	@GetMapping("/dashboard")
	public ModelAndView mostrarDashboard(ModelMap model) {
		ModelAndView mov = new ModelAndView(Constants.DASHBOARD_VIEW);
		User clienteActivo = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//Subiendo a session
		if(clienteSession == null) {
			clienteSession = clienteService.buscarCliente(clienteActivo.getUsername());
			if(clienteSession != null) {
				model.put("clienteSession", clienteSession);
			}
			clienteActual = (Cliente)model.get("clienteSession");
		}else {
			clienteActual = clienteService.buscarCliente(clienteActivo.getUsername());
		}
		//Obteniendo plantillas
		List<Plantilla> plantillas = plantillaService.getPlantillas(clienteActual);
		
		mov.addObject("nombre",clienteActual.getNombre());
		mov.addObject("plantillas",plantillas);
		return mov;
	}
}
