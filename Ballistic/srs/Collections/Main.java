package Collections;

public class Main {

    /** Выполняется при запуске программы;
     * вызывает метод {@linkplain Application#run()}
     * @param args параметры запуска программы
     */
    public static void main(String[] args) {
        Application app = Application.getInstance();
        app.run();
    }

}
