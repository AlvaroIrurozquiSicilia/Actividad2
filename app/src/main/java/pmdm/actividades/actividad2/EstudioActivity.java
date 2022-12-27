package pmdm.actividades.actividad2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

public class EstudioActivity extends AppCompatActivity {
    //para el fondo tendria que hacer un layout generico, para luego con un content view y un select
    //cambiarle el drawable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context contexto = (Actividad2Application) getApplicationContext();

    }
}
