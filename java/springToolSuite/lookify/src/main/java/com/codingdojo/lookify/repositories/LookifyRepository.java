package com.codingdojo.lookify.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.lookify.models.Song;

@Repository
public interface LookifyRepository extends CrudRepository<Song, Long>{
//---------------------------------------------------------------------------------------
// FIND all songs
//---------------------------------------------------------------------------------------
	List<Song> findAll();
//---------------------------------------------------------------------------------------
// SEARCH for an artist
//---------------------------------------------------------------------------------------
	List<Song> findByArtistContaining(String search);
//---------------------------------------------------------------------------------------
// FIND top 10 songs
//---------------------------------------------------------------------------------------
	List<Song> findTop10ByOrderByRatingDesc();
}
