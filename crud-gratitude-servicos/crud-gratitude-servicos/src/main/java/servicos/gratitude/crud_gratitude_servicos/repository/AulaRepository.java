package servicos.gratitude.crud_gratitude_servicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import servicos.gratitude.crud_gratitude_servicos.entity.Aula;

public interface AulaRepository extends JpaRepository<Aula, Integer> {
    boolean existsByTituloAulaIgnoreCase(String tituloAula);

    boolean existsByUrlVideoIgnoreCase(String urlVideo);
}