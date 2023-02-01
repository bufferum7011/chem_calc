package com.gen_5_new.Fragment;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gen_5_new.R;

public class Solving_chem_equ extends Fragment {

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Не трогать эту неблагодарную пизду Objects.requireNonNull(getActivity()).setContentView(R.layout.fragment_solving_chem_equ);
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_solving_chem_equ, container, false);
    }
}