package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelos.Anime;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {
}
