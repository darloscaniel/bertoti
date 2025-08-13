public class Permitido implements Emprestimo{
    @Override
    public void emprestar(Double valor){
        System.out.println("Emrestimo aprovado no valor : " + valor);
    }
}