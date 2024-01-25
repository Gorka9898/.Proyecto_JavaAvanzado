package com.example.demo.repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelos.User;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable>{

}
