package com.edoatley.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.edoatley.model.Game;

@Controller
@SessionAttributes("game")
public class GameController {

	// default game of 10 for initial load
	@RequestMapping(value = "addGame", method = RequestMethod.GET)
	public String addGame(Model model) {

		Game game = new Game();
		game.setMinutes(10);
		model.addAttribute("game", game);
		
		return "addGame"; 	 //out and back in
	}
	
	@RequestMapping(value = "addGame", method = RequestMethod.POST)
	public String updateGame(@Valid @ModelAttribute("game") Game game, BindingResult result) {
		System.out.println("Errors? = " + result.hasErrors());
		System.out.println("Game " + game.getMinutes());
		
		if(result.hasErrors()) {
			return "addGame";
		}
		
		return "redirect:addMinutes.html";
	}
	
}
