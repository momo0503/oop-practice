package org.example;

import java.util.Arrays;

public enum ArithmeticOperator {
    ADDITION("+"){ // 추상메서드의 구현체
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    },SUBTRACTION("-"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return  operand1 - operand2;
        }
    },MULTIPLICATION("*"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return  operand1 * operand2;
        }
    },DIVISION("/"){
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return  operand1 / operand2;
        }
    };

    private final String operator;

    ArithmeticOperator(String operator) {
        this.operator = operator;
    }


    public static int calculate(int operand1, String operator, int operand2) { //ArithmeticOperator에서 연산자에 일치하는 enum 값을 가져와 해당하는 메서드 중 하나를 시행 후 결과값을 리턴

        ArithmeticOperator arithmeticOperator = Arrays.stream(values()) //모든 enum 값을 가져옴
                .filter(v -> v.operator.equals(operator))   // enum의 operator가 operator 와같다면
                .findFirst()  //같은것을 가지고온다.
                .orElseThrow(() -> new ArithmeticException("올바른 사칙연산이 아닙니다."));

        return arithmeticOperator.arithmeticCalculate(operand1, operand2);
    }

    //각각의 연산을 수행하고 싶어서 추상메서드 하나 선언
    public abstract int arithmeticCalculate(final int operand1,final int operand2);


}
