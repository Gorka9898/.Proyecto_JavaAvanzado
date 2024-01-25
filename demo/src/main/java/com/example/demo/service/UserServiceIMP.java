package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelos.User;
import com.example.demo.repositorios.UserRepository;


@Service
public class UserServiceIMP implements UserService{
	
	@Autowired
	private UserRepository repo;
     

	@Override
	public void crearUsuario(User usuario) {
		
		repo.save(usuario);
		
		
	}

}
