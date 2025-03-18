package servicos.gratitude.crud_gratitude_servicos.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import servicos.gratitude.crud_gratitude_servicos.entity.Curso;
import servicos.gratitude.crud_gratitude_servicos.repository.CursoRepository;
import servicos.gratitude.crud_gratitude_servicos.service.CursoService;


import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService service;
    private final CursoRepository repository;

    public CursoController(CursoService service, CursoRepository repository) {
        this.service = service;
        this.repository = repository;
    }


    @PostMapping
    public ResponseEntity<Curso> cadastrar(@RequestBody Curso curso) {
        return ResponseEntity.status(201).body(service.cadastrar(curso));
    }

    @GetMapping
    public ResponseEntity<List<Curso>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizar(@PathVariable Integer id, @RequestBody Curso curso) {
        return ResponseEntity.ok(service.atualizar(id, curso));
    }
}