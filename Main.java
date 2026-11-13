import Controller.HealthyFoodController;
import Model.Customizable;
import View.MahasiswaDataView;


public class Main {
    public static void main(String[] args) {
        MahasiswaDataView view = new MahasiswaDataView();
        HealthyFoodController controller = new HealthyFoodController(view);
        controller.jalankan();
    }

    
}
