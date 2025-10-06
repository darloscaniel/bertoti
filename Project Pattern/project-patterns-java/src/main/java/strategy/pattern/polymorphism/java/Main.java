package strategy.pattern.polymorphism.java;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        calc.setOperation(new Sum());
        System.out.println("Soma: " + calc.calcular(10, 5));

        calc.setOperation(new Subtraction());
        System.out.println("Subtração: " + calc.calcular(10, 5));
    }
}