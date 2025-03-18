package servicos.gratitude.crud_gratitude_servicos.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Time;

@Entity
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAula;
    private String tituloAula;
    private String descricaoAula;
    private String urlVideo;
    private Double nota;
    private Time duracao;

    // Getters e Setters
    public Integer getIdAula() {
        return idAula;
    }
    public void setIdAula(Integer idAula) {
        this.idAula = idAula;
    }
    public String getTituloAula() {
        return tituloAula;
    }
    public void setTituloAula(String tituloAula) {
        this.tituloAula = tituloAula;
    }
    public String getDescricaoAula() {
        return descricaoAula;
    }
    public void setDescricaoAula(String descricaoAula) {
        this.descricaoAula = descricaoAula;
    }
    public String getUrlVideo() {
        return urlVideo;
    }
    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }
    public Double getNota() {
        return nota;
    }
    public void setNota(Double nota) {
        this.nota = nota;
    }
    public Time getDuracao() {
        return duracao;
    }
    public void setDuracao(Time duracao) {
        this.duracao = duracao;
    }
}