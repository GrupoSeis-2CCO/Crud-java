package servicos.gratitude.crud_gratitude_servicos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFeedback;
    private Double nota;
    private String comentario;
    private LocalDate dataFeedback;

    // Getters e Setters
    public Integer getIdFeedback() {
        return idFeedback;
    }
    public void setIdFeedback(Integer idFeedback) {
        this.idFeedback = idFeedback;
    }
    public Double getNota() {
        return nota;
    }
    public void setNota(Double nota) {
        this.nota = nota;
    }
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public LocalDate getDataFeedback() {
        return dataFeedback;
    }
    public void setDataFeedback(LocalDate dataFeedback) {
        this.dataFeedback = dataFeedback;
    }
}