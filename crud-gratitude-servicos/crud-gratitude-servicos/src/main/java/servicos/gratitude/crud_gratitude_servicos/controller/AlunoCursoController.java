package servicos.gratitude.crud_gratitude_servicos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servicos.gratitude.crud_gratitude_servicos.entity.AlunoCurso;
import servicos.gratitude.crud_gratitude_servicos.service.AlunoCursoService;

import java.util.List;

@RestController
@RequestMapping("/alunocursos")
public class AlunoCursoController {
    private final AlunoCursoService service;

    public AlunoCursoController(AlunoCursoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AlunoCurso> cadastrar(@RequestBody AlunoCurso alunoCurso) {
        return ResponseEntity.status(201).body(service.cadastrar(alunoCurso));
    }

    @GetMapping
    public ResponseEntity<List<AlunoCurso>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoCurso> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoCurso> atualizar(@PathVariable Integer id, @RequestBody AlunoCurso alunoCurso) {
        return ResponseEntity.ok(service.atualizar(id, alunoCurso));
    }
}