package com.example.ishoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WaitList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wait_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button cancelButton = findViewById(R.id.buttonCancel); //Creamos una variable tipo Button y llamamos al boton que creamos
        //Creamos un Listener que escucha cuando el boton es pulsado y cambia de Activity
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMainActivity = new Intent(WaitList.this, MainActivity2.class);
                startActivity(intentMainActivity);
            }
        });

        Button confirmButton = findViewById(R.id.buttonConfirm); //Creamos una variable tipo Button y llamamos al boton que creamos
        //Creamos un Listener que escucha cuando el boton es pulsado y cambia de Activity
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMainActivity = new Intent(WaitList.this, MainActivity2.class);
                startActivity(intentMainActivity);
            }
        });
    }
}