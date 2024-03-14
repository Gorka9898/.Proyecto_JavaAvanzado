package com.example.demo.cotrolador;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.modelos.Anime;
import com.example.demo.modelos.ERole;
import com.example.demo.modelos.Role;
import com.example.demo.modelos.User;
import com.example.demo.repositorios.AnimeRepository;
import com.example.demo.repositorios.RoleRepository;
import com.example.demo.repositorios.UserRepository;
import com.example.demo.requests.LoginRequest;
import com.example.demo.requests.SignupRequest;
import com.example.demo.responses.MessageResponse;
import com.example.demo.responses.UserInfoResponse;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.service.AnimeService;
import com.example.demo.service.UserDetailsImpl;


import jakarta.validation.Valid;

@Controller
public class Controlador {
	
	  @Autowired
	  AuthenticationManager authenticationManager;

	  @Autowired
	  UserRepository userRepository;

	  @Autowired
	  RoleRepository roleRepository;
	  
	  @Autowired
	  AnimeRepository animeRepository;

	  @Autowired
	  PasswordEncoder encoder;

	  @Autowired
	  JwtUtils jwtUtils;

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
	public String Login(Model m, ModelMap mp) {
		m.addAttribute("user", new User());
		mp.addAttribute("roles", roleRepository.findAll());
		return "Formulario";
	}

	@GetMapping("/formularioRegister")
	public String Register(Model m, ModelMap mp) {
		m.addAttribute("user", new User());
		mp.addAttribute("roles", roleRepository.findAll());
		return "Formulario";
	}

	@GetMapping("/directorio")
	public String verDirectorio(Model m) {
		m.addAttribute("user", new User());
		m.addAttribute("anime", animeRepository.findAll());
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
	
	
}
