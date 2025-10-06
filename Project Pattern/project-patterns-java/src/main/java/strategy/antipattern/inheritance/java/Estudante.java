package strategy.antipattern.inheritance.java;

public class Estudante extends Cliente{
    
    private String Instituição;

    @Override
    public void emprestar(Double valor) {
        System.out.println("Emprestimo aprovado no valor de :" + valor + "com taxa de 1% aa");
    }

    @Override
    public void sacar(Double valor) {
        System.out.println("Saque aprovado no valor de :" + valor + "com taxa de 1% aa");
        throw new UnsupportedOperationException("Unimplemented method 'sacar'");
    }

    public String getInstituição() {
        return Instituição;
    }

    public void setInstituição(String instituição) {
        Instituição = instituição;
    }


}