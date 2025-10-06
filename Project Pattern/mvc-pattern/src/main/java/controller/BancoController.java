package controller;

import model.Cliente;
import model.GrupoClientes;
import model.Emprestimo;
import model.Saque;

public class BancoController {
    public void aplicarOperacoes(Cliente cliente) {
        cliente.setOperacao(new Emprestimo());
        cliente.executarOperacao(1000);

        cliente.setOperacao(new Saque());
        cliente.executarOperacao(200);
    }

    public void aplicarOperacoesGrupo(GrupoClientes grupo) {
        grupo.setOperacao(new Emprestimo());
        grupo.executarOperacao(5000);
    }
}
