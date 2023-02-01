package Ingener;
import static Ingener.Base.*;
import static Ingener.Substance.*;

public class Main {
    public static void main(String[] args) {
        int u = 1;
        System.out.println(getA(u) + " " + getB(u) + " " + getC(u));//null null null
        setA(u, 7);
        System.out.println(getA(u) + " " + getB(u) + " " + getC(u));//7 null null
        setB(u, "ХУЙ");
        System.out.println(getA(u) + " " + getB(u) + " " + getC(u));//7 ХУЙ null
        setC(u, false);
        System.out.println(getA(u) + " " + getB(u) + " " + getC(u));//7 ХУЙ false
    }
    //TODO Скобки с комплексными в-вами
    //TODO научить обрабатывать невозможные случаи по типу индекс==1 или введено несуществующие в-во
    //TODO если индекс 9+ (С1400H2000O70)
    //TODO то делать с CO3^2- и CO2 ( CH4 валентность )
    //TODO весь метод внести в try catch
    //TODO с аналитической или не аналитической массой
    private static String buffer, name = "NaCl3";//(NH4)3(OH)8SO4 (NH4)3(SO4)8(OH5)7 (NH4)3SO4(OH5)7 NH4(SO4OH)5
    private static boolean auxiliary1, key1, control, BracketBoolean;
    private static int all = 1, key2, almost, length, auxiliary2, ControlVal, IdVal;
    private static char[] arrayChar;
    public static String[]el = new String[7], bracket = { "", "", "", "", "", "", "" }, controlEl = new String[7];
    public static double[] weight = new double[7];
    public static int[] id = new int[7], idBracket = new int[4];
    private static int itNumeric(String s) { try { return Integer.parseInt(s); } catch(NumberFormatException e) { return 666; } }
    private static void Update(int code) {
        if(code == 1) {
            for(int i = 0; i < 7; i++) { el[i] = ""; bracket[i] = ""; id[i] = 1; weight[i] = 0; controlEl[i] = ""; }
            for(int i = 0; i < 4; i++) { idBracket[i] = 1; almost = 0; ControlVal = -1; auxiliary2 = 0; IdVal = 0; }
            control = false; auxiliary1 = true; arrayChar = name.toCharArray(); length = arrayChar.length;
        }
        if(code == 2) {
            buffer = ""; key1 = true; key2 = 0; BracketBoolean = true;
            int BracketVal = 0;
            if(auxiliary2 == 1) { bracket[1] = "("; BracketVal = 1; }
            if(auxiliary2 == 2) { bracket[2] = ")"; BracketVal = 2 + Sout(idBracket[1]); }
            if(auxiliary2 == 3) { bracket[3] = "("; BracketVal = 3 + Sout(idBracket[1]); }
            if(auxiliary2 == 4) { bracket[4] = ")"; BracketVal = 4 + Sout(idBracket[1]) + Sout(idBracket[2]); }
            if(auxiliary2 == 5) { bracket[5] = "("; BracketVal = 5 + Sout(idBracket[1]) + Sout(idBracket[2]); }
            if(auxiliary2 == 6) { bracket[6] = ")"; BracketVal = 6 + Sout(idBracket[1]) + Sout(idBracket[2]) + Sout(idBracket[3]); }
            //===============0
            almost = BracketVal + el[1].length() + el[2].length() + el[3].length() + el[4].length() + el[5].length() + el[6].length();
            //===============1
            if(id[1] != 1 && id[2] == 1 && id[3] == 1 && id[4] == 1 && id[5] == 1 && id[6] == 1) { almost += Sout(id[1]); }
            if(id[1] == 1 && id[2] != 1 && id[3] == 1 && id[4] == 1 && id[5] == 1 && id[6] == 1) { almost += Sout(id[2]); }
            if(id[1] == 1 && id[2] == 1 && id[3] != 1 && id[4] == 1 && id[5] == 1 && id[6] == 1) { almost += Sout(id[3]); }
            if(id[1] == 1 && id[2] == 1 && id[3] == 1 && id[4] != 1 && id[5] == 1 && id[6] == 1) { almost += Sout(id[4]); }
            if(id[1] == 1 && id[2] == 1 && id[3] == 1 && id[4] == 1 && id[5] != 1 && id[6] == 1) { almost += Sout(id[5]); }
            if(id[1] == 1 && id[2] == 1 && id[3] == 1 && id[4] == 1 && id[5] == 1 && id[6] != 1) { almost += Sout(id[6]); }
            //===============2
            if(id[1] == 1 && id[2] == 1 && id[3] == 1 && id[4] == 1 && id[5] != 1 && id[6] != 1) { almost += Sout(id[5]) + Sout(id[6]); }
            if(id[1] == 1 && id[2] == 1 && id[3] == 1 && id[4] != 1 && id[5] != 1 && id[6] == 1) { almost += Sout(id[4]) + Sout(id[5]); }
            if(id[1] == 1 && id[2] == 1 && id[3] == 1 && id[4] != 1 && id[5] == 1 && id[6] != 1) { almost += Sout(id[4]) + Sout(id[6]); }
            if(id[1] == 1 && id[2] == 1 && id[3] != 1 && id[4] != 1 && id[5] == 1 && id[6] == 1) { almost += Sout(id[3]) + Sout(id[4]); }
            if(id[1] == 1 && id[2] == 1 && id[3] != 1 && id[4] == 1 && id[5] != 1 && id[6] == 1) { almost += Sout(id[3]) + Sout(id[5]); }
            if(id[1] == 1 && id[2] == 1 && id[3] != 1 && id[4] == 1 && id[5] == 1 && id[6] != 1) { almost += Sout(id[2]) + Sout(id[6]); }
            if(id[1] == 1 && id[2] != 1 && id[3] != 1 && id[4] == 1 && id[5] == 1 && id[6] == 1) { almost += Sout(id[2]) + Sout(id[3]); }
            if(id[1] == 1 && id[2] != 1 && id[3] == 1 && id[4] != 1 && id[5] == 1 && id[6] == 1) { almost += Sout(id[2]) + Sout(id[4]); }
            if(id[1] == 1 && id[2] != 1 && id[3] == 1 && id[4] == 1 && id[5] != 1 && id[6] == 1) { almost += Sout(id[2]) + Sout(id[5]); }
            if(id[1] == 1 && id[2] != 1 && id[3] == 1 && id[4] == 1 && id[5] == 1 && id[6] != 1) { almost += Sout(id[2]) + Sout(id[6]); }
            if(id[1] != 1 && id[2] != 1 && id[3] == 1 && id[4] == 1 && id[5] == 1 && id[6] == 1) { almost += Sout(id[1]) + Sout(id[2]); }
            if(id[1] != 1 && id[2] == 1 && id[3] != 1 && id[4] == 1 && id[5] == 1 && id[6] == 1) { almost += Sout(id[1]) + Sout(id[3]); }
            if(id[1] != 1 && id[2] == 1 && id[3] == 1 && id[4] != 1 && id[5] == 1 && id[6] == 1) { almost += Sout(id[1]) + Sout(id[4]); }
            if(id[1] != 1 && id[2] == 1 && id[3] == 1 && id[4] == 1 && id[5] != 1 && id[6] == 1) { almost += Sout(id[1]) + Sout(id[5]); }
            if(id[1] != 1 && id[2] == 1 && id[3] == 1 && id[4] == 1 && id[5] == 1 && id[6] != 1) { almost += Sout(id[1]) + Sout(id[6]); }
            //===============3
            if(id[1] != 1 && id[2] != 1 && id[3] != 1 && id[4] == 1 && id[5] == 1 && id[6] == 1) { almost += Sout(id[1]) + Sout(id[2]) + Sout(id[3]); }
            if(id[1] != 1 && id[2] != 1 && id[3] == 1 && id[4] != 1 && id[5] == 1 && id[6] == 1) { almost += Sout(id[1]) + Sout(id[2]) + Sout(id[4]); }
            if(id[1] != 1 && id[2] != 1 && id[3] == 1 && id[4] == 1 && id[5] != 1 && id[6] == 1) { almost += Sout(id[1]) + Sout(id[2]) + Sout(id[5]); }
            if(id[1] != 1 && id[2] != 1 && id[3] == 1 && id[4] == 1 && id[5] == 1 && id[6] != 1) { almost += Sout(id[1]) + Sout(id[2]) + Sout(id[6]); }
            if(id[1] != 1 && id[2] == 1 && id[3] != 1 && id[4] != 1 && id[5] == 1 && id[6] == 1) { almost += Sout(id[1]) + Sout(id[3]) + Sout(id[4]); }
            if(id[1] == 1 && id[2] != 1 && id[3] != 1 && id[4] != 1 && id[5] == 1 && id[6] == 1) { almost += Sout(id[2]) + Sout(id[3]) + Sout(id[4]); }
            if(id[1] == 1 && id[2] != 1 && id[3] != 1 && id[4] == 1 && id[5] != 1 && id[6] == 1) { almost += Sout(id[2]) + Sout(id[3]) + Sout(id[5]); }
            if(id[1] == 1 && id[2] != 1 && id[3] != 1 && id[4] == 1 && id[5] == 1 && id[6] != 1) { almost += Sout(id[2]) + Sout(id[3]) + Sout(id[6]); }
            if(id[1] != 1 && id[2] == 1 && id[3] != 1 && id[4] == 1 && id[5] != 1 && id[6] == 1) { almost += Sout(id[1]) + Sout(id[3]) + Sout(id[5]); }
            if(id[1] == 1 && id[2] != 1 && id[3] == 1 && id[4] != 1 && id[5] == 1 && id[6] != 1) { almost += Sout(id[2]) + Sout(id[4]) + Sout(id[6]); }
            if(id[1] != 1 && id[2] == 1 && id[3] == 1 && id[4] != 1 && id[5] != 1 && id[6] == 1) { almost += Sout(id[1]) + Sout(id[4]) + Sout(id[5]); }
            if(id[1] == 1 && id[2] != 1 && id[3] == 1 && id[4] != 1 && id[5] != 1 && id[6] == 1) { almost += Sout(id[2]) + Sout(id[4]) + Sout(id[5]); }
            if(id[1] == 1 && id[2] == 1 && id[3] != 1 && id[4] != 1 && id[5] != 1 && id[6] == 1) { almost += Sout(id[3]) + Sout(id[4]) + Sout(id[5]); }
            if(id[1] == 1 && id[2] == 1 && id[3] != 1 && id[4] != 1 && id[5] == 1 && id[6] != 1) { almost += Sout(id[3]) + Sout(id[4]) + Sout(id[6]); }
            if(id[1] != 1 && id[2] == 1 && id[3] == 1 && id[4] == 1 && id[5] != 1 && id[6] != 1) { almost += Sout(id[1]) + Sout(id[5]) + Sout(id[6]); }
            if(id[1] == 1 && id[2] != 1 && id[3] == 1 && id[4] == 1 && id[5] != 1 && id[6] != 1) { almost += Sout(id[2]) + Sout(id[5]) + Sout(id[6]); }
            if(id[1] == 1 && id[2] == 1 && id[3] != 1 && id[4] == 1 && id[5] != 1 && id[6] != 1) { almost += Sout(id[3]) + Sout(id[5]) + Sout(id[6]); }
            if(id[1] == 1 && id[2] == 1 && id[3] == 1 && id[4] != 1 && id[5] != 1 && id[6] != 1) { almost += Sout(id[4]) + Sout(id[5]) + Sout(id[6]); }
            //===============4
            if(id[1] == 1 && id[2] == 1 && id[3] != 1 && id[4] != 1 && id[5] != 1 && id[6] != 1) { almost += Sout(id[3]) + Sout(id[4]) + Sout(id[5]) + Sout(id[6]); }
            if(id[1] != 1 && id[2] == 1 && id[3] == 1 && id[4] != 1 && id[5] != 1 && id[6] != 1) { almost += Sout(id[1]) + Sout(id[4]) + Sout(id[5]) + Sout(id[6]); }
            if(id[1] != 1 && id[2] != 1 && id[3] == 1 && id[4] == 1 && id[5] != 1 && id[6] != 1) { almost += Sout(id[1]) + Sout(id[2]) + Sout(id[5]) + Sout(id[6]); }
            if(id[1] != 1 && id[2] != 1 && id[3] != 1 && id[4] == 1 && id[5] == 1 && id[6] != 1) { almost += Sout(id[1]) + Sout(id[2]) + Sout(id[3]) + Sout(id[6]); }
            if(id[1] != 1 && id[2] != 1 && id[3] != 1 && id[4] != 1 && id[5] == 1 && id[6] == 1) { almost += Sout(id[1]) + Sout(id[2]) + Sout(id[3]) + Sout(id[4]); }
            if(id[1] == 1 && id[2] != 1 && id[3] == 1 && id[4] != 1 && id[5] != 1 && id[6] != 1) { almost += Sout(id[2]) + Sout(id[4]) + Sout(id[5]) + Sout(id[6]); }
            if(id[1] != 1 && id[2] == 1 && id[3] != 1 && id[4] == 1 && id[5] != 1 && id[6] != 1) { almost += Sout(id[1]) + Sout(id[3]) + Sout(id[5]) + Sout(id[6]); }
            if(id[1] != 1 && id[2] != 1 && id[3] == 1 && id[4] != 1 && id[5] == 1 && id[6] != 1) { almost += Sout(id[1]) + Sout(id[2]) + Sout(id[4]) + Sout(id[6]); }
            if(id[1] != 1 && id[2] != 1 && id[3] != 1 && id[4] == 1 && id[5] != 1 && id[6] == 1) { almost += Sout(id[1]) + Sout(id[2]) + Sout(id[3]) + Sout(id[5]); }
            if(id[1] == 1 && id[2] != 1 && id[3] != 1 && id[4] == 1 && id[5] != 1 && id[6] != 1) { almost += Sout(id[2]) + Sout(id[3]) + Sout(id[5]) + Sout(id[6]); }
            if(id[1] != 1 && id[2] == 1 && id[3] != 1 && id[4] != 1 && id[5] == 1 && id[6] != 1) { almost += Sout(id[1]) + Sout(id[3]) + Sout(id[4]) + Sout(id[6]); }
            if(id[1] != 1 && id[2] != 1 && id[3] == 1 && id[4] != 1 && id[5] != 1 && id[6] == 1) { almost += Sout(id[1]) + Sout(id[2]) + Sout(id[4]) + Sout(id[5]); }
            if(id[1] == 1 && id[2] != 1 && id[3] != 1 && id[4] != 1 && id[5] == 1 && id[6] != 1) { almost += Sout(id[2]) + Sout(id[3]) + Sout(id[4]) + Sout(id[6]); }
            if(id[1] != 1 && id[2] == 1 && id[3] != 1 && id[4] != 1 && id[5] != 1 && id[6] == 1) { almost += Sout(id[1]) + Sout(id[3]) + Sout(id[4]) + Sout(id[5]); }
            if(id[1] == 1 && id[2] != 1 && id[3] != 1 && id[4] != 1 && id[5] != 1 && id[6] == 1) { almost += Sout(id[2]) + Sout(id[3]) + Sout(id[4]) + Sout(id[5]); }
            //===============5
            if(id[1] == 1 && id[2] != 1 && id[3] != 1 && id[4] != 1 && id[5] != 1 && id[6] != 1) { almost += Sout(id[2]) + Sout(id[3]) + Sout(id[4]) + Sout(id[5]) + Sout(id[6]); }
            if(id[1] != 1 && id[2] == 1 && id[3] != 1 && id[4] != 1 && id[5] != 1 && id[6] != 1) { almost += Sout(id[1]) + Sout(id[3]) + Sout(id[4]) + Sout(id[5]) + Sout(id[6]); }
            if(id[1] != 1 && id[2] != 1 && id[3] == 1 && id[4] != 1 && id[5] != 1 && id[6] != 1) { almost += Sout(id[1]) + Sout(id[2]) + Sout(id[4]) + Sout(id[5]) + Sout(id[6]); }
            if(id[1] != 1 && id[2] != 1 && id[3] != 1 && id[4] == 1 && id[5] != 1 && id[6] != 1) { almost += Sout(id[1]) + Sout(id[2]) + Sout(id[3]) + Sout(id[5]) + Sout(id[6]); }
            if(id[1] != 1 && id[2] != 1 && id[3] != 1 && id[4] != 1 && id[5] == 1 && id[6] != 1) { almost += Sout(id[1]) + Sout(id[2]) + Sout(id[3]) + Sout(id[4]) + Sout(id[6]); }
            if(id[1] != 1 && id[2] != 1 && id[3] != 1 && id[4] != 1 && id[5] != 1 && id[6] == 1) { almost += Sout(id[1]) + Sout(id[2]) + Sout(id[3]) + Sout(id[4]) + Sout(id[5]); }
            //===============6
            if(id[1] != 1 && id[2] != 1 && id[3] != 1 && id[4] != 1 && id[5] != 1 && id[6] != 1) { almost += Sout(id[1]) + Sout(id[2]) + Sout(id[3]) + Sout(id[4]) + Sout(id[5]) + Sout(id[6]); }
        }
        if(code == 3) {//report//TODO Delete
            System.out.println("\nМассив окончен " + name);
            for(int i = 1; i < 7; i++) { if(!el[i].equals("")) { System.out.println("(" + i + ")" + " элемент найден - " + el[i] + " Index№" + i + " = " + id[i]);} }
            System.out.println("\nКислотные остатки с индексами:");
            for(String s : controlEl) { System.out.println(s); }
            for(int i = 1; i < 4; i++) { System.out.println(idBracket[i]); }
        }
    }
    public static void ComparatorToWeight() {
        for(int i = 0; i < 68 && !el[1].equals(""); i++) { if(getName(i).equals(el[1])) { weight[1] = getWeight(i); System.out.println(weight[1]); break; } }//TODO Delete
        for(int i = 0; i < 68 && !el[2].equals(""); i++) { if(getName(i).equals(el[2])) { weight[2] = getWeight(i); System.out.println(weight[2]); break; } }//TODO Delete
        for(int i = 0; i < 68 && !el[3].equals(""); i++) { if(getName(i).equals(el[3])) { weight[3] = getWeight(i); System.out.println(weight[3]); break; } }//TODO Delete
        for(int i = 0; i < 68 && !el[4].equals(""); i++) { if(getName(i).equals(el[4])) { weight[4] = getWeight(i); System.out.println(weight[4]); break; } }//TODO Delete
        for(int i = 0; i < 68 && !el[5].equals(""); i++) { if(getName(i).equals(el[5])) { weight[5] = getWeight(i); System.out.println(weight[5]); break; } }//TODO Delete
        for(int i = 0; i < 68 && !el[6].equals(""); i++) { if(getName(i).equals(el[6])) { weight[6] = getWeight(i); System.out.println(weight[6]); break; } }//TODO Delete
    }
    private static int Sout(int i) { return String.valueOf(i).length(); }

    public static boolean keyB = false;
    public static int keyI = -1;

    public static void identify() {
        Update(1);
        for(; all < 7; all++) {
            Update(2);
            if(all == 6 && arrayChar[length - 2] == ')') { length += 1; keyB = true; }//ОТВРАТИТЕЛЬНО
            for(; length > almost && BracketBoolean; almost++, auxiliary1 = true) {
                System.out.println("========Новый цикл======== almost:" + almost);//TODO Delete
                if(keyB) {
                    if(id[6] != 1) { length++; }
                    if(++keyI == 3) {
                        buffer = "";
                        BracketBoolean = false;
                        if(id[6] != 1) { almost -= 1; }
                        else almost -= 2;
                    }
                }
                buffer += String.valueOf(arrayChar[almost]); System.out.println("Проверяемый: " + buffer);//TODO Delete

                //Find bracket. It's open for me acid remains
                if(buffer.equals("(") || buffer.equals(")")) {
                    if (buffer.equals("(")) { control = true;  System.out.println("====Найдена скобка ("); BracketBoolean = false; all--; }
                    if (buffer.equals(")")) { control = false; System.out.println("====Найдена скобка )");
                        idBracket[++IdVal] = itNumeric(String.valueOf(arrayChar[++almost])); buffer = "";
                        System.out.println("====idBracket[" + IdVal + "] = " + idBracket[IdVal]);
                    } auxiliary2++;
                }
                else {
                    //Find el[X].
                    for(int i = 0; 68 > i && auxiliary1; i++) {
                        if(getName(i).equals(buffer)) {
                            if(control) { controlEl[++ControlVal] = buffer; }
                            el[all] = buffer; auxiliary1 = false; System.out.println("====el[" + all + "] = " + buffer);//TODO Delete
                        }
                    }

                    //Find Index[X].
                    if(key2 > 3 && all != 1 && all != 6) { key1 = false; } key2++;//Защита от преждевременного присваивания индекса TODO про all хз
                    if(itNumeric(String.valueOf(arrayChar[almost])) != 666 && key1 && key2 <= el[all].length() + 1) {
                        id[all] = itNumeric(String.valueOf(arrayChar[almost])); key1 = false; System.out.println("====Index[" + all + "] = " + id[all]); }
                }
            }
        }
        Update(3);//TODO Delete
        ComparatorToWeight();
    }
}