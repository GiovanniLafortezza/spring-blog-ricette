package org.lessons.jaita.blogricette.controller;

import org.lessons.jaita.blogricette.model.Ricetta;
import org.lessons.jaita.blogricette.repository.RicettaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ricette")
public class RicettaController {
    @Autowired
    RicettaRepository ricettaRepository;

    @GetMapping
    public String index(Model model) {
        List<Ricetta> ricettaList = ricettaRepository.findAll();
        model.addAttribute("ricettaList", ricettaList);
        return "ricette/list";
    }
}
