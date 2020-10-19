package com.navy.mx.app.models.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.navy.mx.app.models.dao.IClienteDao;
import com.navy.mx.app.models.entity.Cliente;

@Service
public class ClienteServiceDaoImpl implements IClienteServiceDao {
	
	@Autowired
	private IClienteDao iClienteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return iClienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		// TODO Auto-generated method stub
		iClienteDao.save(cliente);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		// TODO Auto-generated method stub
		return iClienteDao.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		iClienteDao.delete(id);
		
	}
	

}
