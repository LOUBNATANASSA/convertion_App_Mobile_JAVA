package com.example.azzouz;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.txtnumber1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        EditText txtnumber1 = findViewById(R.id.txtnumber1);
        Button buttonconvert = findViewById(R.id.buttonconvert);
        TextView txtresultat = findViewById(R.id.txtresultat);
        Spinner spinner = findViewById(R.id.spinner);
        // Options du spinner
        String[] bases = {"Binaire", "Hexadécimal", "Octal"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,bases );
        spinner.setAdapter(adapter);

        buttonconvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtnumber = txtnumber1.getText().toString();
                if(txtnumber.isEmpty()){
                    txtresultat.setText("00.00");
                }else {
                    int decimal = Integer.parseInt(txtnumber);
                    String convertednumber ="";
                    String selectedbase = spinner.getSelectedItem().toString();


                    if(selectedbase.equals("Binaire")){
                        convertednumber = Integer.toBinaryString(decimal);
                    } else if (selectedbase.equals("Hexadécimal")) {
                        convertednumber = Integer.toHexString(decimal).toUpperCase();
                    } else if (selectedbase.equals("Octal")) {
                        convertednumber = Integer.toOctalString(decimal);
                    }else {
                        convertednumber = "Error";
                    }

                    txtresultat.setText(convertednumber);

                }
            }
        });


    }

}