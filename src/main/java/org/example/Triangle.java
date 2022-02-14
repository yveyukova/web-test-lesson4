package org.example;

public class Triangle {
    public static double getSquare(int a, int b, int c) throws TriangleException {
        if (a == 0 || b == 0 || c == 0) {
            throw new TriangleException("Длина одной из сторон равна нулю");
        }
        if (a < 0 || b < 0 || c < 0) {
            throw new TriangleException("Длина одной из сторон отрицательная");
        }
        if ((a + b) <= c || (a + c) <= b || (b + c) <= a) {
            throw new TriangleException("Такого треугольника не существует");
        }
        int p = (a + b + c) / 2;
        return Math.ceil(Math.sqrt(p * (p - a) * (p - b) * (p - c)) * 100) / 100;
    }
}
