package com.example.ishoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import models.Producto;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent cancel = new Intent(Info.this, MainActivity2.class);
        Intent edit = new Intent(Info.this, EditProduct.class);
        Intent data = getIntent();

        Button buttonBack = findViewById(R.id.buttonCancel);
        Button buttonEdit = findViewById(R.id.buttonConfirm);
        TextView textViewID = findViewById(R.id.textViewID);
        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewInfo = findViewById(R.id.textViewInfo);
        TextView textViewState = findViewById(R.id.textViewState);



        Producto p = (Producto) data.getSerializableExtra("product");
        Log.i("Product", p.toString());

        textViewID.setText("ID: " + String.valueOf(p.getId()));
        textViewName.setText("Nombre: " + p.getName().toString());
        textViewInfo.setText("Nota: " + p.getInfo().toString());

        if(p.getState()){
            textViewState.setText("Comprar");
        } else {
            textViewState.setText("No Comprar");
        }

        buttonBack.setOnClickListener(v -> startActivity(cancel));
        buttonEdit.setOnClickListener(v -> {
            Producto product = (Producto) data.getSerializableExtra("product");
            edit.putExtra("product", product);
            Log.i("Product to edit", product.toString());
            startActivity(edit);
        });

    }
}