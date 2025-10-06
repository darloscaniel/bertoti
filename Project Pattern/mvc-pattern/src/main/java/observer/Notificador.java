package observer;

import java.util.ArrayList;
import java.util.List;

public class Notificador {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) { observers.add(o); }
    public void removeObserver(Observer o) { observers.remove(o); }

    public void notificar(String msg) {
        for (Observer o : observers) o.update(msg);
    }
}
