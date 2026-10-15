package br.com.fiap.model;

import java.time.LocalDate;

public class Cartao {
    private int id;
    private int idConta;
    private String finalCartao;
    private String nomeImpresso;
    private String tipoCartao;
    private double limiteTotal;
    private double limiteDisponivel;
    private LocalDate dataValidade;
    private String status;

    // Construtor vazio
    public Cartao() {}

    // Construtor completo
    public Cartao(int id, int idConta, String finalCartao, String nomeImpresso, String tipoCartao, double limiteTotal, double limiteDisponivel, LocalDate dataValidade, String status) {
        this.id = id;
        this.idConta = idConta;
        this.finalCartao = finalCartao;
        this.nomeImpresso = nomeImpresso;
        this.tipoCartao = tipoCartao;
        this.limiteTotal = limiteTotal;
        this.limiteDisponivel = limiteDisponivel;
        this.dataValidade = dataValidade;
        this.status = status;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdConta() { return idConta; }
    public void setIdConta(int idConta) { this.idConta = idConta; }

    public String getFinalCartao() { return finalCartao; }
    public void setFinalCartao(String finalCartao) { this.finalCartao = finalCartao; }

    public String getNomeImpresso() { return nomeImpresso; }
    public void setNomeImpresso(String nomeImpresso) { this.nomeImpresso = nomeImpresso; }

    public String getTipoCartao() { return tipoCartao; }
    public void setTipoCartao(String tipoCartao) { this.tipoCartao = tipoCartao; }

    public double getLimiteTotal() { return limiteTotal; }
    public void setLimiteTotal(double limiteTotal) { this.limiteTotal = limiteTotal; }

    public double getLimiteDisponivel() { return limiteDisponivel; }
    public void setLimiteDisponivel(double limiteDisponivel) { this.limiteDisponivel = limiteDisponivel; }

    public LocalDate getDataValidade() { return dataValidade; }
    public void setDataValidade(LocalDate dataValidade) { this.dataValidade = dataValidade; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}