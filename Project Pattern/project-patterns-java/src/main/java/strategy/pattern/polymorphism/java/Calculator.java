package strategy.pattern.polymorphism.java;

public class Calculator {
    private Operation operation;

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public int calcular(int a, int b) {
        return operation.execute(a, b);
    }
}