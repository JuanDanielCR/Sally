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
import com.quicksoft.sally.service.MetodosPagoService;

@Controller
@RequestMapping("/pagos")
@SessionAttributes("clienteSession")
public class MetodosPagoController {
	@Autowired
	@Qualifier("metodoPagoService")
	private MetodosPagoService metodosPagoService;
	
	@GetMapping("/metodos")
	public ModelAndView verMetodos(ModelMap session, Model model) {
		ModelAndView mov= new ModelAndView(Constants.CONSULTAR_METODOS);
		Cliente cli = (Cliente)session.get("clienteSession");
		mov.addObject("nombre",cli.getNombre());
		return mov;
	}
	
	@GetMapping("/agregar")
	public ModelAndView agregarMetodo(ModelMap session, Model model) {
		ModelAndView mov= new ModelAndView(Constants.AGREGAR_PAGO);
		Cliente cli = (Cliente)session.get("clienteSession");
		mov.addObject("nombre",cli.getNombre());
		return mov;
	}
}
