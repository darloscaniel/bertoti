package strategy.antipattern.inheritance.java;

public class Empresa extends Cliente{
    private String CNPJ;

    public void emprestar(Double valor){

        System.out.println("Emprestimo aprovado no valor de : " + valor + "para o CNPJ " + this.CNPJ + "com taxa de 5% aa");
        
    }

    @Override
    public void sacar(Double valor) {
        System.out.println("Saque indisponível pra conta empresa");
    }
}