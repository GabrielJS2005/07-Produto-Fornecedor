package br.fiap.produto;

import br.fiap.fornecedor.Fornecedor;

public class Produto {

    private String nomeProduto;
    private double valor;
    private int qtd;
    private Fornecedor fornecedor;

    public Produto(String nomeProduto, Fornecedor fornecedor, int qtd, double valor) {
        this.nomeProduto = nomeProduto;
        this.fornecedor = fornecedor;
        this.qtd = qtd;
        this.valor = valor;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

}
