public class DeleteStrategy implements ActionStrategy {

    @Override
    public void execute(Model model) {
        model.setState("Deleted!");
    }
}