public class Proibido implements Emprestimo{
    @Override
    public void emprestar(Double valor){
        System.out.println("Emprestimo não disponível para sua conta.")
    }
}