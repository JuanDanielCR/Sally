package com.quicksoft.sally.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.quicksoft.sally.constants.Constants;
import com.quicksoft.sally.entity.Cliente;
import com.quicksoft.sally.entity.Criterio;
import com.quicksoft.sally.entity.CriterioId;
import com.quicksoft.sally.entity.Plantilla;
import com.quicksoft.sally.service.ClienteService;
import com.quicksoft.sally.service.PlantillaService;

@Controller
@RequestMapping("/plantilla")
@SessionAttributes({"clienteSession","plantillaSession"})
public class PlantillaController {
	@Autowired
	@Qualifier("plantillaService")
	private PlantillaService plantillaService;
	
	@Autowired
	@Qualifier("clienteService")
	private ClienteService clienteService;
	
	private Cliente clienteActual;
	
	@GetMapping("/compra")
	public ModelAndView comprar(ModelMap session, Model model) {
		ModelAndView mov= new ModelAndView(Constants.TARJETA_VIEW);
		Cliente cli = (Cliente)session.get("clienteSession");
		mov.addObject("nombre",cli.getNombre());
		return mov;
	}
	
	@GetMapping("/populares")
	public ModelAndView consultarPopulares(ModelMap session, Model model) {
		ModelAndView mov= new ModelAndView(Constants.POPULARES_VIEW);
		Cliente cli = (Cliente)session.get("clienteSession");
		mov.addObject("nombre",cli.getNombre());
		return mov;
	}
	
	@GetMapping("/categorias")
	public ModelAndView consultarCategorias(ModelMap session, Model model) {
		ModelAndView mov= new ModelAndView(Constants.CATEGORIAS_VIEW);
		Cliente cli = (Cliente)session.get("clienteSession");
		mov.addObject("nombre",cli.getNombre());
		return mov;
	}
	
	@GetMapping("/ver")
	public ModelAndView consultarPlantillas(ModelMap session, Model model) {
		ModelAndView mov= new ModelAndView(Constants.CATEGORIAS_VIEW);
		User clienteActivo = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		clienteActual = (Cliente)session.get("clienteSession");
		if(clienteActual == null) {
			clienteActual = clienteService.buscarCliente(clienteActivo.getUsername());
		}
		mov.addObject("nombre",clienteActual.getNombre());
		return mov;
	}
	
	@GetMapping("/agregar")
	public ModelAndView agregarPlantilla(ModelMap session, Model model) {
		ModelAndView mov= new ModelAndView(Constants.AGREGAR_PLANTILLA);
		User clienteActivo = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		clienteActual = (Cliente)session.get("clienteSession");
		if(clienteActual == null) {
			clienteActual = clienteService.buscarCliente(clienteActivo.getUsername());
		}
		mov.addObject("nombre",clienteActual.getNombre());
		return mov;
	}
	@PostMapping("/agregar")
	public String agregarPlantilla(ModelMap session, @ModelAttribute("plantilla")Plantilla plantilla) {
		String redirect;
		plantilla = plantillaService.agregarPlantilla(plantilla, clienteActual);
		if(plantilla != null) {
			session.put("clienteSession", plantilla);
			redirect = Constants.AGREGAR_CRITERIOS;
		}else {
			redirect = Constants.AGREGAR_PLANTILLA;
		}
		return "redirect:"+redirect;
	}
	
	@GetMapping("/addCriterio")
	public ModelAndView agregarCriterio(ModelMap session, Model model) {
		ModelAndView mov= new ModelAndView(Constants.AGREGAR_CRITERIOS);
		//Cliente
		User clienteActivo = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		clienteActual = (Cliente)session.get("clienteSession");
		if(clienteActual == null) {
			clienteActual = clienteService.buscarCliente(clienteActivo.getUsername());
		}
		mov.addObject("nombre",clienteActual.getNombre());
		//Plantilla
		Plantilla plantilla = (Plantilla)session.get("plantillaSession");
		mov.addObject("objetivoPlantilla", plantilla.getObjetivo());
		mov.addObject("version", plantilla.getVersion());
		//TODO: Obtener tipos
		mov.addObject("categoria", "Personal");
		List<Criterio> criterios = new ArrayList<>();
		for(int i = 0; i < plantilla.getNumCriterios(); i++) {
			CriterioId criterioId = new CriterioId();
			criterioId.setIdCliente(clienteActual.getIdCliente());
			criterioId.setIdPlantilla(plantilla.getIdPlantilla());
			Criterio criterio = new Criterio();
			criterio.setCriterioId(criterioId);
			criterios.add(criterio);
		}
		mov.addObject("criterios", criterios);
		return mov;
	}
	
	@PostMapping("/addCriterio")
	public String agregarCriterios(@ModelAttribute("plantillaRegistro") Plantilla plantilla) {
		String redirect="";
		if(!plantilla.getCriterios().isEmpty()) {
			for(Criterio criterio: plantilla.getCriterios()) {
				System.out.println("criterio: "+criterio.getDescripcion());
			}
		}else {
			System.out.println("vacia-------------------");
		}
		plantilla = plantillaService.actualizarPlantilla(plantilla);
		if(plantilla!=null) {
			redirect = Constants.DASHBOARD_VIEW;
		}else {
			redirect = Constants.AGREGAR_PLANTILLA;
		}
		return "redirect:"+redirect;
	}
}
