package com.yfy.beem.serverv2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * For the lulz.
 */
@Controller
public class MemeController {
    @GetMapping("meme")
    public String meme(Model model, @RequestParam(required = false) String name) {
        model.addAttribute("name", name == null ? "LUCY" : name);
        return "meme";

    }
}
