package br.com.example.uaipay;

public class Produto {

    public Produto() {
    }

    public Produto(String nome, double preco, int quantidade) {
        this.NomeItem = nome;
        this.Preco = preco;
        this.Quantidade = quantidade;
    }

    public int getCodigoProduto() {
        return CodigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        CodigoProduto = codigoProduto;
    }

    public String getNomeItem() {
        return NomeItem;
    }

    public void setNomeItem(String nomeItem) {
        NomeItem = nomeItem;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double preco) {
        Preco = preco;
    }

    public String getLinkImagem() {
        return LinkImagem;
    }

    public void setLinkImagem(String linkImagem) {
        LinkImagem = linkImagem;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String observacao) {
        Observacao = observacao;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.Quantidade = quantidade;
    }

    public String getUnidade() {
        return Unidade;
    }

    public void setUnidade(String unidade) {
        Unidade = unidade;
    }

    private int CodigoProduto;
    private String NomeItem;
    private double Preco;
    private String LinkImagem;
    private String Observacao;
    private int Quantidade;
    private String Unidade;

}
