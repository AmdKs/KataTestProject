package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum RomanNums {
    I(1),IV(4),V(5), IX(9),X(10), XL(40),L(50),XC(90),C(100);
    private final int value;
    private static final List<RomanNums> list = Arrays.asList(RomanNums.values());

    RomanNums(int value){
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    public static boolean isRoman(String s){
        return s.contains("X") || s.contains("I") || s.contains("V");
    }
    public static String convertExpression(String expression){
        String[] numbers = expression.split("\\W");
        int x = convertToArabic(numbers[0]);
        int y = convertToArabic(numbers[1]);
        return expression.replace(numbers[0], String.valueOf(x)).replace(numbers[1], String.valueOf(y));
    }
    public static int convertToArabic(String num) {
        int i = 0;
        for (RomanNums romanNums : list) {
            if (num.equals(romanNums.toString()))
                return romanNums.getValue();
        }
        int arabicNum = 0;
        Collections.sort(list);
        Collections.reverse(list);
        while ((num.length() > 0) && (i < list.size())) {
            RomanNums symbol = list.get(i);
            if (num.startsWith(symbol.name())) {
                arabicNum += symbol.getValue();
                num = num.substring(symbol.name().length());
            } else {
                i++;
            }
        }
        return arabicNum;

    }
    public static String convertToRoman(int num){
        if (num < 0){
            throw new UnsupportedOperationException("Римское число не может быть отрицательным");
        }
        for (RomanNums romanNums : list) {
            if (num == romanNums.getValue())
                return romanNums.toString();
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        Collections.reverse(list);
        int i = 0;
        while ((num > 0) && (i < list.size())) {
            RomanNums symbol = list.get(i);
            if (symbol.getValue() <= num) {
                sb.append(symbol.name());
                num -= symbol.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}