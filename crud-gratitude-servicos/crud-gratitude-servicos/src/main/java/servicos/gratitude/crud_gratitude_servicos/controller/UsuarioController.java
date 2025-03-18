package servicos.gratitude.crud_gratitude_servicos.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servicos.gratitude.crud_gratitude_servicos.repository.UsuarioRepository;
import servicos.gratitude.crud_gratitude_servicos.entity.Usuario;
import servicos.gratitude.crud_gratitude_servicos.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository repository;

    public final UsuarioService service;

    public UsuarioController(UsuarioRepository repository, UsuarioService service) {
        this.repository = repository;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(
            @Valid
            @RequestBody Usuario usuario
    ) {
        return ResponseEntity.status(201).body(service.cadastrar(usuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> usuarios  = service.listar();

        if (usuarios.isEmpty()){
            return ResponseEntity.status(204).body(usuarios);
        }

        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuariosPorId(
            @PathVariable Integer id
    ) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(
            @PathVariable Integer id
    ) {
       service.deletar(id);
       return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario (
            @Valid
            @PathVariable Integer id,
            @RequestBody Usuario usuarioParaAtualizar
    ) {
        return ResponseEntity.ok(service.atualizar(id,usuarioParaAtualizar));
    }
}