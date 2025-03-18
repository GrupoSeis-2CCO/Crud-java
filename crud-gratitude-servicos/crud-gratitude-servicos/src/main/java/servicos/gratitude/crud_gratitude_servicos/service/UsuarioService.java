    package servicos.gratitude.crud_gratitude_servicos.service;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.stereotype.Service;
    import org.springframework.web.server.ResponseStatusException;
    import servicos.gratitude.crud_gratitude_servicos.entity.Usuario;
    import servicos.gratitude.crud_gratitude_servicos.exception.EntidadeConflitoException;
    import servicos.gratitude.crud_gratitude_servicos.exception.EntidadeNaoEncontradaException;
    import servicos.gratitude.crud_gratitude_servicos.repository.UsuarioRepository;

    import java.util.List;
    import java.util.Optional;

    @Service
    public class UsuarioService {

       private final UsuarioRepository repository;

        public UsuarioService(UsuarioRepository repository) {
            this.repository = repository;
        }

        public Usuario cadastrar(Usuario usuario) {
            usuario.setId(null);

            if (repository.existsByCpfIgnoreCase(usuario.getCpf())) {
                throw new EntidadeConflitoException("Cpf já existente");
            }

            if (repository.existsByEmailIgnoreCase(usuario.getEmail())) {
                throw new EntidadeConflitoException("Email já existente");
            }
            Usuario  usuarioCadastrado = repository.save(usuario);
            return usuarioCadastrado;

        }

        public List<Usuario> listar() {
            return repository.findAll();
        }

        public Usuario buscarPorId(Integer id) {
            return repository.findById(id).orElseThrow(
                    () -> new EntidadeNaoEncontradaException("Não Encontrou"));
        }

        public void deletar(Integer id) {
            if (!repository.existsById(id)) {
                throw new EntidadeNaoEncontradaException("Usuário não encontrado");
            }
            repository.deleteById(id);
        }

        public Usuario atualizar(Integer id, Usuario usuarioParaAtualizar) {
            if (!repository.existsById(id)) {
                throw new EntidadeNaoEncontradaException("Usuário não encontrado");
            }
            if (repository.existsByEmailAndIdNot(usuarioParaAtualizar.getEmail(), id)) {
                throw new EntidadeConflitoException("Email já existente");
            }

            if (repository.existsByCpfAndIdNot(usuarioParaAtualizar.getCpf(), id)) {
                throw new EntidadeConflitoException("CPF já existente");
            }

            usuarioParaAtualizar.setId(id);
            return repository.save(usuarioParaAtualizar);

        }
    }