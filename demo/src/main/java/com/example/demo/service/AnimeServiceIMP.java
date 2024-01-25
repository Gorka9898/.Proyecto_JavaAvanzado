package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelos.Anime;
import com.example.demo.repositorios.AnimeRepository;

@Service
public class AnimeServiceIMP implements AnimeService{
	
	@Autowired
	private AnimeRepository repo;
     

	@Override
	public void crearAnime(Anime anime) {
		
		repo.save(anime);
		
		
	}

}