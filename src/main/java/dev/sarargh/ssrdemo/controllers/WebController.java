package dev.sarargh.ssrdemo.controllers;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class HelloController {


    public void addControllers() {
        HashMap<String, String> menu = new HashMap<>();
        menu.put("/", "Home");
        menu.put("/about", "About us");
        menu.put("/contact", "Contact us");
    }

    @GetMapping({"/", "/hello"})
    public String hello(Model model,
                        @RequestParam(
                                value = "name",
                                required = false,
                                defaultValue = "World") String name) {
        model.addAttribute("name", name);
        model.addAttribute("module", "home");
                return "hello";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("module", "about");
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("module", "contact");
        return "contact";
    }
}
