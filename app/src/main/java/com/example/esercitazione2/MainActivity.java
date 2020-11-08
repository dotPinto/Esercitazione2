package com.example.esercitazione2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView errorText;
    EditText nome,cognome,data, cap;
    Button enter,clear;
    Persona persona;
    public static final String PERSONA_PATH = "com.example.esercitazione2.Persona";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.attrNome);
        cognome = findViewById(R.id.attrCogn);
        data = findViewById(R.id.Data);
        enter = findViewById(R.id.Enter);
        cap = findViewById(R.id.Indirizzo);
        errorText = findViewById(R.id.errorText);
        clear = findViewById(R.id.clearText);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome.setText("");
                cognome.setText("");
                data.setText("");
                cap.setText("");
            }
        });

        data.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    showDialog();
                }
            }
        });

        persona = new Persona();

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showResult = new Intent(MainActivity.this, ResultActivity.class);
                if(checkInput()) {
                    updatePerson();
                    showResult.putExtra(PERSONA_PATH, persona);
                    startActivity(showResult);
                }
            }
        });

    }

    /*True se e' andato a buon fine, altrimenti false*/
    public boolean checkInput(){
        int errors = 0;
        if (nome.getText() == null || nome.getText().length() == 0){
            errors++;
            nome.setError("Inserire il nome");
        }
        else nome.setError(null);

        if (cognome.getText() == null || cognome.getText().length() == 0){
            errors++;
            cognome.setError("Inserire il cognome");
        }
        else cognome.setError(null);

        if (cap.getText() == null || cap.getText().length() != 5){
            errors++;
            cap.setError("Inserire il CAP di 5 Cifre");
        }
        else cap.setError(null);

        if (data.getText() == null){
            errors++;
            data.setError("Inserire la data");
        }
        else data.setError(null);

        switch (errors){
            case 0:
                errorText.setVisibility(View.GONE);
                errorText.setText("");
                break;
            case 1:
                errorText.setVisibility(View.VISIBLE);
                errorText.setText("Si e' verificato un errore");
                break;
            default:
                errorText.setVisibility(View.VISIBLE);
                errorText.setText("Si sono verificati "+errors+" errori");
                break;
        }
        return errors==0;
    }

    public void updatePerson(){
        this.persona.setNome(this.nome.getText().toString());
        this.persona.setCognome(this.cognome.getText().toString());
        this.persona.setCap(this.cap.getText().toString());
    }

    void showDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance();
        newFragment.show(getSupportFragmentManager(), "dialog");
    }

    public void doPositiveClick(Calendar date) {
        // Do stuff here.
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        data.setText(format.format(date.getTime()));
    }

    public void doNegativeClick() {
        // Do stuff here.

    }

    public void updateDataDiNascita(Calendar date){
        this.persona.setDataDiNascita(date);
    }

}