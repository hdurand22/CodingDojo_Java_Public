package com.hayden.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hayden.lookify.models.Song;
import com.hayden.lookify.services.SongService;

@Controller
public class SongsController {
	private final SongService songService;
	
	public SongsController(SongService songService) {
		this.songService = songService;
	}
	
	// Splash screen
	@RequestMapping("/")
	public String index() {
		return "/lookify/index.jsp";
	}
	
	// Dashboard render
	@RequestMapping("/dashboard")
	public String dashboard(Model model, Song song) {
		List<Song> songs = songService.allSongs();
		
		if (songs == null) {
			model.addAttribute("songs", null);
		}
		else {
			model.addAttribute("songs", songs);
		}
		return "/lookify/dashboard.jsp";
	}
	
	// New song form render
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("newSong") Song newSong) {
		return "/lookify/new.jsp";
	}
	
	
	// Top Ten render
	@RequestMapping("/search/topTen")
	public String topTen(Model model) {
		List<Song> topTen = songService.topTenSongs();
		
		if (topTen == null) {
			model.addAttribute("songs", null);
		}
		else {
			model.addAttribute("songs", topTen);
		}
		return "/lookify/topten.jsp";
	}
	
	// Handle new song post request
	@RequestMapping(value="/songs/addSong", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("newSong") Song newSong, BindingResult result) {
		if (result.hasErrors()) {
			return "/lookify/new.jsp";
		}
		else {
			songService.createSong(newSong);
			return "redirect:/dashboard";
		}
	}
	
	// Show details of a song
	@RequestMapping("/songs/{id}")
	public String showDetails(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "/lookify/show.jsp";
	}
	
	// Handle search for artist
	@RequestMapping("/search")
	public String searchArtist(@RequestParam("query") String query, Model model) {
		List<Song> searchResults = songService.findSongsByArtist(query);
		model.addAttribute("query", query);
		model.addAttribute("songs", searchResults);
		return "/lookify/artistsearchresults.jsp";
	}
	
//	// Render artist search
//	@RequestMapping("/search/{artist}")
//	public String showSearchResults(@RequestParam("artistSearch") String artist, Model model) {
//		model.addAttribute("artist", artist);
//		return "/lookify/artistsearchresults.jsp";
//	}
	
	// Delete a song
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	
}
