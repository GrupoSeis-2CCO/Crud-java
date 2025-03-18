package servicos.gratitude.crud_gratitude_servicos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servicos.gratitude.crud_gratitude_servicos.entity.Aula;
import servicos.gratitude.crud_gratitude_servicos.service.AulaService;

import java.util.List;

@RestController
@RequestMapping("/aulas")
public class AulaController {
    private final AulaService service;

    public AulaController(AulaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Aula> cadastrar(@RequestBody Aula aula) {

        return ResponseEntity.status(201).body(service.cadastrar(aula));
    }

    @GetMapping
    public ResponseEntity<List<Aula>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aula> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aula> atualizar(@PathVariable Integer id, @RequestBody Aula aula) {
        return ResponseEntity.ok(service.atualizar(id, aula));
    }
}