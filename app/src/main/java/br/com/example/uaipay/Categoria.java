package br.com.example.uaipay;

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

    private int CodigoCategoria;
    private String NomeCategoria;


}
