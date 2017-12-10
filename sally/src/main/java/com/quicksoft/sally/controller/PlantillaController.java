package com.quicksoft.sally.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.quicksoft.sally.constants.Constants;
import com.quicksoft.sally.entity.Cliente;
import com.quicksoft.sally.service.PlantillaService;

@Controller
@RequestMapping("/plantilla")
@SessionAttributes("clienteSession")
public class PlantillaController {
	@Autowired
	@Qualifier("plantillaService")
	private PlantillaService plantillaService;
	
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
		Cliente cli = (Cliente)session.get("clienteSession");
		mov.addObject("nombre",cli.getNombre());
		return mov;
	}
	
	@GetMapping("/agregar")
	public ModelAndView agregarPlantilla(ModelMap session, Model model) {
		ModelAndView mov= new ModelAndView(Constants.PLANTILLAS_VIEW);
		Cliente cli = (Cliente)session.get("clienteSession");
		mov.addObject("nombre",cli.getNombre());
		return mov;
	}
}
