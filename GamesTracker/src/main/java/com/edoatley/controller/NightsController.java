package com.edoatley.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NightsController {

    @RequestMapping("/nights")
    public String welcome(Model model) {
        return "nights";
    }
}
