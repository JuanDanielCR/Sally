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
import com.quicksoft.sally.service.ClienteService;

@Controller
@RequestMapping("/perfil")
@SessionAttributes("clienteSession")
public class ClienteController {
	@Autowired
	@Qualifier("clienteService")
	private ClienteService perfilService;
	
	@GetMapping("/consulta")
	public ModelAndView consultarPerfil(ModelMap session, Model model) {
		ModelAndView mov= new ModelAndView(Constants.VER_PERFIL);
		Cliente cli = (Cliente)session.get("clienteSession");
		mov.addObject("nombre",cli.getNombre());
		return mov;
	}
	
	@GetMapping("/cuenta")
	public ModelAndView cambiarCuenta(ModelMap session, Model model) {
		ModelAndView mov= new ModelAndView(Constants.VER_CUENTA);
		Cliente cli = (Cliente)session.get("clienteSession");
		mov.addObject("nombre",cli.getNombre());
		return mov;
	}
}
