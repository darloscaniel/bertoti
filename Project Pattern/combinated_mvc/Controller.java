public class Controller {

    private ActionStrategy strategy;

    public Controller(ActionStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ActionStrategy strategy) {
        this.strategy = strategy;
    }

    public void handle(Model model) {
        strategy.execute(model);
    }
}