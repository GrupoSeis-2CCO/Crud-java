package servicos.gratitude.crud_gratitude_servicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import servicos.gratitude.crud_gratitude_servicos.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
    boolean existsByTituloCursoIgnoreCase(String tituloCurso);
}