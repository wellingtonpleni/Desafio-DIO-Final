package com.dio.model;

/**
 *
 * @author wellington
 */
public class Corretor extends Pessoa{
    private double taxaComissao;
    private double totalComissao;

    public Corretor(int identificacao, String nome, double taxaComissao) {
        super(identificacao, nome);
        this.taxaComissao = taxaComissao;
    }

    public double getTaxaComissao() {
        return taxaComissao;
    }

    public double getTotalComissao() {
        return totalComissao;
    }

    public void calcTotalComissao(double aluguel){
        totalComissao += aluguel * (taxaComissao/100);
    }

}
