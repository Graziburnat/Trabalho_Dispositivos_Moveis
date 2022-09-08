package br.com.up.trabalho_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout layoutNum;
    private TextInputEditText editNum;
    private TextInputLayout layoutMensagem;
    private TextInputEditText editMensagem;
    private Button botaoEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutNum = findViewById(R.id.LayoutNum);
        editNum  = findViewById(R.id.EditNum);
        layoutMensagem = findViewById(R.id.LayoutMensagem);
        editMensagem = findViewById(R.id.EditMensagem);

        String num = editNum.getText().toString();
        String mensagem = editMensagem.getText().toString();
        mensagem.replace(' ', '%');

        botaoEnviar = findViewById(R.id.BotaoEnviar);
        botaoEnviar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent enviarIntent = new Intent(Intent.ACTION_SEND);
                        enviarIntent.putExtra(Intent.EXTRA_PHONE_NUMBER, new String [] {num});
                        enviarIntent.putExtra(Intent.EXTRA_TEXT, new String [] {mensagem});
                        enviarIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("https://wa.me/155" + num + "?text=" + mensagem));

                        startActivity(enviarIntent);
                    }
                }
        );

    }
}