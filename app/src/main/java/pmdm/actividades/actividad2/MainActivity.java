package pmdm.actividades.actividad2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boton_examen = findViewById(R.id.boton_examen);
        Button boton_estudio = findViewById(R.id.boton_estudio);

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