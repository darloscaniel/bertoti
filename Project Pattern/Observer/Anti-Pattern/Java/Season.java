public class Season {
    public static void main(String[] args) {

        double temperatura = 25.0;
        double umidade = 60.0;
        double pressao = 1013.0;

        Previsao.atualizar(temperatura, umidade, pressao);
        Historico.atualizar(temperatura, umidade, pressao);
    }
}

// Acomplamento - Classe concreta sendo referenciada e toda vez que
// acrescentar uma nova temos que citar a classe concreta nominalmente,
// é uma ligação forte que causa duplicação de código toda vez que alterar
// uma classe, tem que alterar outra