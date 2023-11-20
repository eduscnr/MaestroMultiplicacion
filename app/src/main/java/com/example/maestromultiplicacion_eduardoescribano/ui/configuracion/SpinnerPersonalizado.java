package com.example.maestromultiplicacion_eduardoescribano.ui.configuracion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maestromultiplicacion_eduardoescribano.R;

public class SpinnerPersonalizado extends ArrayAdapter<String> {
    Context mContext;
    int imagenes[] = { R.drawable.superman10, R.drawable.batman10,
            R.drawable.ironman10, R.drawable.spiderman10,
            R.drawable.thor10};
    String[] nombreHeroes = { "Superman", "Batman", "Ironman", "Spiderman", "Thor" };
    public SpinnerPersonalizado(Context ctx, int txtViewResourceId, String[] nombreHeroes) {
        super(ctx, txtViewResourceId , nombreHeroes);
        mContext = ctx;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return crearFilaPersonalizada(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position,  View convertView,  ViewGroup parent) {
        return crearFilaPersonalizada(position, convertView, parent);
    }
    public View crearFilaPersonalizada(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View miFila = inflater.inflate(R.layout.seleccion_heroes, parent, false);
        ImageView imagen = (ImageView) miFila.findViewById(R.id.imageView2);
        imagen.setImageResource(imagenes[position]);
        TextView txvNombreHeroes = miFila.findViewById(R.id.nombreHeroe);
        txvNombreHeroes.setText(nombreHeroes[position]);
        return miFila;
    }
}
