package com.example.maestromultiplicacion_eduardoescribano;

import android.os.Bundle;
import android.widget.EditText;

import com.example.maestromultiplicacion_eduardoescribano.ui.dialogos.DialogoFecha;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.maestromultiplicacion_eduardoescribano.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DialogoFecha.onFechaSeleccionada {

    private ActivityMainBinding binding;
    private static int avatar;
    private static String dificultad = "Fácil";
    private static int tablaMultiplicar = 2;
    private static int colorAplicacion;
    private static List<String> multiplicaciones;
    private static int indiceMultiplicacion;
    private static int tablaTemporalSeleccionada;
    private static List<Integer>avatares;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        multiplicaciones = new ArrayList<>();
        avatares = new ArrayList<>();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    @Override
    public void onResultadoFecha(GregorianCalendar calendar) {
        EditText etFecha = findViewById(R.id.editTextText);
        etFecha.setText(calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) + 1)
                + "/" + calendar.get(Calendar.YEAR));
    }

    public static int getAvatar() {
        return avatar;
    }

    public static void setAvatar(int avatar) {
        MainActivity.avatar = avatar;
    }

    public static String getDificultad() {
        return dificultad;
    }

    public static void setDificultad(String dificultad) {
        MainActivity.dificultad = dificultad;
    }

    public static int getTablaMultiplicar() {
        return tablaMultiplicar;
    }

    public static void setTablaMultiplicar(int tablaMultiplicar) {
        MainActivity.tablaMultiplicar = tablaMultiplicar;
    }

    public static int getColorAplicacion() {
        return colorAplicacion;
    }

    public static void setColorAplicacion(int colorAplicacion) {
        MainActivity.colorAplicacion = colorAplicacion;
    }

    public static List<String> getMultiplicaciones() {
        return multiplicaciones;
    }

    public static void setMultiplicaciones(List<String> multiplicaciones) {
        MainActivity.multiplicaciones = multiplicaciones;
    }

    public static int getIndiceMultiplicacion() {
        return indiceMultiplicacion;
    }

    public static void setIndiceMultiplicacion(int indiceMultiplicacion) {
        MainActivity.indiceMultiplicacion = indiceMultiplicacion;
    }

    public static int getTablaTemporalSeleccionada() {
        return tablaTemporalSeleccionada;
    }

    public static void setTablaTemporalSeleccionada(int tablaTemporalSeleccionada) {
        MainActivity.tablaTemporalSeleccionada = tablaTemporalSeleccionada;
    }

    public static List<Integer> getAvatares() {
        return avatares;
    }

    public static void setAvatares(List<Integer> avatares) {
        MainActivity.avatares = avatares;
    }
}