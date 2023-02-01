package Ingener;

import java.lang.String;
import java.util.Scanner;
import java.lang.Math;

public class Logic {

    //Глобальные переменныеx
    static int charge1 = 1, charge2 = 1, charge3 = 1, charge4 = 1, choice = -1, allowed = 0,
            STR1 = 1, STR2 = 1, STR3 = 1, STR4 = 1, pot1 = 1, pot2 = 1, pot3 = 1, pot4 = 1, pot5 = 1, pot6 = 1;
    static int[] index = {0, 1, 1, 1, 1, 1, 1, 1, 1};
    static String[] br = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
    static String element1 = "", element2 = "", element3 = "", element4 = "",
            H2O = "H2 + 2OH --> 2H2O", H2O2 = "2H2O --> 2H2 + O2", TAB = "\t",
            PH1 = "pH = 7", PH2 = "pH > 7", PH3 = "pH < 7", auxiliary,
            str1, str2, str3, str4, idx1, idx2, idx3, idx4, idx5, idx6, idx7, idx8;
    static boolean[] bracket = {false, false, false, false, false, false, false, false, false};
    static boolean H2 = false, pass = true, power1, power2, power3, power4;
    static Scanner word = new Scanner(System.in);

    //хим. уравния
    public static void joining() {
        System.out.println("         A + B --> AB");
        GetFS();//первое в-во
        GetSS();//второе в-во
        //расчет коэффицентов и скобок
        if (charge1 == charge2) {
            if (index[1] == 1 && index[2] == 2) { STR1 = index[2] = STR3; }//K+Cl2
            if (index[1] == 2 && index[2] == 1) { STR2 = 2; STR3 = 2; }//H2+NO3
            if (index[1] == 2 && index[2] == 2) { STR3 = 2; } }//H2+Cl2
        if (charge1 == 1 && charge2 == 2 || charge2 == 3) { index[3] = charge2; STR1 = charge2; }
        if (charge1 == 2 && charge2 == 1) { index[4] = charge1; bracket[2] = true; }
        if (charge1 == 2 && charge2 == 3) { STR1 = index[3] *= charge2; STR2 = index[4] *= charge1; bracket[2] = true; }
        if (charge1 == 3 && charge2 == 2)  { STR1 = index[3] *= charge2; STR2 = index[4] *= charge1; bracket[2] = true; }
        if (charge1 == 3 && charge2 == 1) { if (index[1] == 3 && index[2] == 2) { STR1 *= index[2]; STR3 *= index[2]; } }

        //скобки и обработка случаев
        if (Base.Name(11).equals(element1) && charge2 > 1) { bracket[1] = true; }//скобки только для NH4
        if (Base.Name(12).equals(element1) && charge1 >= 1) { bracket[2] = true; }//скобки только для OH
        if (element1.equals(Base.Name(0)) && element2.equals(Base.Name(19))) { H2 = true; }// + OH
        if (element1.equals(Base.Name(0)) && element2.equals (Base.Name(1))) { STR3 = 2; }// + O2
        actionBracket();
        senselessly();//чистка бессмысленных 1

        //вывод данных
        System.out.println("============================");
        if (!H2) {
            System.out.print(str1 + element1 + idx1 + " + " + str2 + element2 + idx2 + " --> ");
            System.out.println(str3 + br[1] + element1 + br[2] + idx3 + br[3] + element2 + br[4] + idx4); }
        else {System.out.print(H2O);} }
    public static void destruction() {
        System.out.print("         AB --> A + B\n");//Al2(SiO3)3
        GetFS();//первое в-во
        GetSS();//второе в-во

        //расчет коэффицентов
        if (charge1 == charge2) {
            if (index[1] == 1 && index[2] == 1) { index[3] = 1; index[4] = 1; }
            if (index[1] == 1 && index[2] == 2) { STR1 = index[2]; STR3 = index[2]; }
            if (index[1] == 2 && index[2] == 1) { index[3] = 1; index[4] = 1; STR2 = 2; STR3 = 2; }
            if (index[1] == 2 && index[2] == 2) { index[3] = 1; index[4] = 1; STR3 = 2; } }
        if (charge1 == 1 && charge2 == 2 || charge2 == 3) { STR2 = charge2; }
        if (charge1 == 2 && charge2 == 1) {
            bracket[2] = true; STR3 = index[2];
            if (element2.equals("Br") || element2.equals("Cl") || element2.equals("F") || element2.equals("I")) { bracket[2] = false; } }
        if (charge1 == 3 && charge2 == 1) {
            bracket[2] = true; STR3 *= charge1;
            if (element2 == ("Br") || element2 == ("Cl") || element2 == ("F") || element2 == ("I")) { bracket[2] = false; } }
        if (charge1 == 2 && charge2 == 3) { bracket[2] = true; STR2 = index[1]; STR3 = index[2]; }
        if (charge1 == 3 && charge2 == 2) { bracket[2] = true; STR2 = index[1]; STR3 = index[2]; }


        //скобки
        if (element1.equals(Base.Name(0)) && element2.equals(Base.Name(1))) { H2 = true; }// H2O -->
        includeBracketNH4();
        actionBracket();
        senselessly();//чистка бессмысленных 1

        System.out.println("============================");
        if (!H2) {
            System.out.print(str1 + br[1] + element1 + br[2] + idx1 + br[3] + element2 + br[4] + idx2 + " --> ");
            System.out.print(str2 + element1 + idx3 + " + " + str3 + element2 + idx4); }
        else { System.out.print(H2O2); } }
    public static void exchange() {
        System.out.println("         AB + C --> AC + B");
        GetFS();//первое в-во
        GetSS();//второе в-во
        GetTS();//третье в-во

        if (choice > 11) { pass = false; anion(); }
        else { kation(); }

        //скобки
        includeBracketNH4();
        actionBracket();
        senselessly();//чистка бессмысленных 1

        //вывод
        System.out.println("============================");
        if (pass) {//по катиону
            System.out.print( str1 + br[1] + element1 + br[2] + idx1 + br[3] + element2 + br[4] + idx2 + " + " + str2 + element3 + idx3 + " --> ");
            System.out.print(str3 + br[5] + element3 + br[6] + idx4 + br[7] + element2 + br[8] + idx5 + " + " + str4 + element1 + idx6); }
        else {//по аниону
            System.out.print(str1 + br[1] + element1 + br[2] + idx1 + br[3] + element2 + br[4] + idx2 + " + " + str2 + element3 + idx3 + " --> ");
            System.out.print(str3 + br[5] + element1 + br[6] + idx4 + br[7] + element3 + br[8] + idx5 + " + " + str4 + element2 + idx6); } }
    public static void replace() {
        System.out.print("         AB + DC --> AC + BD\n");

        //индексы
        balance_3(charge1, charge4);
        balance_4(charge3, charge2);

        //коэффиценты
        checkAnion();//суть уравнть коэффиценты
        checkKation();

        //скобки
        if (element1 == Base.Name(0) && element2 == Base.Name(1)) { H2 = true; }// H2O -->
        includeBracketNH4();
        br12(charge1, charge2);
        br34(charge3, charge4);
        br14(charge1, charge4);
        br32(charge3, charge2);
        actionBracket();
        senselessly();//чистка бессмысленных 1

        //вывод
        System.out.println("============================");
        System.out.print(str1 + br[1] + element1 + br[2] + idx1 + br[3] + element2 + br[4] + idx2 + " + ");
        System.out.print(str2 + br[5] + element3 + br[6] + idx3 + br[7] + element4 + br[8] + idx4 + " --> ");
        System.out.print(str3 + br[9] + element1 + br[10] + idx5 + br[11] + element4 + br[12] + idx6 + " + ");
        System.out.println(str4 + br[13] + element3 + br[14] + idx7 + br[15] + element2 + br[16] + idx8);

        Base.TableSolution(element1, element4);
        Base.TableSolution(element3, element2);
        if(element1 == element3) { allowed = 0; }
        if(element2 == element4) { allowed = 0; }
        Intro.Info(); }

    //гидролиз
    public static void StrStr()  {
        waterEL34();
        System.out.println("Полное ионное уравнение");
        System.out.println(element1 + " + " + element3 + element4 + " --> " + element1 + " + " + element4 + " + " + element3);
        System.out.println(element2 + " + " + element3 + element4 + " --> " + element2 + " + " + element4 + " + " + element3);
        System.out.println("Молекулярное уравнение");
        System.out.println(element1 + element2 + " + " + element3 + element4 + " >-< нет смысла и реакции "); }
    public static void WeakWeak(){
        System.out.println("Молекулярное уравнение");
        waterEL34();
        replace(); }
    public static void StrWeak() {
        waterEL34();
        br12(charge1, charge2);
        actionBracket();
        senselessly();
        System.out.println("ИДЁМ ПО СЛАБОМУ ЭЛЕКТРОЛИТУ");
        System.out.println("\nКраткое ионное уравнение");
        System.out.println(element2 + " + " + element3 + element4 + " --> " + element3 + element2 + " + " + element4);
        System.out.println("\nПолное ионное уравнение");
        System.out.println(element2 + " + " + element3 + element4 + " + " + element1 + " --> " + element3 + element2 + " + " + element1 + element4);
        System.out.println("\nМолекулярное уравнение");
        //нужны ступени
        System.out.print(element1 + index[1] + element2 + index[2] + " + " + element3 + element4 + element1 + " --> ");
        System.out.println(element1 + index[1] + element3 + element2 + index[2] + " + " + element1 + element4);
    }
    public static void WeakStr() {
        System.out.println("Краткое ионное уравнение");

        System.out.println("Полное ионное уравнение");

        System.out.println("Молекулярное уравнение");

    }
    public static void waterEL34() {
        //третье вещество
        choice = 1; choice--;
        index[3] = 2;
        element3 = Base.Name(choice);
        charge3 = Base.Charge(choice);
        power3 = Base.Power(choice);
        //четвертое вещество
        choice = 13; choice--;
        index[4] = 1;
        element4 = Base.Name(choice);
        charge4 = Base.Charge(choice);
        choice = 0; }

    //bracket
    public static void br12(int charge1, int charge2) /*разрешение12*/{
        if (((charge1 == 2) || (charge1 == 3)) && (charge2 == 1)) { bracket[2] = true; }
        if ((charge1 == 3) && (charge2 == 2)) { bracket[2] = true; }
        if ((charge1 == 2) && (charge2 == 3)) { bracket[2] = true; }
        if ((element2 == "Br") || (element2 == "Cl") || (element2 == "F") || (element2 == "I")) { bracket[2] = false; } }
    public static void br34(int charge3, int charge4) /*разрешение34*/{
        if (((charge3 == 2) || (charge3 == 3)) && (charge4 == 1)) { bracket[4] = true; }
        if ((charge3 == 3) && (charge4 == 2)) { bracket[4] = true; }
        if ((charge3 == 2) && (charge4 == 3)) { bracket[4] = true; }
        if ((element4 == "Br") || (element4 == "Cl") || (element4 == "F") || (element4 == "I")) { bracket[4] = false; } }
    public static void br14(int charge1, int charge4) /*разрешение14*/{
        if (((charge1 == 2) || (charge1 == 3)) && (charge4 == 1)) { bracket[6] = true; }
        if ((charge1 == 3) && (charge4 == 2)) { bracket[6] = true; }
        if ((charge1 == 2) && (charge4 == 3)) { bracket[6] = true; }
        if ((element4 == "Br") || (element4 == "Cl") || (element4 == "F") || (element4 == "I")) { bracket[6] = false; } }
    public static void br32(int charge3, int charge2) /*разрешение32*/{
        if (((charge3 == 2) || (charge3 == 3)) && (charge2 == 1)) { bracket[8] = true; }
        if ((charge3 == 3) && (charge2 == 2)) { bracket[8] = true; }
        if ((charge3 == 2) && (charge2 == 3)) { bracket[8] = true; }
        if ((element2 == "Br") || (element2 == "Cl") || (element2 == "F") || (element2 == "I")) { bracket[8] = false; } }
    public static void balance_3(int chargeX, int chargeY) {
        if (chargeX != chargeY) {
            index[5] *= chargeY;
            index[6] *= chargeX;} }
    public static void balance_4(int chargeX, int chargeY) {
        if (chargeX != chargeY) {
            index[7] *= chargeY;
            index[8] *= chargeX;} }
    public static void includeBracketNH4() /*Активация скобокNH4*/{
        if (element1 == Base.Name(11) && charge2 != 1) { bracket[1] = true; }
        if (element3 == Base.Name(11) && charge4 != 1) { bracket[3] = true; }
        if (element1 == Base.Name(11) && charge4 != 1) { bracket[5] = true; }
        if (element3 == Base.Name(11) && charge2 != 1) { bracket[7] = true; } }
    public static void actionBracket() /*Активация скобок*/{
        if (bracket[1]) { br[1] = "("; br[2] = ")"; }//только для NH4
        if (bracket[2]) { br[3] = "("; br[4] = ")"; }
        if (bracket[3]) { br[5] = "("; br[6] = ")"; }//только для NH4
        if (bracket[4]) { br[7] = "("; br[8] = ")"; }
        if (bracket[5]) { br[9] = "("; br[10] = ")"; }//только для NH4
        if (bracket[6]) { br[11] = "("; br[12] = ")"; }
        if (bracket[7]) { br[13] = "("; br[14] = ")"; }//только для NH4
        if (bracket[8]) { br[15] = "("; br[16] = ")"; } }
    public static void senselessly() /*чистка безсмысленных 1*/{
        str1 = Integer.toString(STR1); if (str1.equals("1")) { str1 = ""; }
        str2 = Integer.toString(STR2); if (str2.equals("1")) { str2 = ""; }
        str3 = Integer.toString(STR3); if (str3.equals("1")) { str3 = ""; }
        str4 = Integer.toString(STR4); if (str4.equals("1")) { str4 = ""; }
        idx1 = Integer.toString(index[1]); if (idx1.equals("1")) { idx1 = ""; }
        idx2 = Integer.toString(index[2]); if (idx2.equals("1")) { idx2 = ""; }
        idx3 = Integer.toString(index[3]); if (idx3.equals("1")) { idx3 = ""; }
        idx4 = Integer.toString(index[4]); if (idx4.equals("1")) { idx4 = ""; }
        idx5 = Integer.toString(index[5]); if (idx5.equals("1")) { idx5 = ""; }
        idx6 = Integer.toString(index[6]); if (idx6.equals("1")) { idx6 = ""; }
        idx7 = Integer.toString(index[7]); if (idx7.equals("1")) { idx7 = ""; }
        idx8 = Integer.toString(index[8]); if (idx8.equals("1")) { idx8 = ""; } }

    //коэффценты
    public static void checkAnion() {
        //проверка element2(2) и element8(2)
        index[0] = index[2] * index[8];
        STR1 = index[0]/index[2];
        STR4 = index[0]/index[8];
        //проверка element4(4) и element6(4)
        index[0] = index[4] * index[6];
        STR2 = index[0]/index[4];
        STR3 = index[0]/index[6]; }
    public static void checkKation() {
        //проверка element1(1) и element5(1)
        index[0] = Math.max(index[1] * STR1, index[5] * STR3);
        STR1 = index[0]/index[1];
        STR3 = index[0]/index[5];
        //проверка element3(3) и element7(3)
        index[0] = Math.max(index[3] * STR2, index[7] * STR4);
        STR2 = index[0]/index[3];
        STR4 = index[0]/index[7];}
    public static void kation() {
        index[4] *= charge2; index[5] *= charge3;
        if (element1.equals(Base.Name(0))) { index[6] = 2; }//чтобы 3H2 а не 6H
        pot1 = STR1 * index[1];
        pot2 = STR1 * index[2];
        pot3 = STR2 * index[3];
        pot4 = STR3 * index[4];
        pot5 = STR3 * index[5];
        pot6 = STR4 * index[6];
        if (pot2 != pot5) { STR1 *= pot5; STR3 *= pot2; }
        if (pot3 != pot4) { STR2 = STR2 *(pot4 / index[3]); STR4 = STR2 *(pot3 / index[6]); }
        pot4 = STR3 * index[4]; STR2 = pot4 / index[3];
        pot1 = STR1 * index[1]; STR4 = pot1 / index[6]; }
    public static void anion() {
        index[4] *= charge3; index[5] *= charge1;
        //if (element2 == Base.Name(14)) { index6 = 2; }//чтобы Cl2 а не 2Cl
        if (index[1] == index[4]) { STR2 = index[5]; STR4 = index[2]; }
        if (index[1] > index[4]) {
            pot1 = STR1 * index[1]; STR3 = pot1;
            pot5 = STR3 * index[5]; STR2 = pot5 / index[3];
            pot2 = STR1 * index[2]; STR4 = pot2 / index[6]; }
        if (index[1] < index[4]) {
            pot4 = STR3 * index[4]; STR1 = pot4;
            pot5 = STR3 * index[5]; STR2 = pot5 / index[3];
            pot2 = STR1 * index[2]; STR4 = pot2 / index[6]; } }

    //Функции на время отсуцтвия ввода букв
    public static void GetFS() {
        System.out.print("Введите первое вещество > ");
        choice = word.nextInt(); choice--;
        System.out.print("Индекс > ");
        index[1] = word.nextInt();
        element1 = Base.Name(choice);
        charge1 = Base.Charge(choice);
        power1 = Base.Power(choice);
        System.out.println("Element1: " + element1 + TAB + "Charge1: " + charge1);
        choice = 0;
    }
    public static void GetSS() {
        System.out.print("Введите второе вещество > ");
        choice = word.nextInt(); choice--;
        System.out.print("Индекс > ");
        index[2] = word.nextInt();
        element2 = Base.Name(choice);
        charge2 = Base.Charge(choice);
        power2 = Base.Power(choice);
        System.out.println("Element2: " + element2 + TAB + "Charge2: " + charge2);
        choice = 0;
    }
    public static void GetTS() {
        System.out.print("Введите третье вещество > ");
        choice = word.nextInt(); choice--;
        System.out.print("Индекс > ");
        index[3] = word.nextInt();
        element3 = Base.Name(choice);
        charge3 = Base.Charge(choice);
        power3 = Base.Power(choice);
        System.out.println("Element3: " + element3 + TAB + "Charge3: " + charge3);
        choice = 0;
    }
    public static void GetFthS() {
        System.out.print("Введите четвертое вещество > ");
        choice = word.nextInt(); choice--;
        System.out.print("Индекс > ");
        index[4] = word.nextInt();
        element4 = Base.Name(choice);
        charge4 = Base.Charge(choice);
        power4 = Base.Power(choice);
        System.out.println("Element4: " + element4 + TAB + "Charge4: " + charge4);
        choice = 0;
    }


    public static void mainHydrolysis() {
        Intro.Line();
        Intro.Table_2();
        System.out.println("         AB + H2O;");
        System.out.println("Гидролиз - обратимое взаимодействие соли с водой, приводящее к");
        System.out.println("           изменению соотношения концентрации H+ и OH-");
        GetFS();
        GetSS();
        br12(charge1, charge2);
        actionBracket();
        senselessly();
        //показывает силу и указывает на тип реакции
        Intro.InfoAboutSalt();
        /*pH*/System.out.println(auxiliary);}
    public static void mainOVR() {}
    public static void mainEquation()/*уравнения*/{
        Intro.Line();
        String tab = "\t";
        System.out.print("1 - присоединение" + tab + "2 - разложение" + tab + tab);
        System.out.println("3 - замещение" + tab + tab + "4 - обмен");
        System.out.print("Выберите тип хим. реакции> ");
        int choice = word.nextInt();
        Intro.Line();
        switch (choice) {
            case 1: Intro.Table_1(); joining(); break;
            case 2: Intro.Table_2(); destruction(); break;
            case 3: Intro.Table_2(); exchange(); break;
            case 4: Intro.Table_2(); {
                GetFS();  //первое в-во
                GetSS();  //второе в-во
                GetTS();  //третье в-во
                GetFthS();//четвертое в-во
                replace(); break; }
            default: System.out.println("ЕЩЁ РАЗ!!!"); break; }
    }
}