package model;

import java.util.ArrayList;
import java.util.List;

// Composite
public class GrupoClientes implements Cliente {
    private String nome;
    private List<Cliente> clientes = new ArrayList<>();

    public GrupoClientes(String nome) { this.nome = nome; }

    public void add(Cliente c) { clientes.add(c); }
    public void remove(Cliente c) { clientes.remove(c); }

    @Override
    public void setOperacao(Operacao op) {
        for (Cliente c : clientes) c.setOperacao(op);
    }

    @Override
    public void executarOperacao(double valor) {
        for (Cliente c : clientes) c.executarOperacao(valor);
    }

    @Override
    public void update(String msg) {
        for (Cliente c : clientes) c.update(msg);
    }

    @Override
    public String getNome() { return nome; }
}
