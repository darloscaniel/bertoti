public class History implements Observer{
    @Override
    public void atualizar(double temperatura, double umidade, double pressao) {
        System.out.println("Histórico de temperatura: " + temperatura +
                ", umidade: " + umidade +
                ", pressão: " + pressao);
    }
}