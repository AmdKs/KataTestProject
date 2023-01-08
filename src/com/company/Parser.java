package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.company.RomanNums.convertExpression;
import static com.company.RomanNums.isRoman;

public class Parser {

    private int x;
    private int y;
    private String operator;
    private boolean isRoman = false;
    public Parser(String input) {
        Validator.validateExpression(input);

        if (isRoman(input)){
            input = convertExpression(input);
            isRoman = true;
        }

        String[] nums = input.split("\\W");

        Pattern pattern = Pattern.compile("\\W");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()){
            this.operator = matcher.group();
        }

        Validator.validateOper(operator);
        x = Validator.validateNums(nums[0]);
        y = Validator.validateNums(nums[1]);

    }

    public boolean getIsRoman() {
        return isRoman;
    }

    public int getX(){
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String getOperator() {
        return this.operator;
    }
}
