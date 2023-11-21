package com.example.maestromultiplicacion_eduardoescribano.ui.estadisticas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.maestromultiplicacion_eduardoescribano.R;
import com.example.maestromultiplicacion_eduardoescribano.databinding.FragmentEstadisticasBinding;

import java.util.ArrayList;
import java.util.List;

public class EstadisticasFragment extends Fragment{
    private FragmentEstadisticasBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEstadisticasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ListView listViewAvatares = root.findViewById(R.id.listViewAvatares);
        List<Integer> avatares = new ArrayList<>();
        avatares.add(R.drawable.batman10);
        avatares.add(R.drawable.superman10);
        AdpatorAvatares aa = new AdpatorAvatares(requireContext(), avatares);
        listViewAvatares.setAdapter(aa);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}