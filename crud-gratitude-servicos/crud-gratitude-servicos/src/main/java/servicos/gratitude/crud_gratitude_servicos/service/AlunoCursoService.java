package servicos.gratitude.crud_gratitude_servicos.service;

import org.springframework.stereotype.Service;
import servicos.gratitude.crud_gratitude_servicos.entity.AlunoCurso;
import servicos.gratitude.crud_gratitude_servicos.exception.EntidadeNaoEncontradaException;
import servicos.gratitude.crud_gratitude_servicos.repository.AlunoCursoRepository;

import java.util.List;

@Service
public class AlunoCursoService {
    private final AlunoCursoRepository repository;

    public AlunoCursoService(AlunoCursoRepository repository) {
        this.repository = repository;
    }

    public AlunoCurso cadastrar(AlunoCurso alunoCurso) {
        return repository.save(alunoCurso);
    }

    public List<AlunoCurso> listar() {
        return repository.findAll();
    }

    public AlunoCurso buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("AlunoCurso não encontrado"));
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    public AlunoCurso atualizar(Integer id, AlunoCurso alunoCurso) {
        alunoCurso.setId(id);
        return repository.save(alunoCurso);
    }
}