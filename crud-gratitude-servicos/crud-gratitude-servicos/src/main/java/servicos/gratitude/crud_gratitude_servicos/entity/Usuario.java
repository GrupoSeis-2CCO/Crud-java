package servicos.gratitude.crud_gratitude_servicos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Nome Inválido")
    @Length(min = 3,max = 255 ,message = "Nome Inválido")
    private String nome;

    @NotBlank(message = "Cpf Inválido")
    @CPF(message = "Cpf Inválido")
    private String cpf;

    @NotBlank(message = "Email Inválido")
    @Email(message = "Email Inválido")
    private String email;

    @NotBlank
    private String senha;

    @NotBlank
    @Length(min = 3,max = 255)
    private String cargo;

    @NotBlank(message = "Data Inválida")
    @Past(message = "Data Inválida")
    private LocalDate dataNasc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }
}
