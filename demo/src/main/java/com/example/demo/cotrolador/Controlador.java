package com.example.demo.cotrolador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelos.Anime;
import com.example.demo.modelos.User;
import com.example.demo.repositorios.UserRepository;
import com.example.demo.service.AnimeService;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@Controller
public class Controlador {

	@Autowired
	private UserService service;

	@Autowired
	private AnimeService serviceA;

	@GetMapping("/")
	public String inicio(Model m) {
		m.addAttribute("user", new User());
		return "Pruebas";
	}
	
	@GetMapping("/series")
	public String series(Model m) {
		m.addAttribute("user", new User());
		return "Series";
	}

	@GetMapping("/formularioLogin")
	public String Login(Model m) {
		m.addAttribute("user", new User());
		return "Formulario";
	}

	@GetMapping("/formularioRegister")
	public String Register(Model m) {
		m.addAttribute("user", new User());
		return "Formulario";
	}

	@GetMapping("/directorio")
	public String verDirectorio(Model m) {
		m.addAttribute("user", new User());
		return "Directorio";
	}

	@GetMapping("/datosSerie")
	public String verDatos(Model m) {
		m.addAttribute("user", new User());
		return "DatosSerie";
	}

	@GetMapping("/crearAnime")
	public String crearSeriesAnime(@ModelAttribute("anime") Anime use) {
		return "formCrearAnime";
	}
	
	@RequestMapping("/procesarCrearAnime")
	public String procesarCrearSeriesAnime(@Valid @ModelAttribute("anime") Anime use, BindingResult thebindingresult,Model m ) {
		if (thebindingresult.hasErrors()) {
			return "formCrearAnime";
		} else {
			serviceA.crearAnime(use);
			m.addAttribute("user", new User());
			return "Pruebas";
		}
	}

	@RequestMapping("/processForm")
	public String showCustomerData(@Valid @ModelAttribute("user") User use, BindingResult thebindingresult) {
		if (thebindingresult.hasErrors()) {
			return "Formulario";
		} else {
			service.crearUsuario(use);
			return "Pruebas";
		}
	}

}
