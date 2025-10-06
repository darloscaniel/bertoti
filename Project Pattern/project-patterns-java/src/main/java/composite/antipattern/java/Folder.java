package composite.antipattern.java;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String name;
    private List<Object> children = new ArrayList<>(); 

    public Folder(String name) {
        this.name = name;
    }

    public void add(Object o) {
        children.add(o);
    }

    public void show(String indent) {
        System.out.println(indent + "+ Pasta: " + name);
        for (Object o : children) {

            if (o instanceof File) {
                File f = (File) o;
                System.out.println(indent + "   - Arquivo: " + f.getName());
            } else if (o instanceof Folder) {
                Folder folder = (Folder) o;
                folder.show(indent + "   ");
            }
        }
    }
}
