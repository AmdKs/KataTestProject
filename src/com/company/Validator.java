package com.company;

import static com.company.RomanNums.isRoman;

public class Validator {

    private static String[] operant = new String[]{"+", "-", "*", "/"};

    public static void validateExpression(String expression){
        String[] values = expression.split("\\W");
        if (expression.split("\\W").length > 2){
            throw new NumberFormatException("В выражении больше двух операндов");
        }
        boolean isValid = isRoman(values[0]) && isRoman(values[1]) || !isRoman(values[0]) && !isRoman(values[1]);
        if (!isValid){
            throw new NumberFormatException("Неверная строка");
        }
    }

    public static int validateNums(String nums) {

        int a = Integer.parseInt(nums);
        if (a < 0 || a > 10) {
            throw new NumberFormatException("Не верный формат числа");

        }
        return a;


    }

    public static void validateOper(String oper) {

        for (String s : operant) {

            if (s.equals(oper)) {
                return;
            }

        }
        throw new UnsupportedOperationException("Операция не поддерживается");

    }
}
