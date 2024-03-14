package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelos.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {
}
