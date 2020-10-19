package com.navy.mx.app.models.dao.service;

import java.util.List;

import com.navy.mx.app.models.entity.Cliente;

public interface IClienteServiceDao {
	
public List<Cliente>findAll();
	
	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);

}
