package br.com.example.uaipay;

import java.util.List;

public class Categoria {
    public int getCodigoCategoria() {
        return CodigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        CodigoCategoria = codigoCategoria;
    }

    public String getNomeCategoria() {
        return NomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        NomeCategoria = nomeCategoria;
    }

    public List<Produto> getItens() {
        return Itens;
    }

    public void setItens(List<Produto> itens) {
        Itens = itens;
    }

    private int CodigoCategoria;
    private String NomeCategoria;
    private List<Produto> Itens;

}
