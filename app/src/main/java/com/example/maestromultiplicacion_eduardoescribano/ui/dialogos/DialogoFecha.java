package com.example.maestromultiplicacion_eduardoescribano.ui.dialogos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DialogoFecha extends DialogFragment implements DatePickerDialog.OnDateSetListener{
    onFechaSeleccionada f;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c=Calendar.getInstance();
        int año=c.get(Calendar.YEAR);
        int mes=c.get(Calendar.MONTH);
        int dia=c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),this,año,mes,dia);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        GregorianCalendar g=new GregorianCalendar(i,i1,i2);
        f.onResultadoFecha(g);
    }

    public interface onFechaSeleccionada{
        public void onResultadoFecha(GregorianCalendar calendar);
    }

    @Override
    public void onAttach(Context context) {
        f = (onFechaSeleccionada)context;
        super.onAttach(context);
    }
}
