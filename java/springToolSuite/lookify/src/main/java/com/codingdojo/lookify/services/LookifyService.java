package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	private final LookifyRepository lookifyRepository;

	public LookifyService(LookifyRepository lookifyRepository) {
        this.lookifyRepository = lookifyRepository;
    }

	public List<Song> allSongs() {
		return lookifyRepository.findAll();
	}

////CREATES one song/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Song createSong(Song createSong) {
		return lookifyRepository.save(createSong);
	}

////READS one song by id/////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Song findSong(Long id) {
		Optional<Song> optionalSong = lookifyRepository.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
////READ Top Ten Songs/////////////////////////////////////////////////////////////////////////////////////////
	public List<Song> topTen() {
		return lookifyRepository.findTop10ByOrderByRatingDesc();
	}
////UPDATES one song/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public Song updateSong(Song updateSong) {
//        return lookifyRepository.save(updateSong);
//    }

////UPDATES one song by id///////////////////////////////////////////////////////////////////////////////////////////////////////
//	public Song updateSong(Long id, String title, String artist, int rating) {
//		Song updateSong = this.findSong(id);
//		updateSong.setTitle(title);
//		updateSong.setArtist(artist);
//		updateSongm.setRating(rating);
//		lookifyRepository.save(updateSong);
//		return updateSong;
//	}
	
////DELETES one song by id///////////////////////////////////////////////////////////////////////////////////////////////////////
	public void deleteSong(Long id) {
		Song deleteSong = this.findSong(id);
		lookifyRepository.delete(deleteSong);
	}
	
////SEARCH for song by typing artist name/////////////////////////////////////////////////////////////////////////////////////////
	public List<Song> findArtistSongs(String search) {
		return lookifyRepository.findByArtistContaining(search);
	}
}
