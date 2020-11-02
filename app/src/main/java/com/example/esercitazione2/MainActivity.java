package com.example.esercitazione2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView age;
    EditText nome,cognome,data,indirizzo;
    Button enter;
    Persona persona;
    SeekBar sickbar;
    public static final String PERSONA_PATH = "com.example.esercitazione2.Persona";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.attrNome);
        cognome = findViewById(R.id.attrCogn);
        data = findViewById(R.id.Data);
        enter = findViewById(R.id.Enter);
        indirizzo = findViewById(R.id.Indirizzo);
        sickbar = findViewById(R.id.sickbar);
        age = findViewById(R.id.Age);

        persona = new Persona();

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showResult = new Intent(MainActivity.this, ResultActivity.class);
                updatePerson();
                showResult.putExtra(PERSONA_PATH, persona);
                startActivity(showResult);
            }
        });

        sickbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar.setProgress(progress);
                age.setText(""+sickbar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(sickbar.getProgress() == 0){
                    age.setText("");
                }
            }
        });

    }

    public void updatePerson(){
        this.persona.setNome(this.nome.getText().toString());
        this.persona.setCognome(this.cognome.getText().toString());
        this.persona.setDataDiNascita(this.data.getText().toString());
        this.persona.setIndirizzo(this.indirizzo.getText().toString());
    }
}