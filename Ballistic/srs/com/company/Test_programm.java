package com.company;
import java.util.Scanner;
import org.junit.Test;

public class Test_programm {

    @Test
    public static void calculation(){

        System.out.println("Calculate of flight on a ballistic trajectory");

        System.out.println("Enter a initial speed: ");
        Scanner in = new Scanner(System.in);
        double Speed = in.nextDouble();

        System.out.println("Enter a angle to the Earth's surface: ");
        Scanner ina = new Scanner(System.in);
        double Angle = ina.nextDouble();

        double g = 9.8;

        double Distance = Speed * Speed * Math.sin(2 * Angle)/g;
        System.out.println("Flight range is " + Distance);

    }

}
