package servicos.gratitude.crud_gratitude_servicos.entity;

import jakarta.persistence.*;

@Entity
public class AlunoCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Getters e Setters
    public Integer getId() {
        return id; }
    public void setId(Integer id) {
        this.id = id; }
}