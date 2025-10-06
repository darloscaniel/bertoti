package model;

public class Emprestimo implements Operacao {
    @Override
    public void executar(double valor, Cliente cliente) {
        System.out.println(cliente.getNome() + " recebeu empréstimo de R$" + valor);
    }
}
    

