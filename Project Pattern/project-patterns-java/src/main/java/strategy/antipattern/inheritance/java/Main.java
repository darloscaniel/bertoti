package strategy.antipattern.inheritance.java;

public class Main {
    public static void main(String[] args) {

        Comum comum = new Comum();
        comum.setNome("Carlos");
        comum.setSaldo(2000.0);
        comum.setRendaMensal(3000.0);
        System.out.println("Cliente Comum: " + comum.getNome());
        comum.emprestar(1000.0);
        comum.sacar(500.0);

        System.out.println("----------------------------");


        Estudante estudante = new Estudante();
        estudante.setNome("Ana");
        estudante.setInstituição("USP");
        estudante.setSaldo(500.0);
        System.out.println("Estudante: " + estudante.getNome() + " - " + estudante.getInstituição());
        estudante.emprestar(200.0);
        try {
            estudante.sacar(100.0); 
        } catch (UnsupportedOperationException e) {
            System.out.println("Erro ao sacar para estudante: " + e.getMessage());
        }

        System.out.println("----------------------------");

        // Empresa
        Empresa empresa = new Empresa();
        empresa.setNome("OpenAI LTDA");
        empresa.setSaldo(10000.0);
        System.out.println("Empresa: " + empresa.getNome());
        empresa.emprestar(5000.0);
        empresa.sacar(1000.0);

        System.out.println("----------------------------");

        Aposentado aposentado = new Aposentado();
        aposentado.setNome("João");
        aposentado.setIdade(70);
        aposentado.setSaldo(1500.0);
        System.out.println("Aposentado: " + aposentado.getNome() + " - " + aposentado.getIdade() + " anos");
        aposentado.emprestar(800.0);
        aposentado.sacar(200.0);
    }
}
