package com.edoatley.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edoatley.service.NightsService;

@Controller
public class NightsController {

	@Autowired
	private NightsService nightsService;
	
    @RequestMapping("/nights")
    public String nights(Model model) {
        return "nights";
    }
}
