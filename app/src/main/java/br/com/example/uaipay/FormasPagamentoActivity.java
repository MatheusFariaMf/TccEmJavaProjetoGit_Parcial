package br.com.example.uaipay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

public class FormasPagamentoActivity extends AppCompatActivity {
    private RecyclerView listaProdutos;
    private String []produtos;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);
        Log.e("FormasPagamentoActivity", "AAAABLUELBUE ASKAPS QUE QUE TA ACONTECENDO  ");

        produtos = new String[]{"Coca-Cola", "Pepsi", "Água", "Café"};

        listaProdutos = (RecyclerView)findViewById(R.id.rvListaProdutos);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        listaProdutos.setLayoutManager(linearLayoutManager);

        customAdapter = new CustomAdapter(produtos);

        listaProdutos.setAdapter(customAdapter);
        int numero = customAdapter.getItemCount();

        Log.e("FormasPagamentoActivity", "AAAABLUELBUE ASKAPS   contador:"+ numero);
    }
}