package strategy.antipattern.inheritance.java;

public abstract class Cliente{

    private String nome;
    private Double saldo;

    public abstract void emprestar(Double valor);

    public abstract void sacar(Double valor);

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    

}