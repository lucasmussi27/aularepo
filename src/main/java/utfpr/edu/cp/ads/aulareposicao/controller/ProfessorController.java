package utfpr.edu.cp.ads.aulareposicao.controller;
import java.util.*;
import java.util.stream.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import utfpr.edu.cp.ads.aulareposicao.model.*;

@Controller
public class ProfessorController {
    private List<Professor> profs;

    public ProfessorController() {
        profs = Stream.of(
            Professor.builder().id(1).nomeProf("Kurt Cobain").build(),
            Professor.builder().id(2).nomeProf("Chris Cornell").build(),
            Professor.builder().id(3).nomeProf("Ozzy Osbourne").build()
        ).collect(Collectors.toList());
    }

    @GetMapping("/professores")
    public String inicial(Model data) {
        data.addAttribute("profs", profs);
        return "prof-view";
    }

    @PostMapping("/professores/add")
    public String addOne(Professor prof) {
        prof.setId(profs.size() + 1);
        profs.add(prof);
        return "redirect:/professores";
    }

    @PutMapping("/professores/edit/{id}")
    public String editOne(@RequestParam int id, Model data) {
        Professor p = profs.get(id - 1);
        data.addAttribute("prof", p);
        data.addAttribute("profs", profs);
        return "prof-view";
    }
    
    @DeleteMapping("/professores/remove/{id}")
    public String removeOne(@RequestParam int id) {
        profs.remove(id - 1);
        return "redirect:/professores";
    }
}