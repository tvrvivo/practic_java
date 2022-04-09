package Polimorphism;

import ViewInterface.View;

/** Вычисление и отображение результатов<br>
 * Содержит реализацию статического метода main()
 * @author xone
 * @version 3.0
 * @see Main#main
 */

public class Main extends ViewInterface.Main {

    public Main(View view) {
        super(view);
    }


    public static void main(String[] args) {
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }
}
