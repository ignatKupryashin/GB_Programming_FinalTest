import Model.API;
import UI.UI;

public class Main {
    public static void main(String[] args) {
        API api = new API();
        UI ui = new UI(api);
        ui.run();
    }
}