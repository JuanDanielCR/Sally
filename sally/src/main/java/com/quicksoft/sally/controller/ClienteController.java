package com.quicksoft.sally.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
	private ClienteService clienteService;
	
	private Cliente clienteActual;
	
	@GetMapping("/consulta")
	public ModelAndView consultarPerfil(ModelMap session, Model model) {
		ModelAndView mov= new ModelAndView(Constants.VER_PERFIL);
		User clienteActivo = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		clienteActual = (Cliente)session.get("clienteSession");
		if(clienteActual == null) {
			clienteActual = clienteService.buscarCliente(clienteActivo.getUsername());
		}
		mov.addObject("nombre",clienteActual.getNombre());
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
