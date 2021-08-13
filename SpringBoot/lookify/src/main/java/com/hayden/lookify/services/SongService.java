package com.hayden.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hayden.lookify.models.Song;
import com.hayden.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	// Get all songs
	public List<Song> allSongs() {
		return songRepository.findAll();
	}
	
	// Get all songs sorted by rating
	public List<Song> topTenSongs() {
		return songRepository.findTop10ByOrderByRatingDesc();
	}
	
	// Get one song
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		}
		else {
			return null;
		}
	}
	
	// Get all songs by an artist
	public List<Song> findSongsByArtist(String artist) {
		return songRepository.findByArtist(artist); 
	}
	
	// Create a song
	public Song createSong(Song s) {
		return songRepository.save(s);
	}
	
	// Update a song
	public Song updateSong(Song s) {
		return songRepository.save(s);
	}
	
	// Delete a song
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
		System.out.println("Song deleted!");
		
	}
}
