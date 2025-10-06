package strategy.antipattern.inheritance.java;

public class Comum extends Cliente{

    private Double rendaMensal;

    @Override
    public void emprestar(Double valor) {
        System.out.println("Emprestimo aprovado no valor de:" + valor + "com taxa de 5%");
    }

    @Override
    public void sacar(Double valor) {
        System.out.println("Saque aprovado no valor de: " + valor);
    }

    public Double getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(Double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    
}