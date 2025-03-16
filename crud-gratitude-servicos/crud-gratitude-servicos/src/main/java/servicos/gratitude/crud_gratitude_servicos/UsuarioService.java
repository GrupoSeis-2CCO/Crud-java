package servicos.gratitude.crud_gratitude_servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario cadastrar(Usuario usuarioNovo) {
        List<Usuario> todosUsuarios = repository.findAll();

        for (Usuario usuario : todosUsuarios) {
            if (usuario.getEmail().equals(usuarioNovo.getEmail())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um usuário com este email");
            }

            if (usuario.getCpf().equals(usuarioNovo.getCpf())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um usuário com este CPF");
            }
        }

        usuarioNovo.setId(null);
        return repository.save(usuarioNovo);
    }

    public List<Usuario> buscarTodos() {
        return repository.findAll();
    }

    public Optional<Usuario> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public void deletar(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }
        repository.deleteById(id);
    }

    public Usuario atualizar(Integer id, Usuario usuarioParaAtualizar) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }

        usuarioParaAtualizar.setId(id);
        List<Usuario> todosUsuarios = repository.findAll();

        for (Usuario usuarioAtual : todosUsuarios) {
            if (!(usuarioAtual.getId() == id)) {
                if (usuarioAtual.getEmail().equals(usuarioParaAtualizar.getEmail())) {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe outro usuário com este email");
                }

                if (usuarioAtual.getCpf().equals(usuarioParaAtualizar.getCpf())) {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe outro usuário com este CPF");
                }
            }
        }

        return repository.save(usuarioParaAtualizar);
    }
}