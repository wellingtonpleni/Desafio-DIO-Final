package com.dio.model;

/**
 *
 * @author wellington
 */
public class Proprietario extends Pessoa{
    private String telefone;
    private double valorAluguelImovel;

    public Proprietario(int identificacao, String nome, String telefone) {
        super(identificacao, nome);
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public double getValorAluguelImovel() {
        return valorAluguelImovel;
    }

    public void setValorAluguelImovel(double valorAluguelImovel) {
        this.valorAluguelImovel = valorAluguelImovel;
    }
}
