package servicos.gratitude.crud_gratitude_servicos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idChamado;
    private String corpoChamado;
    private Boolean respondido;

    // Getters e Setters
    public Integer getIdChamado() {
        return idChamado;
    }
    public void setIdChamado(Integer idChamado) {
        this.idChamado = idChamado;
    }
    public String getCorpoChamado() {
        return corpoChamado;
    }
    public void setCorpoChamado(String corpoChamado) {
        this.corpoChamado = corpoChamado;
     }
    public Boolean getRespondido() {
        return respondido;
    }
    public void setRespondido(Boolean respondido) {
        this.respondido = respondido;
    }
}