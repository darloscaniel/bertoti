import java.util.ArrayList;
import java.util.List;

public class Model {

    private List<ViewObserver> observers = new ArrayList<>();
    private String state;

    public void addObserver(ViewObserver observer) {
        observers.add(observer);
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    private void notifyObservers() {
        for (ViewObserver observer : observers) {
            observer.update(state);
        }
    }
}