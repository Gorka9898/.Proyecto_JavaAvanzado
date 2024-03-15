package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.modelos.Anime;
import com.example.demo.modelos.ERole;
import com.example.demo.modelos.Role;
import com.example.demo.modelos.Serie;
import com.example.demo.repositorios.AnimeRepository;
import com.example.demo.repositorios.RoleRepository;
import com.example.demo.repositorios.SerieRepository;

@SpringBootTest
class CaviarApplicationTests {

	@Autowired
	AnimeRepository animeRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	SerieRepository serieRepository;
	
	@Test
	void contextLoadsRoles() {
		if(!roleRepository.existsById(new Long(1))) {
			Role rol1 = new Role(ERole.ROLE_USER);
			roleRepository.save(rol1);
			Role rol2 = new Role(ERole.ROLE_MODERATOR);
			roleRepository.save(rol2);
			Role rol3 = new Role(ERole.ROLE_ADMIN);
			roleRepository.save(rol3);
		}
		
	}
	@Test
	void contextLoadsAnime() {
		animeRepository.deleteAll();
		Anime anim1 = new Anime(new Long(1), "ACCION", "Frierena", 288, "EMISION<", "img/Portadas/Frieren.jpg", 9,
				"Maga que hace cosasa");
		animeRepository.save(anim1);

		Anime anim2 = new Anime(new Long(2), "ACCION", "Gate", 14, "EMISION", "img/Portadas/Gate.jpg", 9,
				"Trama. En pleno siglo XXI, una misteriosa puerta aparece  en Ginza (Tokio). De este misterioso artefacto comienzan a aparecer monstruos, caballeros de la edad media y ...");
		animeRepository.save(anim2);

		Anime anim3 = new Anime(new Long(3), "AVENTURA", "Dr.Stone", 28, "FINALIZADO", "img/Portadas/Dr.Stone.jpg", 9, "La historia cuenta las aventuras de Senku y Taiju...");
		animeRepository.save(anim3);

		Anime anim4 = new Anime(new Long(4),  "AVENTURA", "Hunter X Hunter", 128, "FINALIZADO", "img/Portadas/Hunter_x_Hunter.jpg", 9, "Hunter × Hunter...");
		animeRepository.save(anim4);

		Anime anim5 = new Anime(new Long(5), "DEPORTES", "Haikyuu", 12, "FINALIZADO", "img/Portadas/Haikyuu.jpg", 9, "¡Basado en el popular manga shounen...");
		animeRepository.save(anim5);

		Anime anim6 = new Anime(new Long(6), "ACCION", "Full Metal Alchemist", 28, "FINALIZADO", "img/Portadas/Full_Metal.jpg", 7, "Aqui iria la descripcion");
		animeRepository.save(anim6);

		Anime anim7 = new Anime(new Long(7), "COMEDIA", "Konosuba", 32, "FINALIZADO", "img/Portadas/Konosuba.jpg", 8, "Aqui iria la descripcion");
		animeRepository.save(anim7);

		Anime anim8 = new Anime(new Long(8), "AVENTURA", "Log Horizon 2", 28, "FINALIZADO", "img/Portadas/Log_Horizon_2.jpg", 5, "Aqui iria la descripcion");
		animeRepository.save(anim8);

		Anime anim9 = new Anime(new Long(9), "ACCION", "Jigokuraku", 28, "FINALIZADO", "img/Portadas/Jigokuraku.jpg", 7, "Aqui iria la descripcion");
		animeRepository.save(anim9);

		Anime anim10 = new Anime(new Long(10), "ACCION", "Jujutsu Kaisen", 28, "FINALIZADO", "img/Portadas/Jujutsu.jpg", 8, "Aqui iria la descripcion");
		animeRepository.save(anim10);

		Anime anim11 = new Anime(new Long(11), "DRAMA", "Mahotsukai no yome 2", 28, "FINALIZADO", "img/Portadas/mahotsukai_no_yome2.jpg", 6, "Aqui iria la descripcion");
		animeRepository.save(anim11);

		Anime anim12 = new Anime(new Long(12), "TERROR", "Mieruko", 28, "FINALIZADO", "img/Portadas/Mieruko.jpg", 7, "Aqui iria la descripcion");
		animeRepository.save(anim12);

		Anime anim13 = new Anime(new Long(13), "ACCION", "Mob Psycho", 28, "FINALIZADO", "img/Portadas/Mob_Psycho.jpg", 8, "Aqui iria la descripcion");
		animeRepository.save(anim13);

		Anime anim14 = new Anime(new Long(14), "COMEDIA", "Nanbaka", 28, "FINALIZADO", "img/Portadas/Nanbaka.jpg", 6, "Aqui iria la descripcion");
		animeRepository.save(anim14);

		Anime anim15 = new Anime(new Long(15), "AVENTURA", "One Piece", 28, "FINALIZADO", "img/Portadas/One_piece.jpg", 9, "Aqui iria la descripcion");
		animeRepository.save(anim15);

		Anime anim16 = new Anime(new Long(16), "AVENTURA", "Singeki no Kyojin", 28, "FINALIZADO", "imgPortadas-series/breaking-bad.jpg", 9, "Aqui iria la descripcion");
		animeRepository.save(anim16);

	}
	
	
	@Test
	void contextLoadsSeries() {
		serieRepository.deleteAll();
		Serie serie1 = new Serie(new Long(1), "DRAMA", "Breaking Bad", 28, "FINALIZADO", "img/Portadas-series/breaking-bad.jpg", 9, "Aqui iria la descripcion");
		serieRepository.save(serie1);
		
		Serie serie2 = new Serie(new Long(2), "TERROR", "Dark", 28, "FINALIZADO", "img/Portadas-series/dark.jpg", 8, "Aqui iria la descripcion");
		serieRepository.save(serie2);
		
		Serie serie3 = new Serie(new Long(3), "DRAMA", "El Silencio", 28, "FINALIZADO", "img/Portadas-series/el-silencio.jpg", 6, "Aqui iria la descripcion");
		serieRepository.save(serie3);
		
		Serie serie4 = new Serie(new Long(4), "DRAMA", "Golden Age", 28, "FINALIZADO", "img/Portadas-series/golden_age.jpg", 8, "Aqui iria la descripcion");
		serieRepository.save(serie4);
		
		Serie serie5 = new Serie(new Long(5), "MISTERIO", "Los 100", 28, "FINALIZADO", "img/Portadas-series/los-100.jpg", 9, "Aqui iria la descripcion");
		serieRepository.save(serie5);
		
		Serie serie6 = new Serie(new Long(6), "ACCION", "Outlander", 28, "FINALIZADO", "img/Portadas-series/outlander.jpg", 6, "Aqui iria la descripcion");
		serieRepository.save(serie6);
		
		Serie serie7 = new Serie(new Long(7), "ACCION", "The Last of Us", 28, "FINALIZADO", "img/Portadas-series/the_last_of_us.jpg", 7, "Aqui iria la descripcion");
		serieRepository.save(serie7);
		
		Serie serie8 = new Serie(new Long(8), "DRAMA", "The Undoing", 28, "FINALIZADO", "img/Portadas-series/the_undoing.jpg", 5, "Aqui iria la descripcion");
		serieRepository.save(serie8);
		
		Serie serie9 = new Serie(new Long(9), "DRAMA", "Tower", 28, "FINALIZADO", "img/Portadas-series/tower.jpg", 7, "Aqui iria la descripcion");
		serieRepository.save(serie9);
		
		Serie serie10 = new Serie(new Long(10), "ACCION", "Warrior", 28, "FINALIZADO", "img/Portadas-series/warrior.jpg", 8, "Aqui iria la descripcion");
		serieRepository.save(serie10);
	
	}

}
