package pmdm.actividades.actividad2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton boton_examen = findViewById(R.id.Boton_imagen_examen);
        ImageButton boton_estudio = findViewById(R.id.Boton_imagen_estudio);

        //noinspection Convert2Lambda
        boton_estudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EstudioActivity.class);
                startActivity(intent);
            }
        });

        //noinspection Convert2Lambda
        boton_examen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ExamenActivity.class);
                startActivity(intent);
            }
        });
    }
}