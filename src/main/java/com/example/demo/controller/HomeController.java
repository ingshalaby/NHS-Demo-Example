package com.example.demo.controller;

import com.example.demo.model.Frequency;
import com.example.demo.model.RegularAmount;
import org.springframework.boot.context.properties.bind.validation.BindValidationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String getForm(@ModelAttribute RegularAmount regularAmount){
        return "index";
    }

    @PostMapping("/index")
    public String postForm(@ModelAttribute @Valid RegularAmount regularAmount, Model model, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            model.addAttribute("showError", true);
            return "index";
        }

        model.addAttribute("nhsForm", regularAmount);

        return "thanks";
    }
}
