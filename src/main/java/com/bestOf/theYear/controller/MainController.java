package com.bestOf.theYear.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bestOf.theYear.Movie;
import com.bestOf.theYear.Song;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping()
	public String home(Model model) {
		model.addAttribute("mio_nome", "Adamo");
		return "index";
	}
	


	private List<Song> getBestSongs() {
		List<Song> songs = new ArrayList<>();

		songs.add(new Song(1, "canzone1"));
		songs.add(new Song(2, "canzone2"));
		songs.add(new Song(3, "canzone3"));

		return songs;
	}

	private List<Movie> getBestMovies() {
		List<Movie> movies = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			movies.add(new Movie(i + 1, "film" + (i + 1)));
		}

		return movies;
	}

	@GetMapping("/songs")
	public String songs(Model model) {
		model.addAttribute("canzoni", getBestSongs());
		return "songs";
	}
	
	@GetMapping("/songs/{id}") // richieste Get del tipo /songs/id
	public String dettaglioSong(Model model, @PathVariable("id") String id) {
		model.addAttribute("song", getBestSongs().get(Integer.parseInt(id)-1));

		return "song";
	}

	
	@GetMapping("/movies")
	public String movies(Model model) {
		model.addAttribute("films", getBestMovies());
		return "movies";
	}
	
	@GetMapping("/movies/{id}") // richieste Get del tipo /movies/id
	public String dettaglioMovie(Model model, @PathVariable("id") String id) {
		model.addAttribute("movie", getBestMovies().get(Integer.parseInt(id)-1));

		return "movie";
	}

}

//@GetMapping("/greeting")
//public String greeting(@RequestParam(name = "name") String name) {
//return new Greeting(name);
