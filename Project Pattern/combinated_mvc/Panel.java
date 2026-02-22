import java.util.ArrayList;
import java.util.List;

public class Panel implements ViewComponent {

    private List<ViewComponent> children = new ArrayList<>();

    public void add(ViewComponent component) {
        children.add(component);
    }

    @Override
    public void render() {
        for (ViewComponent child : children) {
            child.render();
        }
    }
}