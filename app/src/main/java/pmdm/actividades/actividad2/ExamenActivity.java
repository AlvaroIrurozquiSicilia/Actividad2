package pmdm.actividades.actividad2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ExamenActivity extends AppCompatActivity {
    private Button Boton_Atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_examen);
        Boton_Atras = findViewById(R.id.Boton_Atras);
        //Boton_Atras.setVisibility(View.VISIBLE);
        //noinspection Convert2Lambda
        Boton_Atras.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ExamenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

