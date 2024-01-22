package org.lessons.jaita.blogricette.controller;

import jakarta.validation.Valid;
import org.lessons.jaita.blogricette.model.Ricetta;
import org.lessons.jaita.blogricette.repository.RicettaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Ricetta> result = ricettaRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("ricetta", result.get());
            return "ricette/edit";

        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ricetta con id " + id + " non trovata");
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Integer id, @Valid @ModelAttribute("ricetta") Ricetta formRicetta, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "ricette/edit";
        } else {
            Ricetta updateRicetta = ricettaRepository.save(formRicetta);
            return "redirect:/ricette";
        }
    }

    @GetMapping("/create")
    public String create(Model model) {
        Ricetta ricetta = new Ricetta();
        model.addAttribute("ricetta", ricetta);
        return "ricette/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("ricetta") Ricetta formRicetta, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "ricette/create";
        } else {
            Ricetta newRicetta = ricettaRepository.save(formRicetta);
            return "redirect:/ricette";
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Optional<Ricetta> result = ricettaRepository.findById(id);
        if (result.isPresent()) {
            ricettaRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("redirectMessage", "La ricetta " + id + " è stata eliminata");
            return "redirect:/ricette";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ricetta con id " + id + " non trovata");
        }
    }
}
