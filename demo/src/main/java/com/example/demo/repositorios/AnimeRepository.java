package com.example.demo.repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelos.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Serializable> {

}
