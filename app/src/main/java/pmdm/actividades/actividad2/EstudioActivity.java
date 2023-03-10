package pmdm.actividades.actividad2;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public class EstudioActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Map<String, List<Pais>> datos = new TreeMap<>();
    private CapitalesRecyclerViewAdapter adapterVHA;
    private ImageView imageViewMapaRotativo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        leerDatos();
        setContentView(R.layout.layout_generico);
        imageViewMapaRotativo = findViewById(R.id.mapa_rotativo);
        //noinspection RedundantCast
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.continentes, R.layout.layout_spinner);
        spinner.setAdapter(adapter);
        adapterVHA = new CapitalesRecyclerViewAdapter();
        RecyclerView rvPaises = findViewById(R.id.lista_capitales);
        rvPaises.setAdapter(adapterVHA);
        rvPaises.setLayoutManager(new LinearLayoutManager(this));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    //segun el continente seleccionado, mostrar los paises correspondientes
                    case 0:
                        //es vacio, no hay paises
                        imageViewMapaRotativo.setImageResource(R.drawable.mapamundi);
                        break;
                    case 1:
                        //Africa
                        adapterVHA.setPaises(datos.get("??FRICA"));
                        imageViewMapaRotativo.setImageResource(R.drawable.africa);
                        break;
                    case 2:
                        //Europa
                        adapterVHA.setPaises(datos.get("EUROPA"));
                        imageViewMapaRotativo.setImageResource(R.drawable.europa);
                        break;
                    case 3:
                        //Oceania
                        adapterVHA.setPaises(datos.get("OCEAN??A"));
                        imageViewMapaRotativo.setImageResource(R.drawable.oceania);
                        break;
                    case 4:
                        //America
                        adapterVHA.setPaises(datos.get("AM??RICA"));
                        imageViewMapaRotativo.setImageResource(R.drawable.america);
                        break;
                    case 5:
                        //Asia
                        adapterVHA.setPaises(datos.get("ASIA"));
                        imageViewMapaRotativo.setImageResource(R.drawable.asia);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        //para el fondo tendria que hacer un layout generico, para luego con un content view y un select
        //cambiarle el drawable
        Button boton_Atras = findViewById(R.id.Boton_Atras);
        boton_Atras.setVisibility(View.VISIBLE);
        //noinspection Convert2Lambda
        boton_Atras.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(EstudioActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
    public void leerDatos() {
        try  {
            InputStream stream = getResources().openRawResource(R.raw.capitales);
            BufferedReader in = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
            String linea;
            while ((linea = in.readLine()) != null) {
                String [] items = linea.split(";");
                Pais pais = new Pais(items[1], items[2], items[0]);
                List<Pais> paises = datos.get(items[0]);
                if (paises == null) {
                    paises = new ArrayList<>();
                    datos.put(items[0], paises);
                }
                paises.add(pais);
            }
        } catch (IOException e) {
            datos = null;
        }
    }
    @SuppressWarnings("unused")
    public Map<String,List<Pais>> getDatos(){return datos;}
    @SuppressWarnings("unused")
    public List<Pais> guardar(String continente){
        //noinspection ConstantConditions
        return Collections.unmodifiableList(datos.get(continente));
    }
}