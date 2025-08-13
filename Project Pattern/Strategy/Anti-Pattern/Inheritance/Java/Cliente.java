public abstract class Cliente{
    private String nome;
    private Double saldo;

    public abstract void emprestar(Double valor){
        System.out.println("Emprestimo aprovado no valor de :" + valor);
    }

    public abstract void sacar(Double valor){
        System.out.println("Valor sacado: " + valor);
    }
}