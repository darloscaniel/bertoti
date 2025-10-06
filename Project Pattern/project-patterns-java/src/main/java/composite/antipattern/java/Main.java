package composite.antipattern.java;

public class Main {
     public static void main(String[] args) {
        File f1 = new File("a.txt");
        File f2 = new File("b.pdf");

        Folder documentos = new Folder("Documentos");
        documentos.add(f1);
        documentos.add(f2);

        Folder root = new Folder("Meu Computador");
        root.add(documentos);
        root.add(new File("readme.md"));

        root.show("");
    }
}
