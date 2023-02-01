package com.gen_5_new.Fragment;
import static com.gen_5_new.Identify.*;
import android.os.Bundle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.gen_5_new.R;
import java.util.Objects;

public class Molar_Weight extends Fragment {
    public TextView texttest1;
    public static EditText editest1;
    public DrawerLayout drawerLayout;
    public static String NameSubstanse = "";
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getActivity()).setContentView(R.layout.fragment_molar_weight);
        //Don't work->  NavigationUI.setupWithNavController(nav_view, navCont);//способность выбирать item from list
        Objects.requireNonNull(getActivity()).findViewById(R.id.btntest1).setOnClickListener(onClickListener1);
        texttest1 = Objects.requireNonNull(getActivity()).findViewById(R.id.texttest1);
        editest1 = Objects.requireNonNull(getActivity()).findViewById(R.id.edittest1);
        drawerLayout = Objects.requireNonNull(getActivity()).findViewById(R.id.drawerLayout);
    }

    public String Calculation() { Identify();
        return String.valueOf(weight[1] * id[1] + weight[2] * id[2] + weight[3] * id[3] + weight[4] * id[4]);
    }

    public View.OnClickListener onClickListener1 = (v) -> {
        if(v.getId() == R.id.btntest1) { NameSubstanse = editest1.getText().toString(); texttest1.setText(Calculation()); }
        if(v.getId() == R.id.BtnToolBar1) { drawerLayout.openDrawer(GravityCompat.START); }
    };//Listener
}