package br.com.example.uaipay;

import java.util.List;

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

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String complemento) {
        Complemento = complemento;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public List<Categoria> getMenu() {
        return Menu;
    }

    public void setMenu(List<Categoria> menu) {
        Menu = menu;
    }

    private int CodigoEstabelecimento;
    private int TipoEstabelecimento;
    private String DescricaoTipo;
    private String NomeEstabelecimento;
    private String Rua;
    private int Numero;
    private String Complemento;
    private String Bairro;
    private String Cidade;
    private String Estado;
    private String CEP;
    private List<Categoria> Menu;

}
