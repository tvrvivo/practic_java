package com.company;
import java.io.Serializable;

    public class Item implements Serializable {

        /**
         * Значення початкової швидкості польоту
         */
        private double Speed;

        /**
         * Значення величини кута польоту, відповідно до поверхні Землі
         */
        private double Angle;

        private double G;

        /**
         * Автоматично згенерована константа
         */
        private static final long serialVersionUID = 1L;

        public Item() {
            Speed = .0;
            Angle = .0;
            G = 9.8;
        }

        /**
         * Задаємо значення даних
         *
         * @param Speed - початкова швидкість польоту
         * @param Angle - кут відповідно до поверхні Землі
         */
        public Item(double Speed, double Angle, double G) {
            this.Speed = Speed;
            this.Angle = Angle;
            this.G = G;
        }

        /**
         * Задаємо значення {@linkplain Item#Speed}
         *
         * @return Значення {@linkplain Item#Speed}
         */
        public double setSpeed(double Speed) {
            return this.Speed = Speed;
        }

        /**
         * Отримуємо значення {@linkplain Item#Speed}
         *
         * @return Значення {@linkplain Item#Speed}
         */
        public double getSpeed() {
            return Speed;
        }

        /**
         * Задаємо значення {@linkplain Item#Angle}
         *
         * @return Значення {@linkplain Item#Angle}
         */
        public double setAngle(double Angle) {
            return this.Angle = Angle;
        }

        /**
         * Отримуємо значення {@linkplain Item#Angle}
         *
         * @return Значення {@linkplain Item#Angle}
         */
        public double getAngle() {
            return Angle;
        }


        public double setG(double G) {
            return this.G = G;
        }

        public double getG() {
            return G;
        }

        /**
         * Задаємо значення {@linkplain Item#Speed} та {@linkplain Item#Angle}
         *
         * @param Speed - для значення {@linkplain Item#Speed}
         * @param Angle - для значення {@linkplain Item#Angle}
         * @return this
         */
        public Item setSpeedAngle(double Speed, double Angle, double G) {
            this.Speed = Speed;
            this.Angle = Angle;
            this.G = G;
            return this;
        }

        /**
         * Представляє результат обчислень у вигляді рядка
         */
        @Override
        public String toString() {
            return "Speed = " + Speed + ", Angle = " + Angle + ", G = " + G;
        }

        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;

            Item other = (Item) obj;
            if (Double.doubleToLongBits(Speed) != Double.doubleToLongBits(other.Speed))
            return false;
            if (Math.abs(Math.abs(Angle) - Math.abs(other.Angle)) > .1e-10)
                return false;
            return true;
        }
    }

