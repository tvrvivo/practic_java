package Polimorphism;
import ViewInterface.View;
import ViewInterface.ViewableResult;

public class ViewableTable extends ViewableResult {
    /** Создаёт отображаемый объект {@linkplain ViewTable} */
    @Override
    public View getView() {
        return new ViewTable();
    }
}