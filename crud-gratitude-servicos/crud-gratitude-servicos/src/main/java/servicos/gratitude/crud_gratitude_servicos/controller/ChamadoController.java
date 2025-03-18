package servicos.gratitude.crud_gratitude_servicos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servicos.gratitude.crud_gratitude_servicos.entity.Chamado;
import servicos.gratitude.crud_gratitude_servicos.service.ChamadoService;

import java.util.List;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {
    private final ChamadoService service;

    public ChamadoController(ChamadoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Chamado> cadastrar(@RequestBody Chamado chamado) {
        return ResponseEntity.status(201).body(service.cadastrar(chamado));
    }

    @GetMapping
    public ResponseEntity<List<Chamado>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chamado> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chamado> atualizar(@PathVariable Integer id, @RequestBody Chamado chamado) {
        return ResponseEntity.ok(service.atualizar(id, chamado));
    }
}