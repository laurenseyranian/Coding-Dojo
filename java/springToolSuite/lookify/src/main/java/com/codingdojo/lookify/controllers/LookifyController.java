package com.codingdojo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.LookifyService;

@Controller
public class LookifyController {
	private final LookifyService lookifyService;

	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}


////Route for CREATING a new song////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "/lookify/newSong.jsp";
	}

////POST route that CREATES an item and checks for errors in the form from the .JSP file/////////////////////////////////////////
	@RequestMapping(value = "/createSong", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song createSong, BindingResult result) {
		if (result.hasErrors()) {
			return "/lookify/newSong.jsp";
		} else {
			lookifyService.createSong(createSong);
			return "redirect:/dashboard";
		}
	}
	
////Route for READING welcome page//////////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/")
	public String dashboard() {
		return "/lookify/welcome.jsp";
	}
////Route for READING top ten songs page//////////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/search/topTen")
	public String topTen(Model model) {
		model.addAttribute("songs", lookifyService.topTen());
		return "/lookify/topTen.jsp";
	}	
////Route for READING all songs//////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/dashboard")
	public String index(Model model) {
		List<Song> songs = lookifyService.allSongs();
		model.addAttribute("songs", songs);
		return "/lookify/dashboard.jsp";
	}
////Route for READING one song////////////////////////////////////////////////////////////////////////////////////////////////////
	@GetMapping("/songs/{song_id}")
	public String show(Model model, @PathVariable("song_id") String id) {
		model.addAttribute("song", lookifyService.findSong((long) Integer.parseInt(id)));
		return "/lookify/viewOneSong.jsp";
	}

////Route for UPDATING one song/////////////////////////////////////////////////////////////////////////////////////////////////
//	@RequestMapping("/songs/{song_id}/edit")
//	public String edit(@PathVariable("isong_id") Long id, Model model) {
//		Song song = lookifyService.findSong(id);
//		model.addAttribute("item", song);
//		return "/lookify/update.jsp";
//	}

////POST route that UPDATES a song and checks for errors in the form from the .JSP file////////////////////////////////////////
//	@RequestMapping("/updateSong/{item_id}")
//	public String update(@Valid @ModelAttribute("song") Song updateSong, BindingResult result,
//			@PathVariable("song_id") Long id) {
//		if (result.hasErrors()) {
//			return "/lookify/update.jsp";
//		} else {
//			updateItem.setId(id);
//			lookifyService.updateItem(updateItem);
//			return "redirect:/dashboard";
//		}
//	}

////Route for DELETING a song////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/songs/{song_id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("song_id") Long id) {
		lookifyService.deleteSong(id);
		return "redirect:/dashboard";
	}

////Route for handing SEARCH from search bar from .JSP files///////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/search")
	public String search(@RequestParam("search") String search, Model model) {
		List<Song> songs = lookifyService.findArtistSongs(search);
		model.addAttribute("song", songs);
		return "redirect:/search/" + search;
	}
	
//// Route that is actually performing the SEARCH an artist and rending the .JSP file///////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/search/{search}")
	public String searchSong(@PathVariable("search") String search, Model model) {
		List<Song> songs = lookifyService.findArtistSongs(search);
		model.addAttribute("songs", songs);
		return "/lookify/artistSearchResults.jsp";
	}
}

