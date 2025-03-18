package servicos.gratitude.crud_gratitude_servicos.service;

import org.springframework.stereotype.Service;
import servicos.gratitude.crud_gratitude_servicos.entity.Chamado;
import servicos.gratitude.crud_gratitude_servicos.exception.EntidadeNaoEncontradaException;
import servicos.gratitude.crud_gratitude_servicos.repository.ChamadoRepository;

import java.util.List;

@Service
public class ChamadoService {
    private final ChamadoRepository repository;

    public ChamadoService(ChamadoRepository repository) {
        this.repository = repository;
    }

    public Chamado cadastrar(Chamado chamado) {
        return repository.save(chamado);
    }

    public List<Chamado> listar() {
        return repository.findAll();
    }

    public Chamado buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Chamado não encontrado"));
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    public Chamado atualizar(Integer id, Chamado chamado) {
        chamado.setIdChamado(id);
        return repository.save(chamado);
    }
}