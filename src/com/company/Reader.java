package com.company;

import java.util.Scanner;

public class Reader {


    public static void start() {
        Scanner scanReader = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String expression = scanReader.nextLine().replaceAll(" ","");

        Parser pars = new Parser(expression);
        Calculation calculator = new Calculation();
        String result = "";
        switch (pars.getOperator()) {

            case "+":
                result = String.valueOf(calculator.add(pars.getX(), pars.getY()));
                break;

            case "-":
                result = String.valueOf(calculator.minus(pars.getX(), pars.getY()));
                break;

            case "*":
                result = String.valueOf(calculator.multiply(pars.getX(), pars.getY()));
                break;

            case "/":
                result = String.valueOf(calculator.divide(pars.getX(), pars.getY()));
                break;
        }
        if (pars.getIsRoman()){
            result = RomanNums.convertToRoman(Integer.parseInt(result));
        }
        System.out.println(result);
    }


}
