package br.com.example.uaipay;

public class Estabelecimento {
    public int getCodigoEstabelecimento() {
        return CodigoEstabelecimento;
    }

    public void setCodigoEstabelecimento(int codigoEstabelecimento) {
        CodigoEstabelecimento = codigoEstabelecimento;
    }

    public int getTipoEstabelecimento() {
        return TipoEstabelecimento;
    }

    public void setTipoEstabelecimento(int tipoEstabelecimento) {
        TipoEstabelecimento = tipoEstabelecimento;
    }

    public String getDescricaoTipo() {
        return DescricaoTipo;
    }

    public void setDescricaoTipo(String descricaoTipo) {
        DescricaoTipo = descricaoTipo;
    }

    public String getNomeEstabelecimento() {
        return NomeEstabelecimento;
    }

    public void setNomeEstabelecimento(String nomeEstabelecimento) {
        NomeEstabelecimento = nomeEstabelecimento;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String rua) {
        Rua = rua;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    private int CodigoEstabelecimento;
    private int TipoEstabelecimento;
    private String DescricaoTipo;
    private String NomeEstabelecimento;
    private String Rua;
    private int Numero;

}
