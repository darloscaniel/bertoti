public class Empresa extends Cliente{
    private String CNPJ;

    public void emprestar(Double valor){
        System.out.println("Emprestimo aprovado no valor de : " + valor + "para o CNPJ " + this.CNPJ + "com taxa de 5% aa");
    }
}