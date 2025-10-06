package strategy.pattern.polymorphism.java;

public class Sum implements Operation{
    public int execute(int a, int b) {
        return a + b;
    }
}
