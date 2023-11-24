package com.example.maestromultiplicacion_eduardoescribano.ui.estadisticas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.maestromultiplicacion_eduardoescribano.MainActivity;
import com.example.maestromultiplicacion_eduardoescribano.R;
import com.example.maestromultiplicacion_eduardoescribano.databinding.FragmentEstadisticasBinding;

public class EstadisticasFragment extends Fragment{
    private FragmentEstadisticasBinding binding;
    private Button btnEstadisticas;
    private EditText edEmail;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEstadisticasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        btnEstadisticas = root.findViewById(R.id.btnEnviar);
        edEmail = root.findViewById(R.id.etEmail);
        ListView listViewAvatares = root.findViewById(R.id.listViewAvatares);
        AdpatorAvatares aa = new AdpatorAvatares(requireContext(), MainActivity.getAvataresColeccionables());
        listViewAvatares.setAdapter(aa);
        btnEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent();
                Intent chooser=null;
                if(!edEmail.getText().toString().equalsIgnoreCase("")){
                    i.setAction(Intent.ACTION_SEND);
                    i.setData(Uri.parse("mailto:"));
                    i.putExtra(Intent.EXTRA_SUBJECT, "Estadísticas de Multiplicación");
                    String para[]={edEmail.getText().toString()};
                    i.putExtra(Intent.EXTRA_EMAIL, para);
                    StringBuilder mensaje = new StringBuilder("Estadísticas de Multiplicación:\n\n");
                    for (Estadisticas estadisticas : MainActivity.getEstadisticas()) {
                        mensaje.append("Tabla: ").append(estadisticas.getTablaSeleccionada()).append("\n");
                        mensaje.append("Porcentaje de Éxito: ").append(estadisticas.getPorcetajeDeExito()).append("\n");
                        mensaje.append("Fecha: ").append(estadisticas.convertirFecha()).append("\n");
                        mensaje.append("Tablas Falladas: ").append(estadisticas.getTablaFallada()).append("\n\n");
                    }
                    i.putExtra(Intent.EXTRA_TEXT, mensaje.toString());
                    i.setType("message/rfc822");
                    chooser=i.createChooser(i,"Enviar Email");
                    if (chooser.resolveActivity(requireContext().getPackageManager()) != null) {
                        startActivity(chooser);
                        Toast.makeText(getContext(), "Enviando estadísticas por correo electrónico", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "No hay ninguna aplicación de correo electrónico instalada", Toast.LENGTH_LONG).show();
                    }
                    //Toast.makeText(getContext(),"Envía el email!!",Toast.LENGTH_LONG).show();
                }
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onStop() {
        super.onStop();
        edEmail.setText("");
    }
}