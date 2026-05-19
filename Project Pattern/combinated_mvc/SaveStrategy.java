public class SaveStrategy implements ActionStrategy {

    @Override
    public void execute(Model model) {
        model.setState("Saved!");
    }
}