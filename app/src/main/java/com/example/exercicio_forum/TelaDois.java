//Nome do pacote.
package com.example.exercicio_forum;
// importação das bibliotecas e elementos a serem usados nesta activity
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//Criação da classe TelaDois, que extende da classe AppCompatActivity.
public class TelaDois extends AppCompatActivity {

    //Declaração dos elementos (objetos) que serão utilizados nesta Activity.
    private TextView txt_boasVindas;
    private Button btn_sair;

    //Quando se inicia a activity.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Definindo qual tela será apresentada.
        setContentView(R.layout.activity_tela_dois);
        //Referenciando o objeto criado no arquivo .xml
        txt_boasVindas = findViewById(R.id.txt_boasVindas);

        //Declarando uma variável para obter dados guardados de uma outra activity
        Intent segundatela = getIntent();

        //Captando os dados guardados de outra activity;
        Bundle parametros = segundatela.getExtras();

        //Condição de verificação, se os dados guardados forem diferentes de vazio...
        if (parametros != null){
            //Variavel para armazenamento dos dados resgatados.
            String nome = parametros.getString("chave_nome");
            //Texto a ser apresentado ao usuário, concatenado com o texto digitado na tela anterior.
            txt_boasVindas.setText("Seja bem vindo (a): "+ nome.toUpperCase());

        }
        //Declaração do objeto botão criado no arquivo .xml
        btn_sair = findViewById(R.id.btn_sair);
        //Leitura da interação do usuário com o botão sair.
        btn_sair.setOnClickListener(new View.OnClickListener() {
            @Override
            //logica para finalizar a aplicação.
            public void onClick(View v) {
                //finalização da aplicação.
                finish();
            }
        });

    }
}