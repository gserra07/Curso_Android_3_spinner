package com.example.guillers.cursoandroid3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView result_tv;
    private Button button;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.Number_1);
        et2 = findViewById(R.id.Number_2);
        button = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);
        result_tv = findViewById(R.id.tv_result);

        String[] elements = {"Sumar", "Restar", "Multiplicar", "Dividir"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, elements);
        spinner.setAdapter(adaptador);

        View.OnClickListener cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operar();
            }
        };
        button.setOnClickListener(cl);
    }

    private static final String TAG = "MainActivity";
    
    private void operar() {
        String option = spinner.getSelectedItem().toString();
        Double uno= Double.parseDouble(et1.getText().toString());
        Double dos = Double.parseDouble(et2.getText().toString());
        Log.d(TAG, "operar: "+option);
        Log.d(TAG, "operar: ");
        switch (option) {
            case "Sumar":
                result_tv.setText(String.valueOf(uno+dos));
                break;
            case "Restar":
                result_tv.setText(String.valueOf(uno-dos));
                break;
            case "Multiplicar":
                result_tv.setText(String.valueOf(uno*dos));
                break;
            case "Dividir":
                result_tv.setText(String.valueOf(uno/dos));
                break;
        }
        keyboard();
    }


    private void keyboard(){
        View view = this.getCurrentFocus();
        assert view != null;
        view.clearFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        assert imm != null;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
