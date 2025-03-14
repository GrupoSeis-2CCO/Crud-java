package servicos.gratitude.crud_gratitude_servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class CrudController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(
            @RequestBody Usuario usuarioNovo
    ) {
        List<Usuario> todosUsuarios = repository.findAll();
        for (Usuario todosUsuario : todosUsuarios) {
            if (todosUsuario.getEmail().equals(usuarioNovo.getEmail())){
                return ResponseEntity.status(409).build();
            }

            if (todosUsuario.getCpf().equals(usuarioNovo.getCpf())){
                return ResponseEntity.status(409).build();
            }
        }
        usuarioNovo.setId(null);
        Usuario usuarioCadastrado = repository.save(usuarioNovo);

        return ResponseEntity.status(201).body(usuarioCadastrado);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarUsuarios() {
        List<Usuario> todosUsuarios = repository.findAll();

        if (todosUsuarios.isEmpty()){
            return ResponseEntity.status(204).body(todosUsuarios);
        }

        return ResponseEntity.status(200).body(todosUsuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> buscarUsuariosPorId(
            @PathVariable Integer id
    ) {
        Optional<Usuario> possivelResposta = repository.findById(id);

        if (possivelResposta.isPresent()){
            return ResponseEntity.status(200).body(possivelResposta);
        }

        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(
            @PathVariable Integer id
    ) {
        Optional<Usuario> possivelUsuario = repository.findById(id);

        if (possivelUsuario.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario (
            @PathVariable Integer id,
            @RequestBody Usuario usuarioParaAtualizar
    ) {
        usuarioParaAtualizar.setId(id);
        List<Usuario> todosUsuarios = repository.findAll();

        for (Usuario usuarioAtual : todosUsuarios) {
            if(!(usuarioAtual.getId() == id)) {

                if (usuarioAtual.getEmail().equals(usuarioParaAtualizar.getEmail())) {
                    return ResponseEntity.status(409).build();
                }

                if (usuarioAtual.getCpf().equals(usuarioParaAtualizar.getCpf())) {
                    return ResponseEntity.status(409).build();
                }

            }
        }

        Usuario usuarioAtualizado = repository.save(usuarioParaAtualizar);

        return ResponseEntity.status(200).body(usuarioAtualizado);
    }
}