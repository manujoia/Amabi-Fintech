package br.com.fiap.exception;

public class EntidadeNaoEcontradaException extends Exception {
    public EntidadeNaoEcontradaException(String mensagem) {
        super(mensagem);
    }
}