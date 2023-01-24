package pmdm.actividades.actividad2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class ExamenActivity extends AppCompatActivity {
    private Button Boton_Atras;
    private Random rand = new Random();
    private ImageButton imageButtonFlecha;
    /*
    * Usar un Random para mostrar 4 paises elegidos a alazar
    * De esas 4 opciones 3 estan mal y una correcta
    * Cuando la sea la opcion correcta elegida se mostrara en verde
    * Cuando la sea la opcion incorrecta elegida se mostrara en rojo
    * El pais elegido tiene que tener el fondo de su continente
     */

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

