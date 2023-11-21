package com.example.maestromultiplicacion_eduardoescribano.ui.estadisticas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.maestromultiplicacion_eduardoescribano.R;

import java.util.List;

public class AdpatorAvatares extends ArrayAdapter<Integer> {
    private Context context;
    private List<Integer> avatarList;
    public AdpatorAvatares(@NonNull Context context, List<Integer>avatares) {
        super(context, R.layout.iteam_avatares, avatares);
        this.context = context;
        this.avatarList = avatares;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.iteam_avatares, parent, false);
        }

        ImageView avatarImageView = view.findViewById(R.id.avatarImageView);
        avatarImageView.setImageResource(avatarList.get(position));
        return view;
    }
}
