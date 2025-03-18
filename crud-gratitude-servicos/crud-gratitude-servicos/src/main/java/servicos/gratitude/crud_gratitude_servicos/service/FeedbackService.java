package servicos.gratitude.crud_gratitude_servicos.service;

import org.springframework.stereotype.Service;
import servicos.gratitude.crud_gratitude_servicos.entity.Feedback;
import servicos.gratitude.crud_gratitude_servicos.exception.EntidadeNaoEncontradaException;
import servicos.gratitude.crud_gratitude_servicos.repository.FeedbackRepository;

import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackRepository repository;

    public FeedbackService(FeedbackRepository repository) {
        this.repository = repository;
    }

    public Feedback cadastrar(Feedback feedback) {
        return repository.save(feedback);
    }

    public List<Feedback> listar() {
        return repository.findAll();
    }

    public Feedback buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Feedback não encontrado"));
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    public Feedback atualizar(Integer id, Feedback feedback) {
        feedback.setIdFeedback(id);
        return repository.save(feedback);
    }
}