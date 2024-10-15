package com.example.ishoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import adapters.ProductAdapter;
import dataBase.Data;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Data.fill();

        ListView listViewProduct = findViewById(R.id.listView);
        ProductAdapter productAdapter = new ProductAdapter(MainActivity2.this, 0, Data.getProducts());
        listViewProduct.setAdapter(productAdapter);

        Button waitListButton = findViewById(R.id.buttonWaitList); //Creamos una variable tipo Button y llamamos al boton que creamos
        //Creamos un Listener que escucha cuando el boton es pulsado y cambia de Activity
        waitListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMainActivity = new Intent(MainActivity2.this, WaitList.class);
                startActivity(intentMainActivity);
            }
        });

        Button addProductButton = findViewById(R.id.buttonAddProduct); //Creamos una variable tipo Button y llamamos al boton que creamos
        //Creamos un Listener que escucha cuando el boton es pulsado y cambia de Activity
        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAddProduct = new Intent(MainActivity2.this, AddProduct.class);
                startActivity(intentAddProduct);
            }
        });


    }


}