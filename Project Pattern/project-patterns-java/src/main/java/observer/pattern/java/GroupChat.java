package observer.pattern.java;

import java.util.ArrayList;
import java.util.List;

public class GroupChat {
    

 private List<Observer> users = new ArrayList<>();

    public void addUser(Observer user) {
        users.add(user);
    }

    public void removeUser(Observer user) {
        users.remove(user);
    }

    public void sendMessage(String msg) {
        System.out.println("Mensagem no grupo: " + msg);
        for (Observer u : users) {
            u.update(msg);
        }
    }
}
