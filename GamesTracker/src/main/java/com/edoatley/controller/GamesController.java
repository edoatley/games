package com.edoatley.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.edoatley.service.GamesService;

@Controller
@SessionAttributes("game")
public class GamesController {

	@Autowired
	private GamesService gamesService;
	
    @RequestMapping("/games")
    public String games(Model model) {
        return "games";
    }
//	// default game of 10 for initial load
//	@RequestMapping(value = "addGame", method = RequestMethod.GET)
//	public String addGame(Model model) {
//
//		model.addAttribute("game", game);
//		
//		return "g"; 	 //out and back in
//	}
//	
//	@RequestMapping(value = "addGame", method = RequestMethod.POST)
//	public String updateGame(@Valid @ModelAttribute("game") Game game, BindingResult result) {
//		System.out.println("Errors? = " + result.hasErrors());
//		System.out.println("Game " + game.getMinutes());
//		
//		if(result.hasErrors()) {
//			return "addGame";
//		}
//		
//		return "redirect:addMinutes.html";
//	}
	
}
