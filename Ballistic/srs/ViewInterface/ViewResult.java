package ViewInterface;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.company.Item;

    /** ConcreteProduct
     * (Шаблон проектирования
     * Factory Method)<br>
     * Вычисление функции,
     * сохранение и отображение
     * результатов
     * @author xone
     * @version 1.0
     * @see View
     */
    public class ViewResult implements View {
        /** Имя файла, используемое при сериализации */
        private static final String FNAME = "items.bin";
        /** Определяет количество значений для вычисления по умолчанию */
        private static final int DEFAULT_NUM = 10;
        /** Коллекция аргументов и результатов вычислений */
        private ArrayList<Item> items = new ArrayList<Item>();
        /** Вызывает {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)}
         * с параметром {@linkplain ViewResult#DEFAULT_NUM DEFAULT_NUM}
         */
        public ViewResult() {
            this(DEFAULT_NUM);
        }
        /** Инициализирует коллекцию {@linkplain ViewResult#items}
         * @param n начальное количество элементов
         */
        public ViewResult(int n) {
            for(int ctr = 0; ctr < n; ctr++) {
                items.add(new Item());
            }
        }
        /**
         * @return текущее значение ссылки на объект {@linkplain ArrayList}
         */
        public ArrayList<Item> getItems() {
            return items;
        }
        /** Вычисляет значение функции
         * @return результат вычисления функции
         */
        private double calc(double Speed, double Angle) {
            return Speed * Speed * Math.sin(2 * Angle)/9.8;
        }
        /** Вычисляет значение функции и сохраняет
         * результат в коллекции {@linkplain ViewResult#items}
         */
        public void init(double stepSpeed, double stepAngle) {
            double x = 0.0;
            double Speed = stepSpeed;
            double Angle = 0.0;
            for(Item item : items) {
                item.setSpeedAngle(Speed, calc(Speed,Angle),9.8);
                x += Speed;
                Speed += stepSpeed;
                Angle += stepAngle;
            }
        }
        /** Вызывает <b>init(double stepX)</b> со случайным значением аргумента<br>
         * {@inheritDoc}
         */
        @Override
        public void viewInit() {
            init(21600, 60);
        }
        /** Реализация метода {@linkplain View#viewSave()}<br>
         * {@inheritDoc}
         */
        @Override
        public void viewSave() throws IOException {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME));
            os.writeObject(items);
            os.flush();
            os.close();
        }
        /** Реализация метода {@linkplain View#viewRestore()}<br>
         * {@inheritDoc}
         */
        @SuppressWarnings("unchecked")
        @Override
        public void viewRestore() throws Exception {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
            items = (ArrayList<Item>) is.readObject();
            is.close();
        }
        /** Реализация метода {@linkplain View#viewHeader()}<br>
         * {@inheritDoc}
         */
        @Override
        public void viewHeader() {
            System.out.println("Results:");
        }
        /** Реализация метода {@linkplain View#viewBody()}<br>
         * {@inheritDoc}
         */
        @Override
        public void viewBody() {
            for(Item item : items) {
                System.out.printf("(%.0f; %.3f) ", item.getSpeed(), item.getAngle());
            }
            System.out.println();
        }
        /** Реализация метода {@linkplain View#viewFooter()}<br>
         * {@inheritDoc}
         */
        @Override
        public void viewFooter() {
            System.out.println("End.");
        }
        /** Реализация метода {@linkplain View#viewShow()}<br>
         * {@inheritDoc}
         */
        @Override
        public void viewShow() {
            viewHeader();
            viewBody();

            viewFooter();
        }
    }
