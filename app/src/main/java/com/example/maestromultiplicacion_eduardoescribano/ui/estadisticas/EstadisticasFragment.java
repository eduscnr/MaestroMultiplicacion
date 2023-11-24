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

import com.example.maestromultiplicacion_eduardoescribano.R;
import com.example.maestromultiplicacion_eduardoescribano.databinding.FragmentEstadisticasBinding;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> avatares = new ArrayList<>();
        avatares.add(R.drawable.batman10);
        avatares.add(R.drawable.superman10);
        AdpatorAvatares aa = new AdpatorAvatares(requireContext(), avatares);
        listViewAvatares.setAdapter(aa);
        btnEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent();
                Intent chooser=null;
                if(!edEmail.getText().toString().equalsIgnoreCase("")){
                    i.setAction(Intent.ACTION_SEND);
                    i.setData(Uri.parse("mailto:"));
                    String para[]={edEmail.getText().toString(),"otrocontacto@gmail.com"};
                    i.putExtra(Intent.EXTRA_EMAIL,para);
                    i.putExtra(Intent.EXTRA_SUBJECT,"Saludos desde Android");
                    i.putExtra(Intent.EXTRA_TEXT,"Hola!!. ¿Qué tal?. Este es nuestro primer email");
                    i.setType("message/rfc822");
                    chooser=i.createChooser(i,"Enviar Email");
                    startActivity(i);
                    Toast.makeText(getContext(),"Envía el email!!",Toast.LENGTH_LONG).show();
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
    /*
    *
    *  EditText edEmail=(EditText)findViewById(R.id.edEmail);
            i.setAction(Intent.ACTION_SEND);
            i.setData(Uri.parse("mailto:"));
            String para[]={edEmail.getText().toString(),"otrocontacto@gmail.com"};
            i.putExtra(Intent.EXTRA_EMAIL,para);
            i.putExtra(Intent.EXTRA_SUBJECT,"Saludos desde Android");
            i.putExtra(Intent.EXTRA_TEXT,"Hola!!. ¿Qué tal?. Este es nuestro primer email");
            i.setType("message/rfc822");
            chooser=i.createChooser(i,"Enviar Email");
            startActivity(i);
            Toast.makeText(this.getApplicationContext(),"Envía el email!!",Toast.LENGTH_LONG).show();
    * */
}