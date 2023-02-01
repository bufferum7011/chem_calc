package Ingener;
import static Ingener.Base.*;
import static Ingener.Substance.*;

public class Valence {

    public static boolean permission = false;
    public static void Verify() {

        Valence v = new Valence();
        int[] arr = InvertElementNum("H", "Ca", "K", "Li", "W", "S");

        for(int i = 0; i < arr.length; i++) {
            System.out.println("Array created is :: " + arr[i]);
        }



        Report(permission);
    }

//    public static int[] InvertElementNum(String el1, String el2, String el3, String el4, String el5, String el6) {
//        int[] potential = { 0, 0, 0, 0, 0, 0 };
//        for(int i = 0; i < 68 && !el1.equals(""); i++) { if(Base.Name(i).equals(el1)) { potential[0] = i; break; } }//TODO Delete
//        for(int i = 0; i < 68 && !el2.equals(""); i++) { if(Base.Name(i).equals(el2)) { potential[1] = i; break; } }//TODO Delete
//        for(int i = 0; i < 68 && !el3.equals(""); i++) { if(Base.Name(i).equals(el3)) { potential[2] = i; break; } }//TODO Delete
//        for(int i = 0; i < 68 && !el4.equals(""); i++) { if(Base.Name(i).equals(el4)) { potential[3] = i; break; } }//TODO Delete
//        for(int i = 0; i < 68 && !el5.equals(""); i++) { if(Base.Name(i).equals(el5)) { potential[4] = i; break; } }//TODO Delete
//        for(int i = 0; i < 68 && !el6.equals(""); i++) { if(Base.Name(i).equals(el6)) { potential[5] = i; break; } }//TODO Delete
//        return potential;
//    }
//    public static void Report(boolean permission) {
//        if(permission) System.out.println("> Вещество существует!");
//        else System.out.println("> Вещества не существует!");
//    }
}
