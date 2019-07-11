package utfpr.edu.cp.ads.aulareposicao.controller;
import java.util.*;
import java.util.stream.*;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import utfpr.edu.cp.ads.aulareposicao.model.*;

@RestController
public class ReposicaoController {
    private List<Reposicao> repos;

    public ReposicaoController() {
        repos = Stream.of(
            Reposicao.builder()
                .id(1).professor(Professor.builder().nomeProf("Kurt Cobain").build())
                .aluno(Aluno.builder().nomeAluno("Dave Grohl").build())
                .horario(new Date(1991,09,11))
                .presenca(Presenca.NAOPRESENCIAL)
                .sincrono(Sincrono.ASINCRONO).build(),
            Reposicao.builder()
                .id(2).professor(Professor.builder().nomeProf("Lucas Mussi").build())
                .aluno(Aluno.builder().nomeAluno("Anny L.").build())
                .horario(new Date(2018,01,01))
                .presenca(Presenca.PRESENCIAL)
                .sincrono(Sincrono.SINCRONO).build()
        ).collect(Collectors.toList());
    }

    @GetMapping("/reposicoes")
    public ResponseEntity<List<Reposicao>> findAll() {
        return ResponseEntity.ok(repos);
    }

    @PostMapping("/reposicoes")
    public ResponseEntity<Reposicao> addOne(@Valid @RequestBody Reposicao repo) {
        repo.setId(repos.size() + 1);
        repos.add(repo);
        return ResponseEntity.status(201).body(repo);
    }

    @PutMapping("/reposicoes/{id}")
    public ResponseEntity<Reposicao> editOne(@PathVariable int id, @Valid @RequestBody Reposicao repo) {
        Optional<Reposicao> catched = repos.stream()
            .filter(e -> e.getId() == id).findAny();
        catched.ifPresent(e -> {
            e.setProfessor(repo.getProfessor());
            e.setAluno(repo.getAluno());
            e.setHorario(repo.getHorario());
            e.setPresenca(repo.getPresenca());
            e.setSincrono(repo.getSincrono());
        });
        return ResponseEntity.of(catched);
    }

    @DeleteMapping("/reposicoes/{id}")
    public ResponseEntity removeOne(@PathVariable int id) {
        if(repos.removeIf(e -> e.getId() == id))
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.notFound().build();
    }
}