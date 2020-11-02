package com.example.esercitazione2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class ResultActivity extends AppCompatActivity {

    Persona persona;
    TextView nomeText, cognomeText, dataText,indirizzoText;
    Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        nomeText = findViewById(R.id.TitleNome);
        cognomeText = findViewById(R.id.TitleCogn);
        dataText = findViewById(R.id.TitleData);
        indirizzoText = findViewById(R.id.TitleIndirizzo);
        ok = findViewById(R.id.Return);

        Intent intent = getIntent();
        Serializable object = intent.getSerializableExtra(MainActivity.PERSONA_PATH);

        if(object instanceof Persona){
            this.persona = (Persona) object;
        }
        else{
            this.persona = new Persona();
        }

        nomeText.setText(persona.getNome());
        cognomeText.setText(persona.getCognome());
        dataText.setText(persona.getDataDiNascita());

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(goBack);
            }
        });
    }
}