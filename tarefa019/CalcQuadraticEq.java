package org.example._03;

public class CalcQuadraticEq {
    public void calcQuadraticEq(int a, int b, int c) {
        int delta = (b * b) - (4 * a * c);

        if (delta > 0) {
            double x1 = (-b - Math.sqrt(delta)) / (2.0 * a);
            double x2 = (-b + Math.sqrt(delta)) / (2.0 * a);
            System.out.println("x1 = " + x1 + ", x2 = " + x2);
        } else if (delta == 0) {
            double x = -b / (2.0 * a);
            System.out.println("x = " + x);
        } else {
            System.out.println("Equation has no roots");
        }
    }
}
