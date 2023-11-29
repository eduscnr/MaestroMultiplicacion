package com.example.maestromultiplicacion_eduardoescribano.ui.estadisticas;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

public class Estadisticas {
    private int tablaSeleccionada;
    private String porcetajeDeExito;
    private List<String> multiplicacionesFallidas;
    private GregorianCalendar horario;

    public Estadisticas() {
    }

    public Estadisticas(int tablaSeleccionada, String porcetajeDeExito, List<String> tablaFallada, GregorianCalendar horario) {
        this.tablaSeleccionada = tablaSeleccionada;
        this.porcetajeDeExito = porcetajeDeExito;
        this.multiplicacionesFallidas = tablaFallada;
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

    public List<String> getMultiplicacionesFallidas() {
        return multiplicacionesFallidas;
    }

    public void setMultiplicacionesFallidas(List<String> multiplicacionesFallidas) {
        this.multiplicacionesFallidas = multiplicacionesFallidas;
    }

    @Override
    public String toString() {
        return "Estadisticas{" +
                "tablaSeleccionada=" + tablaSeleccionada +
                ", porcetajeDeExito=" + porcetajeDeExito +
                ", tablaFallada='" + multiplicacionesFallidas + '\'' +
                '}';
    }
    public String convertirFecha() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(horario.getTime());
    }
}
