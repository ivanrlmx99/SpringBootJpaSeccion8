package com.navy.mx.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.navy.mx.app.models.dao.IClienteDao;

@Controller
public class ClienteController{
	
	@Autowired
	private IClienteDao clienteDao;
	
	@RequestMapping(value="listarClientes",method = RequestMethod.GET)
	public String listar(Model model) {
	        model.addAttribute("titulo","Lista de clientes");
			model.addAttribute("clientes",clienteDao.findAll());
			 return "listar";
	}

}
