package com.edoatley.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edoatley.model.Player;

@Controller
public class PlayerController {

	@RequestMapping(value = "/addPlayer")
	public String addPlayer(@ModelAttribute("exercise") Player player) {

		System.out.println("Player " + player.getName());
		
		return "addPlayer"; 	 //out and back in
	}

}
