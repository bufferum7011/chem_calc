package Ingener; import java.util.ArrayList; import java.util.List;

public class Base {
    private String name;    //Имя элемента
    private Integer charge; //Валентность.
    private Double weight;  //Масса элемента
    private Boolean power;  //Для табл растворимости КАЖЕТСЯ
    private Integer activity;//ID в ряду активности.
    private String ion;     //Катион/Анион. TODO DELETE
    private static final List<Base> Data = new ArrayList<>(88);
    Base(String name, Integer charge, Double weight, Boolean power, Integer activity) {
        this.name = name;
        this.charge = charge;
        this.weight = weight;
        this.power = power;
        this.activity = activity;
    }

    /**Таблица растворимости.*/
    public static boolean TableSolution(String elementX, String elementY) {
        boolean allowed = (elementX == "H") && (elementY == "OH");
        if((elementX == "NH4") || (elementX == "H") && elementY == "SiO3")                          { allowed = true; }
        if((elementX == "Ag") && (elementY == "Cl") || (elementY == "Br")   || (elementY == "F"))   { allowed = true; }
        if((elementX == "Ag") && (elementY == "OH") || (elementY == "S")    || (elementY == "SO4")) { allowed = true; }
        if((elementX == "Ag") && (elementY == "CO3")|| (elementY == "SiO3") || (elementY == "PO4")) { allowed = true; }
        if((elementX == "Ca") && (elementY == "OH") || (elementY == "S")    || (elementY == "SO4")) { allowed = true; }
        if((elementX == "Ca") && (elementY == "F")  || (elementY == "SiO3") || (elementY == "PO4")) { allowed = true; }
        if((elementX == "Mg") && (elementY == "OH") || (elementY == "S")    || (elementY == "CO3")) { allowed = true; }
        if((elementX == "Mg") && (elementY == "F")  || (elementY == "SiO3") || (elementY == "PO4")) { allowed = true; }
        if((elementX == "Cu") && (elementY == "OH") || (elementY == "S")    || (elementY == "CO3")) { allowed = true; }
        if((elementX == "Cu") && (elementY == "I")  || (elementY == "SiO3") || (elementY == "PO4")) { allowed = true; }
        if((elementX == "Al") && (elementY == "OH") || (elementY == "CO3")  || (elementY == "F"))   { allowed = true; }
        if((elementX == "Al") && (elementY == "S")  || (elementY == "SiO3") || (elementY == "PO4")) { allowed = true; }
        return allowed; }

    /**Ряд активности металлов.*/
    public static boolean ActivityMetals(String elementReplaceable, String elementSalt) {
        int elementReplaceableInt = 0, elementSaltInt = 0;
        for(int i = 0; i < 88 && !elementReplaceable.equals(""); i++) {
            if(getName(i).equals(elementReplaceable)) { elementReplaceableInt = getActivity(i); break; } }
        for(int i = 0; i < 88 && !elementSalt.equals(""); i++) {
            if(getName(i).equals(elementSalt)) { elementSaltInt = getActivity(i); break; } }

        boolean b = false;
        if(elementReplaceableInt < elementSaltInt) { b = true; }
        return b; }

    /**Ascii - готовый метод для извлечения символов. Большие и маленькие буквы, цифры и круглые скобки*/
    public static int Ascii(int a) {
        char[] registry = new char[64];
        for (int i = 40; i <= 41; ) { for (int j = 62; j <= 63;) { registry[j] = (char)i; j++; i++; } }//скобки
        for (int i = 48; i <= 57; ) { for (int j = 0;  j < 10; ) { registry[j] = (char)i; j++; i++; } }//цифры
        for (int i = 65; i <= 90; ) { for (int j = 10; j < 36; ) { registry[j] = (char)i; j++; i++; } }//большие буквы
        for (int i = 97; i <= 122;) { for (int j = 36; j < 62; ) { registry[j] = (char)i; j++; i++; } }//маленьки буквы
        return registry[a]; }

    /**Method returns data about the element.*/
    static {
        Data.add(new Base(null, null, null, null, null));//8
        Data.add(new Base("H", 1, 1.008, false, 56));
        Data.add(new Base("He", 0, 4.0026, false, 666));
        Data.add(new Base("Li", 1, 6.941, true, 3));
        Data.add(new Base("Be", 2, 10.811, false, 34));//p
        Data.add(new Base("B", 3, 10.811, false, 666));
        Data.add(new Base("C", 0, 12.011, false, 666));//n, p
        Data.add(new Base("N", 0, 14.007, false, 777));//n, p
        Data.add(new Base("O", -2, 15.999, false, 777));
        Data.add(new Base("F", -1, 18.998, false, 777));//
        Data.add(new Base("Ne", 0, 20.1797, false, 666));////
        Data.add(new Base("Na", 1, 22.989, true, 11));
        Data.add(new Base("Mg", 2, 24.305, false, 20));
        Data.add(new Base("Al", 3, 26.982, false, 35));
        Data.add(new Base("Si", 4, 28.086, false, 777));
        Data.add(new Base("P", 4, 30.974, false, 777));
        Data.add(new Base("S", 0, 32.076, false, 777));
        Data.add(new Base("Cl", -1, 35.452, true, 777));
        Data.add(new Base("Ar", 0, 39.948, false, 666));
        Data.add(new Base("K", 1, 39.098, true, 6));
        Data.add(new Base("Ca", 2, 40.078, true, 10));
        Data.add(new Base("Sc", 0, 44.956, false, 28));//ХЗ
        Data.add(new Base("Ti", 0, 47.867, false, 36));//ХЗ
        Data.add(new Base("V", 0, 50.942, false, 40));//ХЗ
        Data.add(new Base("Cr", 0, 51.996, false, 43));//ХЗ
        Data.add(new Base("Mn", 0, 54.938, false, 39));//TODO
        Data.add(new Base("Fe", 0, 55.847, false, 46));//ХЗ
        Data.add(new Base("Co", 0, 58.933, false, 50));//ХЗ
        Data.add(new Base("Ni", 0, 58.694, false, 51));//ХЗ
        Data.add(new Base("Cu", 2, 63.546, false, 62));//TODO
        Data.add(new Base("Zn", 2, 65.380, false, 44));//ХЗ
        Data.add(new Base("Ga", 0, 69.723, false, 45));//ХЗ
        Data.add(new Base("Ge", 0, 72.630, false, 60));//ХЗ
        Data.add(new Base("As", 0, 74.922, false, 666));//ХЗ
        Data.add(new Base("Se", 0, 78.960, false, 666));//ХЗ
        Data.add(new Base("Br", -1, 79.904, false, 777));
        Data.add(new Base("Kr", 0, 83.798, false, 666));
        Data.add(new Base("Rb", 0, 85.468, false, 5));
        Data.add(new Base("Sr", 0, 87.620, false, 9));
        Data.add(new Base("Y", 0, 88.904, false, 21));
        Data.add(new Base("Zr", 0, 91.224, false, 37));
        Data.add(new Base("Nb", 0, 92.906, false, 41));
        Data.add(new Base("Mo", 0, 95.960, false, 53));
        Data.add(new Base("Tc", 0, 97.907, false, 63));
        Data.add(new Base("Ru", 0, 101.070, false, 666));
        Data.add(new Base("Rh", 0, 102.906, false, 65));
        Data.add(new Base("Pd", 0, 106.420, false, 69));
        Data.add(new Base("Ag", 1, 107.868, false, 68));
        Data.add(new Base("Cd", 0, 112.411, false, 47));
        Data.add(new Base("In", 0, 114.818, false, 48));
        Data.add(new Base("Sn", 0, 118.710, false, 54));
        Data.add(new Base("Sb", 0, 121.760, false, 58));
        Data.add(new Base("Te", 0, 127.600, false, 52));
        Data.add(new Base("I", -1, 126.905, false, 64));
        Data.add(new Base("Xe", 0, 131.293, false, 666));
        Data.add(new Base("La", 0, 138.905, false, 13));
        Data.add(new Base("Ce", 0, 140.12, false, 14));
        Data.add(new Base("Pr", 0, 140.907, false, 15));
        Data.add(new Base("Nd", 0, 144.24, false, 16));
        Data.add(new Base("Pm", 0, 145.0, false, 17));
        Data.add(new Base("Sm", 0, 150.4, false, 2));
        Data.add(new Base("Eu", 0, 151.96, false, 1));
        Data.add(new Base("Gd", 0, 157.25, false, 18));
        Data.add(new Base("Tb", 0, 158.925, false, 19));
        Data.add(new Base("Dy", 0, 162.5, false, 22));
        Data.add(new Base("Ho", 0, 164.93, false, 24));
        Data.add(new Base("Er", 0, 167.26, false, 25));
        Data.add(new Base("Tm", 0, 168.934, false, 26));
        Data.add(new Base("Yb", 0, 174.04, false, 38));
        Data.add(new Base("Lu", 0, 174.967, false, 27));
        Data.add(new Base("Cs", 1, 132.905, false, 4));
        Data.add(new Base("Ba", 2, 137.327, false, 8));
        Data.add(new Base("Hf", 0, 178.490, false, 33));
        Data.add(new Base("Ta", 0, 180.948, false, 666));
        Data.add(new Base("W", 0, 183.840, false, 57));
        Data.add(new Base("Re", 0, 186.207, false, 61));
        Data.add(new Base("Os", 0, 190.230, false, 70));
        Data.add(new Base("Ir", 0, 192.217, false, 71));
        Data.add(new Base("Pt", 0, 195.084, false, 72));
        Data.add(new Base("Au", 0, 196.967, false, 73));
        Data.add(new Base("Hg", 0, 200.592, false, 67));
        Data.add(new Base("Ti", 0, 204.383, false, 36));
        Data.add(new Base("Pb", 0, 207.200, false, 55));
        Data.add(new Base("Bi", 0, 208.980, false, 59));
        Data.add(new Base("Po", 0, 208.982, false, 66));
        Data.add(new Base("At", 0, 209.987, false, 666));
        Data.add(new Base("Rn", 0, 222.0176, false, 666));
        Data.add(new Base("Fr", 1, 223.020, false, 777));
        Data.add(new Base("Ra", 2, 226.025, false, 7)); }
    public static String getName(int i) { return Data.get(i).name; }
    public static int getCharge(int i) { return Data.get(i).charge; }
    public static double getWeight(int i) { return Data.get(i).weight; }
    public static Boolean getPower(int i) { return Data.get(i).power; }
    public static Integer getActivity(int i) { return Data.get(i).activity; }
}