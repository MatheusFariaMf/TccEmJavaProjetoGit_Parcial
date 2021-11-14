package br.com.example.uaipay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardapioActivity extends AppCompatActivity {
    List<Produto> listaProdutos;
    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> mobileCollection;
    Map<Produto, List<String>> colecaoProdutos;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        List<Categoria>  listaCategoria = new ArrayList<>();
        Categoria categoria1 = new Categoria();
        categoria1.setCodigoCategoria(1);
        categoria1.setNomeCategoria("Primeira categoria");
        listaCategoria.add(categoria1);

        List<String> listinha = new ArrayList<>();
        listinha.add("carro");

        //testando criacao e conversao do JSON
        Gson gson = new Gson();
        Estabelecimento estabelecimento = new Estabelecimento();

        //Criando o vetor "Menu" no JSON
        JSONArray Menu = new JSONArray();
        JSONArray Itens = new JSONArray();

        JSONObject Produto = new JSONObject();
        try {
            Produto.put("CodigoProduto", 10);
            Produto.put("NomeItem","Coca Cola Lata 375 ml");
            Produto.put("Preco", 3.80);
            Produto.put("LinkImagem", "/imagens/bebidas/porcaofritas.png");
            Produto.put("Observacao", "Qualquer observação do produto.");
            Produto.put("Quantidade",375);
            Produto.put("Unidade", "kg");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Itens.put(Produto);

        JSONObject Categoria = new JSONObject();
        JSONObject Categoria2 = new JSONObject();
        try {
            Categoria.put("CodigoCategoria", 123);
            Categoria.put("NomeCategoria","Categoria Edson");
            Categoria.put("Itens", Itens);
            Categoria2.put("CodigoCategoria", 111);
            Categoria2.put("NomeCategoria","Categoria Matheus");
            Categoria2.put("Itens", Itens);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Menu.put(Categoria);
        Menu.put(Categoria2);

        JSONObject estabelecimentoJSON = new JSONObject();
        try {
            estabelecimentoJSON.put("CodigoEstabelecimento", 3);
            estabelecimentoJSON.put("TipoEstabelecimento", 203);
            estabelecimentoJSON.put("DescricaoTipo", "Este é um estabelecimento de teste.");
            estabelecimentoJSON.put("NomeEstabelecimento", "Restaurante Testezin");
            estabelecimentoJSON.put("Rua", "Marechal Floriteste");
            estabelecimentoJSON.put("Numero", 600);
            estabelecimentoJSON.put("Complemento", "Apto 300");
            estabelecimentoJSON.put("Bairro", "Fonte Grande");
            estabelecimentoJSON.put("Cidade", "Ouro Branco");
            estabelecimentoJSON.put("Estado", "Minas Gerais");
            estabelecimentoJSON.put("CEP", "36406116");
            estabelecimentoJSON.put("Menu", Menu);
            //estabelecimentoJSON.put("Menu", listaCategoria);
            //estabelecimentoJSON.putOpt("Menu",listaCategoria);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        estabelecimentoJSON.toString();
        //Toast.makeText(CardapioActivity.this, "JSON Estabelecimento: "+estabelecimentoJSON, Toast.LENGTH_LONG).show();
        Log.e("CardapioActivity", "JSON Estabelecimento: "+estabelecimentoJSON);

        estabelecimento = gson.fromJson(estabelecimentoJSON.toString(), Estabelecimento.class);
        Log.e("CardapioActivity", "Já no objeto Estabelecimento: "+estabelecimento.getNomeEstabelecimento());
        Log.e("CardapioActivity", "Já no objeto Estabelecimento: "+estabelecimento.getCidade());
        Categoria objetoTeste = estabelecimento.getMenu().get(0);
        Log.e("CardapioActivity", "Já no objeto Estabelecimento: "+objetoTeste.getNomeCategoria());
        Produto produtoTeste = estabelecimento.getMenu().get(0).getItens().get(0);
        Log.e("CardapioActivity", "Já no objeto Estabelecimento: "+produtoTeste.getNomeItem());


        //já feito a partir daqui
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formas_pagamento);
        createGroupList();
        createCollection();
        expandableListView = findViewById(R.id.elvProdutos);
        expandableListAdapter = new MyExpandableListAdapter(this, listaProdutos, colecaoProdutos);
        //expandableListAdapter = new MyExpandableListAdapter(this, groupList, mobileCollection);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setGroupIndicator(null);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int lastExpandedPosition = -1;
            @Override
            public void onGroupExpand(int groupPosition) {
                if(lastExpandedPosition != -1 && groupPosition != lastExpandedPosition){
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String selected = expandableListAdapter.getChild(groupPosition, childPosition).toString();
                Toast.makeText(getApplicationContext(), "Selected: "+selected, Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    private void createCollection() {
        String[] cartaoFormas = {"Credito", "Debito", "Ler boleto"};
        String[] carnes = {"Peru", "Frango", "Carne de boi"};
        String[] cores = {"azul", "Branco"};
        String[] marcas = {"samsumg", "Mi", "LG", "muita coisa", "Lenovo"};
        colecaoProdutos = new HashMap<Produto, List<String>>();
        mobileCollection = new HashMap<String, List<String>>();
        for(Produto produto : listaProdutos){
            carregaPropriedadesProduto(produto);

            colecaoProdutos.put(produto, childList);
        }


       /* for(String group : groupList){
            if(group.equals("Cartao"))
                loadChild(cartaoFormas);
            else if(group.equals("PicPay"))
                loadChild(carnes);
            else if(group.equals("Boleto"))
                loadChild(cores);
            else
                loadChild(marcas);
            mobileCollection.put(group, childList);
        }*/
    }

    private void carregaPropriedadesProduto(Produto produto) {
        childList = new ArrayList<>();
        childList.add("Preco: "+produto.getPreco());
        childList.add("Quantidade: "+produto.getQuantidade());
    }

    private void loadChild(String[] mobileModels) {
        childList = new ArrayList<>();
        for(String model : mobileModels){
            childList.add(model);
        }
    }

    private void createGroupList(){
        groupList = new ArrayList<>();
        groupList.add("Cartao");
        groupList.add("PicPay");
        groupList.add("Boleto");
        groupList.add("Dinheiro");

        listaProdutos = new ArrayList<>();
        listaProdutos.add(new Produto("Sorvete", 10.0, 4));
        listaProdutos.add(new Produto("Hamburguer", 17.0, 15));
        listaProdutos.add(new Produto("Pizza", 25.0, 10));
    }
}