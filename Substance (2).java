package Ingener; import java.util.ArrayList; import java.util.List;

public class Substance {
    private static final List<Substance> substance = new ArrayList<>(9);
    private String SUB;      //Имя в-ва.
    private String[] el;     //Элемент.
    private String[] ion;    //Катион/Анион.
    private Integer[] charge;//Заряд.
    private Double[] weight; //Масса.
    private Boolean[] power; //Сила.
    private String TYPE;     //Реагент/Продукт.

    Substance(String SUB, String[] el, String[] ion, Integer[] charge, Double[] weight, Boolean[] power, String TYPE) {
        this.SUB = SUB;
        this.el = el;
        this.ion = ion;
        this.charge = charge;
        this.weight = weight;
        this.power = power;
        this.TYPE = TYPE;
    }//Качественный состав.

    static {/*Null example.*/substance.add(new Substance(null, new String []{ null, null, null, null, null, null, null, null, null }, new String[]{ null, null, null, null, null, null, null, null, null }, new Integer[]{ null, null, null, null, null, null, null, null, null }, new Double[]{ null, null, null, null, null, null, null, null, null }, new Boolean[]{ null, null, null, null, null, null, null, null, null }, null));
        substance.add(new Substance(null, new String []{ null, null, null, null, null, null, null, null, null }, new String[]{ null, null, null, null, null, null, null, null, null }, new Integer[]{ null, null, null, null, null, null, null, null, null }, new Double[]{ null, null, null, null, null, null, null, null, null }, new Boolean[]{ null, null, null, null, null, null, null, null, null }, null));
        substance.add(new Substance(null, new String []{ null, null, null, null, null, null, null, null, null }, new String[]{ null, null, null, null, null, null, null, null, null }, new Integer[]{ null, null, null, null, null, null, null, null, null }, new Double[]{ null, null, null, null, null, null, null, null, null }, new Boolean[]{ null, null, null, null, null, null, null, null, null }, null));
        substance.add(new Substance(null, new String []{ null, null, null, null, null, null, null, null, null }, new String[]{ null, null, null, null, null, null, null, null, null }, new Integer[]{ null, null, null, null, null, null, null, null, null }, new Double[]{ null, null, null, null, null, null, null, null, null }, new Boolean[]{ null, null, null, null, null, null, null, null, null }, null));
        substance.add(new Substance(null, new String []{ null, null, null, null, null, null, null, null, null }, new String[]{ null, null, null, null, null, null, null, null, null }, new Integer[]{ null, null, null, null, null, null, null, null, null }, new Double[]{ null, null, null, null, null, null, null, null, null }, new Boolean[]{ null, null, null, null, null, null, null, null, null }, null));
        substance.add(new Substance(null, new String []{ null, null, null, null, null, null, null, null, null }, new String[]{ null, null, null, null, null, null, null, null, null }, new Integer[]{ null, null, null, null, null, null, null, null, null }, new Double[]{ null, null, null, null, null, null, null, null, null }, new Boolean[]{ null, null, null, null, null, null, null, null, null }, null));
        substance.add(new Substance(null, new String []{ null, null, null, null, null, null, null, null, null }, new String[]{ null, null, null, null, null, null, null, null, null }, new Integer[]{ null, null, null, null, null, null, null, null, null }, new Double[]{ null, null, null, null, null, null, null, null, null }, new Boolean[]{ null, null, null, null, null, null, null, null, null }, null));
        substance.add(new Substance(null, new String []{ null, null, null, null, null, null, null, null, null }, new String[]{ null, null, null, null, null, null, null, null, null }, new Integer[]{ null, null, null, null, null, null, null, null, null }, new Double[]{ null, null, null, null, null, null, null, null, null }, new Boolean[]{ null, null, null, null, null, null, null, null, null }, null));
        substance.add(new Substance(null, new String []{ null, null, null, null, null, null, null, null, null }, new String[]{ null, null, null, null, null, null, null, null, null }, new Integer[]{ null, null, null, null, null, null, null, null, null }, new Double[]{ null, null, null, null, null, null, null, null, null }, new Boolean[]{ null, null, null, null, null, null, null, null, null }, null));
    }
    public static String    getSUB(Integer ID)                  { return substance.get(ID).SUB; }
    public static String    getEl(Integer ID, Integer Arr)      { String[] Els = substance.get(ID).el; return Els[Arr]; }
    public static String    getIon(Integer ID, Integer Arr)     { String[] Ions = substance.get(ID).ion; return Ions[Arr]; }
    public static Integer   getCharge(Integer ID, Integer Arr)  { Integer[] Charges = substance.get(ID).charge; return Charges[Arr]; }
    public static Double    getWeight(Integer ID, Integer Arr)  { Double[] Weights = substance.get(ID).weight; return Weights[Arr]; }
    public static Boolean   getPower(Integer ID, Integer Arr)   { Boolean[] Powers = substance.get(ID).power; return Powers[Arr]; }
    public static String    getTYPE(Integer ID)                 { return substance.get(ID).TYPE; }
    public static void      setSUB(Integer ID, String SUB)      {
        substance.set(ID, new Substance(SUB, substance.get(ID).el, substance.get(ID).ion, substance.get(ID).charge, substance.get(ID).weight, substance.get(ID).power, getTYPE(ID))); }
    public static void      setEL(Integer ID, Integer Arr, String El) {
        String[] Els = { getEl(ID, 0), getEl(ID, 1), getEl(ID, 2), getEl(ID, 3), getEl(ID, 4), getEl(ID, 5), getEl(ID, 6), getEl(ID, 7), getEl(ID, 8) };
        Els[Arr] = El;
        substance.set(ID, new Substance(getSUB(ID), Els, substance.get(ID).ion, substance.get(ID).charge, substance.get(ID).weight, substance.get(ID).power, getTYPE(ID))); }
    public static void      setIon(Integer ID, Integer Arr, String ION) {
        String[] Ions = { getIon(ID, 0), getIon(ID, 1), getIon(ID, 2), getIon(ID, 3), getIon(ID, 4), getIon(ID, 5), getIon(ID, 6), getIon(ID, 7), getIon(ID, 8) };
        Ions[Arr] = ION;
        substance.set(ID, new Substance(getSUB(ID), substance.get(ID).el, Ions, substance.get(ID).charge, substance.get(ID).weight, substance.get(ID).power, getTYPE(ID))); }
    public static void      setCharge(Integer ID, Integer Arr, Integer C) {
        Integer[] Cs = { getCharge(ID, 0), getCharge(ID, 1), getCharge(ID, 2), getCharge(ID, 3), getCharge(ID, 4), getCharge(ID, 5), getCharge(ID, 6), getCharge(ID, 7), getCharge(ID, 8) };
        Cs[Arr] = C;
        substance.set(ID, new Substance(getSUB(ID), substance.get(ID).el, substance.get(ID).ion, Cs, substance.get(ID).weight, substance.get(ID).power, getTYPE(ID))); }
    public static void      setWeight(Integer ID, Integer Arr, Double W) {
        Double[] Ws = { getWeight(ID, 0), getWeight(ID, 1), getWeight(ID, 2), getWeight(ID, 3), getWeight(ID, 4), getWeight(ID, 5), getWeight(ID, 6), getWeight(ID, 7), getWeight(ID, 8) };
        Ws[Arr] = W;
        substance.set(ID, new Substance(getSUB(ID), substance.get(ID).el, substance.get(ID).ion, substance.get(ID).charge, Ws, substance.get(ID).power, getTYPE(ID))); }
    public static void      setPower(Integer ID, Integer Arr, Boolean P) {
        Boolean[] Ps = { getPower(ID, 0), getPower(ID, 1), getPower(ID, 2), getPower(ID, 3), getPower(ID, 4), getPower(ID, 5), getPower(ID, 6), getPower(ID, 7), getPower(ID, 8) };
        Ps[Arr] = P;
        substance.set(ID, new Substance(getSUB(ID), substance.get(ID).el, substance.get(ID).ion, substance.get(ID).charge, substance.get(ID).weight, Ps, getTYPE(ID))); }
    public static void      setTYPE(Integer ID, String TYPE)    {
        substance.set(ID, new Substance(getSUB(ID), substance.get(ID).el, substance.get(ID).ion, substance.get(ID).charge, substance.get(ID).weight, substance.get(ID).power, TYPE));
    }
}