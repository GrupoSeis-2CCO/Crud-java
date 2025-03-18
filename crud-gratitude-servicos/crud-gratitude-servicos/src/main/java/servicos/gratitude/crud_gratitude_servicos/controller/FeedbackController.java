package servicos.gratitude.crud_gratitude_servicos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servicos.gratitude.crud_gratitude_servicos.entity.Feedback;
import servicos.gratitude.crud_gratitude_servicos.service.FeedbackService;

import java.util.List;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {
    private final FeedbackService service;

    public FeedbackController(FeedbackService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Feedback> cadastrar(@RequestBody Feedback feedback) {
        return ResponseEntity.status(201).body(service.cadastrar(feedback));
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> atualizar(@PathVariable Integer id, @RequestBody Feedback feedback) {
        return ResponseEntity.ok(service.atualizar(id, feedback));
    }
}