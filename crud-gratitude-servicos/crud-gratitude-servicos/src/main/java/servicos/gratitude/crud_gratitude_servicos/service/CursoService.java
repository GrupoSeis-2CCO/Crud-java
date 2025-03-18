package servicos.gratitude.crud_gratitude_servicos.service;
import org.springframework.stereotype.Service;
import servicos.gratitude.crud_gratitude_servicos.entity.Curso;
import servicos.gratitude.crud_gratitude_servicos.exception.EntidadeConflitoException;
import servicos.gratitude.crud_gratitude_servicos.exception.EntidadeNaoEncontradaException;
import servicos.gratitude.crud_gratitude_servicos.repository.CursoRepository;

import java.util.List;

@Service
public class CursoService {
    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public Curso cadastrar(Curso curso) {
        if (repository.existsByTituloCursoIgnoreCase(curso.getTituloCurso())) {
            throw new EntidadeConflitoException("Título já existente");
        }
        return repository.save(curso);
    }

    public List<Curso> listar() {
        return repository.findAll();
    }

    public Curso buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Curso não encontrado"));
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    public Curso atualizar(Integer id, Curso curso) {
        curso.setIdCurso(id);
        return repository.save(curso);
    }
}