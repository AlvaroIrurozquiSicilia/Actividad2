package pmdm.actividades.actividad2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CapitalesRecyclerViewAdapter extends RecyclerView.Adapter<CapitalViewHolder> {
    Map<String, List<Pais>> datos = new TreeMap<>();
    private List<Pais> paises = new ArrayList<>();

    public void setPaises(List<Pais> paises) {
        this.paises = paises;
        notifyDataSetChanged();
    }
    //Metodo que crea las vistas
    @NonNull
    @Override
    public CapitalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_pais, parent, false);
        return new CapitalViewHolder(vista);
    }
    //Metodo que actualiza las vistas
    @Override
    public void onBindViewHolder(@NonNull CapitalViewHolder holder, int position) {
        Pais pais = paises.get(position);
        holder.bind(pais);

    }
    //Metodo que recibe las litas del archivo
    @Override
    public int getItemCount() {
        return paises.size();
    }

}
