package com.edoatley.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlayerController {

    @RequestMapping("/players")
    public String players(Model model) {
        return "players";
    }
    
//	@RequestMapping(value = "/players")
//	public String addPlayer(@ModelAttribute("exercise") Player player) {
//
//		System.out.println("Player " + player.getName());
//		
//		return "players"; 	 //out and back in
//	}

}
