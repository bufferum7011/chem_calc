package com.gen_5_new;
import android.view.View;
import android.widget.AdapterView;

public interface SpinnerIo {
    public void onItemSelected(AdapterView<?> adapter, View view, int position, long id);
    public void onNothingSelected(AdapterView<?> parent);
    public void distributeSpinner();
}

