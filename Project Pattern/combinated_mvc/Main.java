public class Main {

    public static void main(String[] args) {

        // Model
        Model model = new Model();

        // View (Observer)
        TextView view = new TextView();
        model.addObserver(view);

        // View (Composite)
        Panel root = new Panel();
        root.add(new Button("Save"));
        root.add(new Button("Delete"));

        root.render();

        // Controller (Strategy)
        Controller controller = new Controller(new SaveStrategy());

        controller.handle(model); // Atualiza model → notifica view

        controller.setStrategy(new DeleteStrategy());
        controller.handle(model);
    }
}