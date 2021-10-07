package br.com.i7solution.vtex.tools;

public class DadosException extends Exception {
    public DadosException(String mensagem) {
        this.mensagem = mensagem;
    }
    private String mensagem;

    public String getMensagem() {
        return this.mensagem;
    }
}
