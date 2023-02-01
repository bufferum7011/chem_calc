package com.gen_5_new;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    public static EditText edit1, edit2, edit3, edit4, edit5, edit6, edit7, edit8, edit11, edit12, edit13, edit14;
    public static DrawerLayout drawerLayout;
    public static TextView textBar;
    public static NavigationView nav_view;
    public static NavController navCont;
    public static Toolbar toolbar;
    public static TextView resultS;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerLayout);
        navCont = Navigation.findNavController(this, R.id.navHost);
        nav_view = findViewById(R.id.nav_view);
        NavigationUI.setupWithNavController(nav_view, Navigation.findNavController(this, R.id.navHost));//способность выбирать item from list
        textBar = findViewById(R.id.textBar);
        toolbar = findViewById(R.id.toolbar);
        resultS = findViewById(R.id.resultS);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        edit3 = findViewById(R.id.edit3);
        edit4 = findViewById(R.id.edit4);
        edit5 = findViewById(R.id.edit5);
        edit6 = findViewById(R.id.edit6);
        edit7 = findViewById(R.id.edit7);
        edit8 = findViewById(R.id.edit8);
        findViewById(R.id.enter44).setOnClickListener(ListenerMainActivity);
//        findViewById(R.id.BtnToolBar1).setOnClickListener(ListenerMainActivity);
    }

    public View.OnClickListener ListenerMainActivity = v -> {
        if(v.getId() == R.id.enter44) {
            System.out.println("1111111111111111111111111111111");
            Hueta.replace();//TODO Пердворительно, но удалить из-за спинера
            System.out.println("222222222222222222222222222");
            resultS.setText(String.valueOf(Hueta.answer)); System.out.println("MAIN222222 " + Hueta.answer);
        }
    };

//    public interface OnFragmentInteractionListener {
//        void onFragmentInteraction(Uri uri);
//    }
}