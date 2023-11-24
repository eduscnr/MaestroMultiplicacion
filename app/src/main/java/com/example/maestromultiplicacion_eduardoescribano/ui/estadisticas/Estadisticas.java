package com.example.maestromultiplicacion_eduardoescribano.ui.estadisticas;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

public class Estadisticas {
    private int tablaSeleccionada;
    private String porcetajeDeExito;
    private List<String> tablaFallada;
    private GregorianCalendar horario;

    public Estadisticas() {
    }

    public Estadisticas(int tablaSeleccionada, String porcetajeDeExito, List<String> tablaFallada, GregorianCalendar horario) {
        this.tablaSeleccionada = tablaSeleccionada;
        this.porcetajeDeExito = porcetajeDeExito;
        this.tablaFallada = tablaFallada;
        this.horario = horario;
    }

    public int getTablaSeleccionada() {
        return tablaSeleccionada;
    }

    public void setTablaSeleccionada(int tablaSeleccionada) {
        this.tablaSeleccionada = tablaSeleccionada;
    }

    public String getPorcetajeDeExito() {
        return porcetajeDeExito;
    }

    public void setPorcetajeDeExito(String porcetajeDeExito) {
        this.porcetajeDeExito = porcetajeDeExito;
    }

    public List<String> getTablaFallada() {
        return tablaFallada;
    }

    public void setTablaFallada(List<String> tablaFallada) {
        this.tablaFallada = tablaFallada;
    }

    @Override
    public String toString() {
        return "Estadisticas{" +
                "tablaSeleccionada=" + tablaSeleccionada +
                ", porcetajeDeExito=" + porcetajeDeExito +
                ", tablaFallada='" + tablaFallada + '\'' +
                '}';
    }
    public String convertirFecha() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(horario.getTime());
    }
}
