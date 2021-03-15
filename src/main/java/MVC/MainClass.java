package MVC;

import Model.Monom;
import Model.Operatii;
import Model.Polinom;
import View.CalcView;
import Controller.CalcController;

public class MainClass {
    public MainClass() {
    }

    public static void main(String[] args) {

        CalcView db = new CalcView();
        CalcController controller = new CalcController(db);
        db.setVisible(true);

    }
}
