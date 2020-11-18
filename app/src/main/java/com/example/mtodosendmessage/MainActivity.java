package com.example.mtodosendmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected static final int MENSAGEM_TESTE = 1;
    private Handler handler  = new TesteHandler();


    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btEnviar1).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v){
                //Cria mensagem com delay de 3 segundos
                Message msg = new Message();
                msg.what = MENSAGEM_TESTE;
                //envia mensagem
                handler.sendMessageDelayed(msg,3000);

            }
        });

        findViewById(R.id.btEnviar2).setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                //Cria a mensagem com delay de 3 segundos
                handler.postDelayed(new Runnable(){
                    @Override

                    //chama na thread principal
                    public void run() {
                        Toast.makeText(getBaseContext(), "A mensagem chegou com Runnable", Toast.LENGTH_SHORT).show();
                    }
                }, 3000);
            }
        });

    }
    //handler utilizado para receber a mensagem (classe interna)
    private class TesteHandler extends Handler {
        @Override
        public void handleMessage(Message msg){
            //o atributo msg.what permite identificar a mensagem
            switch (msg.what){
                case MENSAGEM_TESTE:
                    Toast.makeText(getBaseContext(), "A mensagem chegou pelo método sendMenssage!", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

}