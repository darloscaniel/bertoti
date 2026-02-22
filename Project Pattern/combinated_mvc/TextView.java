public class TextView implements ViewObserver {

    @Override
    public void update(String state) {
        System.out.println("View updated with state: " + state);
    }
}