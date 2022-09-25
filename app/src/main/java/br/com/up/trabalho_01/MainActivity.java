package br.com.up.trabalho_01;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import  android.widget.Toast;

import com.hbb20.CountryCodePicker;

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

        botaoEnviar = findViewById(R.id.BotaoEnviar);
        botaoEnviar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        enviar();
                    }
                }
        );

    }

    private void enviar(){
        String num = editNum.getText().toString();
        String msg = editMensagem.getText().toString();

        Uri link = Uri.parse("https://wa.me/"+num+"?text="+msg);
        Intent enviar = new Intent(Intent.ACTION_VIEW, link);

        startActivity(enviar);
    }

}