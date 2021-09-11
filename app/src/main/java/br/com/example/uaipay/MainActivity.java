package br.com.example.uaipay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnEntrar, btnFazerCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setComponents();

    }

    private void setComponents()
    {
        btnEntrar = findViewById(R.id.btnEntrar);
        btnFazerCadastro = findViewById(R.id.btnFazerCadastro);

        btnEntrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, FormasPagamentoActivity.class);
                Intent intent = new Intent(MainActivity.this, CardapioActivity.class);
                startActivity(intent);
            }
        });

        btnFazerCadastro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });
    }
}