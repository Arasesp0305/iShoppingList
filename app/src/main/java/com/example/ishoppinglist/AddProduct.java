package com.example.ishoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import dataBase.Data;
import models.Producto;

public class AddProduct extends AppCompatActivity {

    private Switch state;
    private EditText editTextName = findViewById(R.id.editTextName);
    private EditText editTextInfo = findViewById(R.id.editTextInfo);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button cancelButton = findViewById(R.id.buttonCancelAdd); //Creamos una variable tipo Button y llamamos al boton que creamos
        //Creamos un Listener que escucha cuando el boton es pulsado y cambia de Activity
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMainActivity2 = new Intent(AddProduct.this, MainActivity2.class);
                startActivity(intentMainActivity2);
            }
        });

        Button confirmButton = findViewById(R.id.buttonConfirmAdd); //Creamos una variable tipo Button y llamamos al boton que creamos
        //Creamos un Listener que escucha cuando el boton es pulsado y cambia de Activity
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data.products.add(addProduct());

                Intent intentMainActivity = new Intent(AddProduct.this, MainActivity2.class);
                startActivity(intentMainActivity);
            }
        });



    }

    private Producto addProduct(){
        Producto p = new Producto();

        p.setId(Data.id());
        p.setName(editTextName.getText().toString());
        p.setInfo(editTextInfo.getText().toString());
        p.setState(state.isChecked());

        return p;
    }
}