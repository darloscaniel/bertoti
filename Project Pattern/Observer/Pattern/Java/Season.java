import java.util.ArrayList;
import java.util.List;


public class Season {

    double temperatura = 10.5;
    double umidade = 85.0;
    double pressao = 1013.25;

    List<Observador> observadores = new ArrayList<>();

    public void addObserver(Observer o) {
        observadores.add(o);
    }

    public void notificar(){
        for(Observador observador:observadores){
            observador.atualizar(temperatura, umidade,pressao);
        }
    }

    public static void main(String[] args) {
        Estacao estacao = new Estacao();

        estacao.addObservador(new Historico());
        estacao.addObservador(new Previsao());

        estacao.notificar();
    }//fechado para modificação, aberto extenção
}