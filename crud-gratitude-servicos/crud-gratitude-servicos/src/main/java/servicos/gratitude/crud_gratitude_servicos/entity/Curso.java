package servicos.gratitude.crud_gratitude_servicos.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;
    private String tituloCurso;
    private String descricao;
    private int oculto;

    // Getters e Setters
    public Integer getIdCurso() {
        return idCurso;
    }
    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }
    public String getTituloCurso() {
        return tituloCurso;
    }
    public void setTituloCurso(String tituloCurso) {
        this.tituloCurso = tituloCurso;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getOculto() {
        return oculto;
    }
    public void setOculto(int oculto) {
        this.oculto = oculto;
    }
}