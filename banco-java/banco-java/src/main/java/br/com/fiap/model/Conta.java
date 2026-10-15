package br.com.fiap.model;

import java.time.LocalDate;

public class Conta {
    private int id;
    private int idUsuario;
    private String agencia;
    private String numeroConta;
    private String tipoConta;
    private double saldo;
    private LocalDate dataAbertura;
    private String status;

    // Construtor vazio
    public Conta() {}

    // Construtor completo
    public Conta(int id, int idUsuario, String agencia, String numeroConta, String tipoConta, double saldo, LocalDate dataAbertura, String status) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.dataAbertura = dataAbertura;
        this.status = status;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getAgencia() { return agencia; }
    public void setAgencia(String agencia) { this.agencia = agencia; }

    public String getNumeroConta() { return numeroConta; }
    public void setNumeroConta(String numeroConta) { this.numeroConta = numeroConta; }

    public String getTipoConta() { return tipoConta; }
    public void setTipoConta(String tipoConta) { this.tipoConta = tipoConta; }

    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    public LocalDate getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(LocalDate dataAbertura) { this.dataAbertura = dataAbertura; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}