package com.gen_5_new.Fragment;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.gen_5_new.R;
import java.util.Objects;

public class Solution extends Fragment {
    public static EditText editW, editV, editQ;
    public static TextView answerMass, answerSolution;
    public AppCompatActivity APC;
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getActivity()).setContentView(R.layout.fragment_solution);
        editW = Objects.requireNonNull(getActivity()).findViewById(R.id.editW);
        editV = Objects.requireNonNull(getActivity()).findViewById(R.id.editV);
        editQ = Objects.requireNonNull(getActivity()).findViewById(R.id.editQ);
        answerMass = Objects.requireNonNull(getActivity()).findViewById(R.id.answerMass);
        answerSolution = Objects.requireNonNull(getActivity()).findViewById(R.id.answerSolution);
        Objects.requireNonNull(getActivity()).findViewById(R.id.btnAnswer).setOnClickListener(ListenerSolution);
    }

    public View.OnClickListener ListenerSolution = (v) -> {
        if(v.getId() == R.id.btnAnswer) {
            String AnswerMass = Calculation(
                    Double.parseDouble(editW.getText().toString()),
                    Double.parseDouble(editV.getText().toString()),
                    Double.parseDouble(editQ.getText().toString())) + "г.";
            String AnswerSolution = "Необходимый взять мерную колбу на: " + Rounding(Double.parseDouble(editV.getText().toString())) + "См3";
            answerMass.setText(AnswerMass); answerSolution.setText(AnswerSolution);
        }
    };//ListenerSolution

    public static double Rounding(double VGiven) {
        double[] VExists = { 5, 10, 15, 20, 25, 50, 100, 150, 200, 250, 300, 500 };
        for(int i = 0, j = 0; VExists.length > i && j==0; i++) { if(VExists[i] >= VGiven) { VGiven = VExists[i]; j++; } }
        return VGiven;
    }
    public static double Calculation(double concentration, double VGiven, double density) {
        return Math.ceil(VGiven * density * concentration / 100 * Math.pow(10, 4)) / Math.pow(10, 4);
    }

//    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_solution, container, false);
//    }
}