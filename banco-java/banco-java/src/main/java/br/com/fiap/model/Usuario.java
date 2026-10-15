package br.com.fiap.model;

import java.time.LocalDate;

public class Usuario {
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private LocalDate dataCadastro; // Exemplo de campo extra
    private String status;          // Exemplo de campo extra

    // Construtor vazio
    public Usuario() {}

    // Construtor com 5 parâmetros (utilizado atualmente pelo DAO)
    public Usuario(int id, String nome, String cpf, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    // Construtor completo com 7 parâmetros
    public Usuario(int id, String nome, String cpf, String email, String senha, LocalDate dataCadastro, String status) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
        this.status = status;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public LocalDate getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDate dataCadastro) { this.dataCadastro = dataCadastro; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}