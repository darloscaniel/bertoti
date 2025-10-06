package strategy.pattern.polymorphism.java;

public class Subtraction implements Operation{
    public int execute(int a, int b) {
        return a - b;
    }
}