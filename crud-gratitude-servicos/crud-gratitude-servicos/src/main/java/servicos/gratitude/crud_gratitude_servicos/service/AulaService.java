package servicos.gratitude.crud_gratitude_servicos.service;

import org.springframework.stereotype.Service;
import servicos.gratitude.crud_gratitude_servicos.entity.Aula;
import servicos.gratitude.crud_gratitude_servicos.exception.EntidadeConflitoException;
import servicos.gratitude.crud_gratitude_servicos.exception.EntidadeNaoEncontradaException;
import servicos.gratitude.crud_gratitude_servicos.repository.AulaRepository;

import java.util.List;

@Service
public class AulaService {
    private final AulaRepository repository;

    public AulaService(AulaRepository repository) {
        this.repository = repository;
    }

    public Aula cadastrar(Aula aula) {
        if (repository.existsByTituloAulaIgnoreCase(aula.getTituloAula())) {
            throw new EntidadeConflitoException("Titulo de Aula já existente");
        }
        if (repository.existsByUrlVideoIgnoreCase(aula.getUrlVideo())) {
            throw new EntidadeConflitoException("URL já existente");
        }
        return repository.save(aula);
    }

    public List<Aula> listar() {
        return repository.findAll();
    }

    public Aula buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Aula não encontrada"));
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    public Aula atualizar(Integer id, Aula aula) {
        aula.setIdAula(id);
        return repository.save(aula);
    }
}