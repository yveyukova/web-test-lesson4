package org.example;

public class TriangleException extends Exception {
    String message;

    TriangleException(String str) {
        message = str;
    }

    public String toString() {
        return ("Класс Triangle вызвал исключение: " + message);
    }
}
