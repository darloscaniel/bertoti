package composite.pattern.java;

public class Main {
    public static void main(String[] args) {

        File file1 = new File("a.txt");
        File file2 = new File("b.pdf");
        File file3 = new File("c.docx");

        Folder folder1 = new Folder("Documentos");
        folder1.add(file1);
        folder1.add(file2);

        Folder folder2 = new Folder("Projetos");
        folder2.add(file3);


        Folder root = new Folder("Meu Computador");
        root.add(folder1);
        root.add(folder2);
        root.add(new File("readme.md"));


        root.show("");
    }

}
