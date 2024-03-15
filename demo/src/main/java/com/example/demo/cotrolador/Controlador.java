package com.example.demo.cotrolador;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelos.Anime;
import com.example.demo.modelos.ERole;
import com.example.demo.modelos.Role;
import com.example.demo.modelos.Serie;
import com.example.demo.modelos.User;
import com.example.demo.repositorios.AnimeRepository;
import com.example.demo.repositorios.RoleRepository;
import com.example.demo.repositorios.SerieRepository;
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
	  SerieRepository serieRepository;
	  
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
	
	@GetMapping("/seriesLoged")
	public String seriesLoged(Model m) {
		m.addAttribute("user", new User());
		return "HomePostInicioSesion";
	}
	
	@GetMapping("/animeLoged")
	public String animeLoged(Model m) {
		m.addAttribute("user", new User());
		return "AnimePostInicioSession";
	}

	@GetMapping("/formularioLogin")
	public String Login(Model m, ModelMap mp) {
		m.addAttribute("user", new User());
		mp.addAttribute("roles", roleRepository.findAll());
		return "FormularioInicio";
	}

	@GetMapping("/formularioRegister")
	public String Register(Model m, ModelMap mp) {
		m.addAttribute("user", new User());
		mp.addAttribute("roles", roleRepository.findAll());
		return "Formulario";
	}
	
	@GetMapping("/loged")
	public String Iniciado(Model m) {
		m.addAttribute("user", new User());
		return "HomePostInicioSesion";
	}
	
	@GetMapping("/logout")
	public String paFuera(Model m) {
		m.addAttribute("user", new User());
		return "Logout";
	}

	@GetMapping("/directorio")
	public String verDirectorio(Model m) {
		m.addAttribute("user", new User());
		m.addAttribute("anime", animeRepository.findAll());
		return "Directorio";
	}
	
	@GetMapping("/directorioSeries")
	public String verDirectorioSeries(Model m) {
		m.addAttribute("user", new User());
		m.addAttribute("serie", serieRepository.findAll());
		return "DirectorioSeries";
	}
	
	@GetMapping("/directorioSeriesLoged")
	public String verDirectorioSeriesLogedo(Model m) {
		m.addAttribute("user", new User());
		m.addAttribute("serie", serieRepository.findAll());
		return "directorioSeriesLoged";
	}
	
	@GetMapping("/directorioAnimeLoged")
	public String verDirectorioAnimeLogedo(Model m) {
		m.addAttribute("user", new User());
		m.addAttribute("anime", animeRepository.findAll());
		return "directorioAnimeLoged";
	}
	

	@GetMapping("/datosSerie")
	public String verDatos(Model m, @RequestParam Long id) {
		Serie serie1= serieRepository.findById(id).orElse(null);
		m.addAttribute("serie", serie1);
		
		return "DatosSerie";
	}
	
	@GetMapping("/datosSerieAnime")
	public String verDatosAnime(Model m, @RequestParam Long id) {
		Anime anime1= animeRepository.findById(id).orElse(null);
		m.addAttribute("anime", anime1);
		
		return "DatosSerieAnime";
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
	
	//ADMIN
	
	@GetMapping("/admin")
	public String admin(Model m) {
		m.addAttribute("user", userRepository.findAll());
		return "Admin";
	}
	
	@GetMapping("/tablaSeries")
	public String tablaSeries(Model m) {
		m.addAttribute("serie", serieRepository.findAll());
		return "TablaSerie";
	}
	
	@GetMapping("/tablaAnimes")
	public String tablaAnimes(Model m) {
		m.addAttribute("anime", animeRepository.findAll());
		return "TablaAnime";
	}
	
    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id, Model m) {
    	userRepository.deleteById(id);
    	m.addAttribute("user", userRepository.findAll());
        return "Admin";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Optional<User> usuario = userRepository.findById(id);
        model.addAttribute("usuario", usuario);
        return "formulario_edicion";
    }
	
    //No va
    @PostMapping("/actualizar")
    public String actualizarUsuario(@ModelAttribute("usuario") User usuario, Model m) {
    	m.addAttribute("user", userRepository.findAll());
        return "Admin";
    }
	
	
	
}
