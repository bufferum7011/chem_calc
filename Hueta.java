package com.gen_5_new;

import static java.lang.Integer.*;

public class Hueta {
    //Глобальные переменные
    public static boolean H2 = false, pass = true, allowed = false;
    public static String element1 = "", element2 = "", element3 = "", element4 = "",
            h2o = "H2 + 2OH --> 2H2O", h2o2 = "2H2O --> 2H2 + O2", tab = "\t",
            pH1 = "pH = 7", pH2 = "pH > 7", pH3 = "pH < 7", auxiliary, answer = "ура",
            str1, str2, str3, str4, idx1, idx2, idx3, idx4, idx5, idx6, idx7, idx8;
    public static int[] index = { 0, 1, 1, 1, 1, 1, 1, 1, 1 };
    public static int choice;
    public static int[] charge = { 0, 1, 1, 1, 1 };
    private static int[] STR = { 0, 1, 1, 1, 1 };
    private static String[] br = { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };
    private static boolean[] bracket = {false, false, false, false, false, false, false, false, false};

    //answer
    public static void AnswerJoining() {
        if (!H2) {
            answer  = str1 + element1 + idx1 + " + " + str2 + element2 + idx2 + " --> "
                    + str3 + br[1] + element1 + br[2] + idx3 + br[3] + element2 + br[4] + idx4; }
        else { answer = h2o; }
    }
    public static void AnswerDestruction() {
        if (!H2) {
            answer  = str1 + br[1] + element1 + br[2] + idx1 + br[3] + element2 + br[4] + idx2 + " --> "
                    + str2 + element1 + idx3 + " + " + str3 + element2 + idx4; }
        else { answer = h2o2 ; }
    }
    public static void AnswerExchange() {
        if (pass) {//по катиону
            answer = str1 + br[1] + element1 + br[2] + idx1 + br[3] + element2 + br[4] + idx2 + " + " + str2 + element3 + idx3 + " --> "
                   + str3 + br[5] + element3 + br[6] + idx4 + br[7] + element2 + br[8] + idx5 + " + " + str4 + element1 + idx6; }
        else {//по аниону
            answer = str1 + br[1] + element1 + br[2] + idx1 + br[3] + element2 + br[4] + idx2 + " + " + str2 + element3 + idx3 + " --> "
                   + str3 + br[5] + element1 + br[6] + idx4 + br[7] + element3 + br[8] + idx5 + " + " + str4 + element2 + idx6; }
    }
    public static void AnswerReplace() { answer
            = str1 + br[1]  + element1 + br[2]  + idx1 + br[3]  + element2 + br[4]  + idx2 + " + "
            + str2 + br[5]  + element3 + br[6]  + idx3 + br[7]  + element4 + br[8]  + idx4 + " --> "
            + str3 + br[9]  + element1 + br[10] + idx5 + br[11] + element4 + br[12] + idx6 + " + "
            + str4 + br[13] + element3 + br[14] + idx7 + br[15] + element2 + br[16] + idx8;
    }
    public static void AnswerHydrolysis() {

        waterEL34();

        answer = "Гидролиз ещё не готов!!!";

    }
    public static void Inference() {//по типу хоро реагирует или нет, pH,
    }

    //типы реакций
    public static void joining() {
        GetFS();//первое в-во
        GetSS();//второе в-во

        //расчет коэффицентов и скобок
        if (charge[1] == charge[2]) {
            if (index[1] == 1 && index[2] == 2) { STR[1] = index[2] = STR[3]; }//K+Cl2
            if (index[1] == 2 && index[2] == 1) { STR[2] = 2; STR[3] = 2; }//H2+NO3
            if (index[1] == 2 && index[2] == 2) { STR[3] = 2; } }//H2+Cl2
        if (charge[1] == 1 && charge[2] == 2 || charge[2] == 3) { index[3] = charge[2]; STR[1] = charge[2]; }
        if (charge[1] == 2 && charge[2] == 1) { index[4] = charge[1]; bracket[2] = true; }
        if (charge[1] == 2 && charge[2] == 3) { STR[1] = index[3] *= charge[2]; STR[2] = index[4] *= charge[1]; bracket[2] = true; }
        if (charge[1] == 3 && charge[2] == 2)  { STR[1] = index[3] *= charge[2]; STR[2] = index[4] *= charge[1]; bracket[2] = true; }
        if (charge[1] == 3 && charge[2] == 1) { if (index[1] == 3 && index[2] == 2) { STR[1] *= index[2]; STR[3] *= index[2]; } }

        //скобки и обработка случаев
        if (Base.Name(11) == element1 && charge[2] > 1) { bracket[1] = true; }//скобки только для NH4
        if (Base.Name(12) == element1 && charge[1] >= 1) { bracket[2] = true; }//скобки только для OH
        if (element1 == Base.Name(0) && element2 == Base.Name(19)) { H2 = true; }// + OH
        if (element1 == Base.Name(0) && element2 == Base.Name(1)) { STR[3] = 2; }// + O2
        actionBracket();
        senselessly();//чистка бессмысленных 1

        //вывод данных
        AnswerJoining(); }
    public static void destruction() {
        //Al2(SiO3)3
        GetFS();//первое в-во
        GetSS();//второе в-во

        //расчет коэффицентов
        if (charge[1] == charge[2]) {
            if (index[1] == 1 && index[2] == 1) { index[3] = 1; index[4] = 1; }
            if (index[1] == 1 && index[2] == 2) { STR[1] = index[2]; STR[3] = index[2]; }
            if (index[1] == 2 && index[2] == 1) { index[3] = 1; index[4] = 1; STR[2] = 2; STR[3] = 2; }
            if (index[1] == 2 && index[2] == 2) { index[3] = 1; index[4] = 1; STR[3] = 2; } }
        if (charge[1] == 1 && charge[2] == 2 || charge[2] == 3) { STR[2] = charge[2]; }
        if (charge[1] == 2 && charge[2] == 1) {
            bracket[2] = true; STR[3] = index[2];
            if (element2.equals("Br") || element2.equals("Cl") || element2.equals("F") || element2.equals("I")) { bracket[2] = false; } }
        if (charge[1] == 3 && charge[2] == 1) {
            bracket[2] = true; STR[3] *= charge[1];
            if (element2 == ("Br") || element2 == ("Cl") || element2 == ("F") || element2 == ("I")) { bracket[2] = false; } }
        if (charge[1] == 2 && charge[2] == 3) { bracket[2] = true; STR[2] = index[1]; STR[3] = index[2]; }
        if (charge[1] == 3 && charge[2] == 2) { bracket[2] = true; STR[2] = index[1]; STR[3] = index[2]; }


        //скобки
        if (element1.equals(Base.Name(0)) && element2.equals(Base.Name(1))) { H2 = true; }// H2O -->
        includeBracketNH4();
        actionBracket();
        senselessly();//чистка бессмысленных 1

        //вывод
        AnswerDestruction(); }
    public static void exchange() {
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
        AnswerExchange(); }
    public static void replace() {System.out.println("зашел в реплейс");
        GetFS();
        GetSS();
        GetTS();
        GetFthS();

        //индексы
        balance_3(charge[1], charge[4]);
        balance_4(charge[3], charge[2]);

        //коэффиценты
        checkAnion();//суть уравнть коэффиценты
        checkKation();

        //скобки
        if (element1 == Base.Name(12) && element2 == Base.Name(1)) { H2 = true; }// H2O -->
        includeBracketNH4();
        br12();//charge[1], charge[2]
        br34();//charge[3], charge[4]
        br14();//charge[1], charge[4]
        br32();//charge[3], charge[2]
        actionBracket();
        senselessly();//чистка бессмысленных 1

        //вывод
        AnswerReplace();

        //TODO ДОДЕЛАТЬ pH
        //таблица растворимости и ответ о качестве реакции
//        Base.TableSolution(element1, element4);
//        Base.TableSolution(element3, element2);
//        if(element1 == element3) { allowed = false; }
//        if(element2 == element4) { allowed = false; }

    }

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
        br12();
        actionBracket();
        senselessly();
        System.out.println("ИДЁМ ПО СЛАБОМУ ЭЛЕКТРОЛИТУ"); // TODO НЕ доделаный гидролиз
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
        System.out.println("Краткое ионное уравнение");//TODO НЕ доделаный гидролиз

        System.out.println("Полное ионное уравнение");

        System.out.println("Молекулярное уравнение");

    }
    public static void waterEL34() /*авто_ввод*/{
        //install water for hydrolysis
        //третье вещество
        index[3] = 2;
        element3 = Base.Name(0);
        charge[3] = Base.Charge(0);
        power[3] = Base.Power(0);
        //четвертое вещество
        index[4] = 1;
        element4 = Base.Name(12);
        charge[4] = Base.Charge(12);
        choice = 0; }
    public static void pH() /*разпределение*/{
        if((power[1]) && (power[2]))  { auxiliary = pH1; StrStr();  }
        if((!power[1]) && (!power[2])){ auxiliary = pH1; WeakWeak();}
        if((power[1]) && (!power[2])) { auxiliary = pH2; StrWeak(); }
        if((!power[1]) && (power[2])) { auxiliary = pH3; WeakStr(); }  }

    //bracket
    public static void br12() /*разрешение12*/{
        if (((charge[1] == 2) || (charge[1] == 3)) && (charge[2] == 1)) { bracket[2] = true; }
        if ((charge[1] == 3) && (charge[2] == 2)) { bracket[2] = true; }
        if ((charge[1] == 2) && (charge[2] == 3)) { bracket[2] = true; }
        if ((element2 == "Br") || (element2 == "Cl") || (element2 == "F") || (element2 == "I")) { bracket[2] = false; } }
    public static void br34() /*разрешение34*/{
        if (((charge[3] == 2) || (charge[3] == 3)) && (charge[4] == 1)) { bracket[4] = true; }
        if ((charge[3] == 3) && (charge[4] == 2)) { bracket[4] = true; }
        if ((charge[3] == 2) && (charge[4] == 3)) { bracket[4] = true; }
        if ((element4 == "Br") || (element4 == "Cl") || (element4 == "F") || (element4 == "I")) { bracket[4] = false; } }
    public static void br14() /*разрешение14*/{
        if (((charge[1] == 2) || (charge[1] == 3)) && (charge[4] == 1)) { bracket[6] = true; }
        if ((charge[1] == 3) && (charge[4] == 2)) { bracket[6] = true; }
        if ((charge[1] == 2) && (charge[4] == 3)) { bracket[6] = true; }
        if ((element4 == "Br") || (element4 == "Cl") || (element4 == "F") || (element4 == "I")) { bracket[6] = false; } }
    public static void br32() /*разрешение32*/{
        if (((charge[3] == 2) || (charge[3] == 3)) && (charge[2] == 1)) { bracket[8] = true; }
        if ((charge[3] == 3) && (charge[2] == 2)) { bracket[8] = true; }
        if ((charge[3] == 2) && (charge[2] == 3)) { bracket[8] = true; }
        if ((element2 == "Br") || (element2 == "Cl") || (element2 == "F") || (element2 == "I")) { bracket[8] = false; } }
    public static void balance_3(int chargeX, int chargeY) {
        if (chargeX != chargeY) {
            index[5] *= chargeY;
            index[6] *= chargeX; } }
    public static void balance_4(int chargeX, int chargeY) {
        if (chargeX != chargeY) {
            index[7] *= chargeY;
            index[8] *= chargeX;} }
    public static void includeBracketNH4() /*Активация скобокNH4*/{
        if (element1 == Base.Name(11) && charge[2] != 1) { bracket[1] = true; }
        if (element3 == Base.Name(11) && charge[4] != 1) { bracket[3] = true; }
        if (element1 == Base.Name(11) && charge[4] != 1) { bracket[5] = true; }
        if (element3 == Base.Name(11) && charge[2] != 1) { bracket[7] = true; } }
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
        str1 = Integer.toString(STR[1]);    if (str1.equals("1")) { str1 = ""; }
        str2 = Integer.toString(STR[2]);    if (str2.equals("1")) { str2 = ""; }
        str3 = Integer.toString(STR[3]);    if (str3.equals("1")) { str3 = ""; }
        str4 = Integer.toString(STR[4]);    if (str4.equals("1")) { str4 = ""; }
        idx1 = Integer.toString(index[1]);  if (idx1.equals("1")) { idx1 = ""; }
        idx2 = Integer.toString(index[2]);  if (idx2.equals("1")) { idx2 = ""; }
        idx3 = Integer.toString(index[3]);  if (idx3.equals("1")) { idx3 = ""; }
        idx4 = Integer.toString(index[4]);  if (idx4.equals("1")) { idx4 = ""; }
        idx5 = Integer.toString(index[5]);  if (idx5.equals("1")) { idx5 = ""; }
        idx6 = Integer.toString(index[6]);  if (idx6.equals("1")) { idx6 = ""; }
        idx7 = Integer.toString(index[7]);  if (idx7.equals("1")) { idx7 = ""; }
        idx8 = Integer.toString(index[8]);  if (idx8.equals("1")) { idx8 = ""; } }

    //коэффценты
    public static void checkAnion() {
        //проверка element2(2) и element8(2)
        index[0] = index[2] * index[8];
        STR[1] = index[0]/index[2];
        STR[4] = index[0]/index[8];
        //проверка element4(4) и element6(4)
        index[0] = index[4] * index[6];
        STR[2] = index[0]/index[4];
        STR[3] = index[0]/index[6]; }
    public static void checkKation() {
        //проверка element1(1) и element5(1)
        index[0] = Math.max(index[1] * STR[1], index[5] * STR[3]);
        STR[1] = index[0]/index[1];
        STR[3] = index[0]/index[5];
        //проверка element3(3) и element7(3)
        index[0] = Math.max(index[3] * STR[2], index[7] * STR[4]);
        STR[2] = index[0]/index[3];
        STR[4] = index[0]/index[7]; }
    public static void kation() {
        index[4] *= charge[2]; index[5] *= charge[3];
        if (element1.equals(Base.Name(0))) { index[6] = 2; }//чтобы 3H2 а не 6H
        if (STR[1] * index[2] != STR[3] * index[5]) {
            STR[1] *= STR[3] * index[5];
            STR[3] *= STR[1] * index[2]; }
        if (STR[2] * index[3] != STR[3] * index[4]) {
            STR[2] = STR[2] *(STR[3] * index[4] / index[3]);
            STR[4] = STR[2] *(STR[2] * index[3] / index[6]); }
        STR[2] = STR[3] * index[4] / index[3];
        STR[4] = STR[1] * index[1] / index[6]; }
    public static void anion() {
        index[4] *= charge[3]; index[5] *= charge[1];
        //if (element2 == Base.Name(14)) { index6 = 2; }//чтобы Cl2 а не 2Cl
        if (index[1] == index[4]) { STR[2] = index[5]; STR[4] = index[2]; }
        if (index[1] > index[4]) {
            STR[3] = STR[1] * index[1];
            STR[2] = STR[3] * index[5] / index[3];
            STR[4] = STR[1] * index[2] / index[6]; }
        if (index[1] < index[4]) {
            STR[1] = STR[3] * index[4];
            STR[2] = STR[3] * index[5] / index[3];
            STR[4] = STR[1] * index[2] / index[6]; }
    }

    //Функции на время отсуцтвия ввода букв
    public static void GetFS() {
//        choice = Integer.parseInt(Hyd.edit11.getText().toString())-1;
//        index[1] = Integer.parseInt(Hyd.edit12.getText().toString());
        choice = Integer.parseInt(MainActivity.edit1.getText().toString());
        index[1] = Integer.parseInt(MainActivity.edit2.getText().toString());
        element1 = Base.Name(choice);System.out.println(element1);
        charge[1] = Base.Charge(choice);
        weight[1] = Base.Weight(choice);
        power[1] = Base.Power(choice);
        needs[1] = Base.Needs(choice);
    }
    public static void GetSS() {
        choice = parseInt(MainActivity.edit3.getText().toString());
        index[2] = parseInt(MainActivity.edit4.getText().toString());
        element2 = Base.Name(choice);System.out.println(element4);
        charge[2] = Base.Charge(choice);
        weight[2] = Base.Weight(choice);
        power[2] = Base.Power(choice);
        needs[2] = Base.Needs(choice);
    }
    public static void GetTS() {
        choice = parseInt(MainActivity.edit5.getText().toString());
        index[3] = parseInt(MainActivity.edit6.getText().toString());
        element3 = Base.Name(choice);System.out.println(element4);
        charge[3] = Base.Charge(choice);
        weight[3] = Base.Weight(choice);
        power[3] = Base.Power(choice);
        needs[3] = Base.Needs(choice);
    }
    public static void GetFthS() {
        choice = parseInt(MainActivity.edit7.getText().toString());System.out.println(choice);
        index[4] = parseInt(MainActivity.edit8.getText().toString());
        element4 = Base.Name(choice);System.out.println(element4);
        charge[4] = Base.Charge(choice);
        weight[4] = Base.Weight(choice);
        power[4] = Base.Power(choice);
        needs[4] = Base.Needs(choice);
    }
}