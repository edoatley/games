package com.edoatley.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NightsController {

    @RequestMapping("/nights")
    public String nights(Model model) {
        return "nights";
    }
}
