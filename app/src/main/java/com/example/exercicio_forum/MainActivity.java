//Nome do pacote
package com.example.exercicio_forum;
//importaçao de bibliotecas e elementos
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//declaração da classe principal (da activity que aparece ao usuário)
public class MainActivity extends AppCompatActivity {

    //declaração dos elementos (instanciando objetos da interface)
    private EditText edt_usuario;
    private Button btn_acessar;

    //quando inicia o aplicativo ele usa esses parametros para construir a interface.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_acessar = findViewById(R.id.btn_acessar); //Referencia do botão criado no arquivo .xml
        edt_usuario = findViewById(R.id.edt_usuario); //Referencia do editText criado no arquivo .xml

        //Leitura da interação do usuário com o botão.
        btn_acessar.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Criação da variavel digitada no campo EditText
                String usuario = edt_usuario.getText().toString();
                //Condição para verificar se o usuário digiou seu nome no campo indicado.
                if (usuario.length()<1 ){
                    //mensagem caso o usuário não tenha digitado nada.
                    Toast.makeText(MainActivity.this,"Por favor digite um nome para acessar", Toast.LENGTH_LONG).show();
                    }else{
                    //Criação da variavel de inteção de usar outra tela, e declaração da proxima tela a ser exibida.
                    Intent segundatela = new Intent(getApplicationContext(),TelaDois.class);
                    //Criação da variável para armazenamento do nome do usuário para reutilização em outra activity
                    Bundle parametros =  new Bundle();
                    //Armazenando uma key (chave) e uma String (palavra).
                    parametros.putString("chave_nome",usuario);
                    //Enviando para a activity que será usada a String armazenada.
                    segundatela.putExtra("chave_nome",usuario);
                    //Inicializando a próxima activity.
                    startActivity(segundatela);

                }
            }
        });
    }

    @Override
    //Criação da classe para quando a segunda activity e aberta essa é finalizada.
    protected void onStop() {
        super.onStop();
        //finalização desta activity.
        finish();
    }
}
