import Controller.HealthyFoodController;
import Model.Customizable;
import View.HealthyFoodView;

public class Main {
    public static void main(String[] args) {
        Customizable.infoRestoran(); // Static method dipanggil dari nama interface.

        HealthyFoodView view = new HealthyFoodView();
        HealthyFoodController controller = new HealthyFoodController(view);

        controller.jalankan();
    }
}
