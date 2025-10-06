package model;

public class Saque implements Operacao {
    @Override
    public void executar(double valor, Cliente cliente) {
        System.out.println(cliente.getNome() + " realizou saque de R$" + valor);
    }
}
