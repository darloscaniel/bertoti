package model;

public class Estudante implements Cliente {
    private String nome;
    private Operacao operacao;

    public Estudante(String nome) { this.nome = nome; }

    @Override
    public void setOperacao(Operacao op) { this.operacao = op; }

    @Override
    public void executarOperacao(double valor) {
        if (operacao != null) operacao.executar(valor, this);
    }

    @Override
    public void update(String msg) {
        System.out.println("Estudante " + nome + " recebeu notificação: " + msg);
    }

    @Override
    public String getNome() { return nome; }
}