package strategy.antipattern.inheritance.java;

public class Aposentado extends Cliente{
    private int Idade;

    public void emprestar(Double valor){
        System.out.println("Emprestimo aprovado no valor :" + valor + "com taxa de 2% aa");
    }

    @Override
    public void sacar(Double valor) {
        System.out.println("Saque aprovado no valor de: " + valor);
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        Idade = idade;
    }

}
