package com.gen_5_new;
import static com.gen_5_new.Hueta.auxiliary;
import android.view.View;
import android.widget.AdapterView;

public class Spin implements SpinnerIo {
    @Override public void onItemSelected(AdapterView<?> adapter, View view, int position, long id) {
        String s = adapter.getItemAtPosition(position).toString();
        if (s.equals("Присоединение"))   { auxiliary = "П"; }
        if (s.equals("Разложение"))      { auxiliary = "Р"; }
        if (s.equals("Замещение"))       { auxiliary = "З"; }
        if (s.equals("Обмен"))           { auxiliary = "О"; }
    }//для спинера
    @Override public void onNothingSelected(AdapterView<?> parent) {
        System.out.println("не было выбора");
    }//для спинера default

    @Override public void distributeSpinner() {//TODO СПИНЕР
        //!!!!!!!!!!!!!!Spinner disabled!!!!!!!!!!!!
        if (auxiliary.equals("П")) { Hueta.joining(); }
        if (auxiliary.equals("Р")) { Hueta.destruction(); }
        if (auxiliary.equals("З")) { Hueta.exchange(); }
        if (auxiliary.equals("О")) { Hueta.replace(); }
    }
}
