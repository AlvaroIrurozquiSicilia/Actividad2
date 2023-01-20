package pmdm.actividades.actividad2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class CapitalViewHolder extends RecyclerView.ViewHolder {

    private TextView textViewPais;
    private TextView textViewCapital;


    public CapitalViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewCapital = itemView.findViewById(R.id.textViewCapital);
        textViewPais = itemView.findViewById(R.id.textViewPais);
    }

    public void bind(Pais pais) {
        textViewPais.setText(pais.getNombre());
        textViewCapital.setText(pais.getCapital());
    }
}
