package view;

import controller.BancoController;
import model.*;

public class BancoView {
    public static void main(String[] args) {
        Comum c1 = new Comum("Carlos");
        Estudante e1 = new Estudante("Ana");

        GrupoClientes grupo = new GrupoClientes("Grupo VIP");
        grupo.add(c1);
        grupo.add(e1);

        BancoController controller = new BancoController();
        System.out.println("=== Operações Individuais ===");
        controller.aplicarOperacoes(c1);
        controller.aplicarOperacoes(e1);

        System.out.println("\n=== Operações em Grupo ===");
        controller.aplicarOperacoesGrupo(grupo);

        System.out.println("\n=== Notificações ===");
        grupo.update("Nova política de juros disponível!");
    }
}
