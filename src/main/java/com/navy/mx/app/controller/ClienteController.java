package com.navy.mx.app.controller;

import java.util.Date;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.navy.mx.app.models.dao.IClienteDao;
import com.navy.mx.app.models.entity.Cliente;

@Controller
@SessionAttributes("clientes")
public class ClienteController {

	@Autowired
	private IClienteDao clienteDao;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Lista de clientes");
		model.addAttribute("clientes", clienteDao.findAll());
		return "listar";
	}

	@RequestMapping(value = "/formulario")
	public String CrearCliente(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("titulo", "Clientes ");
		model.put("cliente", cliente);

		return "formulario";

	}

	/*
	 * @RequestMapping(value="/formulario/{/id}") public String
	 * editar(@PathVariable(value="id")Long id,Map<String,Object>model) { Cliente
	 * cliente=null;
	 * 
	 * if(id>0) { cliente=clienteDao.findOne(id); }else { return"redirect:/listar";
	 * } model.put("cliente",cliente); model.put("titulo","Editar Cliente");
	 * 
	 * return"formulario"; }
	 */

	@RequestMapping(value = "/formulario/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {

		Cliente cliente = null;

		if (id > 0) {
			cliente = clienteDao.findOne(id);
		} else {
			return "redirect:/listar";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar Cliente");
		return "formulario";
	}

	@RequestMapping(value = "/formulario", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Lista de clientes");

			return "formulario";
		}
		clienteDao.save(cliente);
		status.setComplete();
		return "redirect:listar";

	}

	@RequestMapping(value = "/login")
	public String loginUser(@Valid Cliente cliente, BindingResult result, Model model) {
		model.addAttribute("login", "ingrese contraseña");

		return "login";
	}

	@RequestMapping(value = "/eliminar/{id}")
	public String delete(@PathVariable(value = "id") Long id) {

		if (id > 0) {
			clienteDao.delete(id);
		}

		return "redirect:/listar";

	}

}
