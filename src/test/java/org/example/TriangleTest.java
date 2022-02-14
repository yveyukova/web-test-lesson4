package org.example;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TriangleTest {
    static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @ParameterizedTest
    @CsvSource({"2, 3, 3, 2.83"})
    void testTriangle(int a, int b, int c, double sA) {
        logger.info( "+++++++++++++++++++++++++++++++++++++++++++++++++++");
        logger.info( "1. Позитивный сценарий");
        logger.info( "+++++++++++++++++++++++++++++++++++++++++++++++++++");
        logger.info( "Проверка расчета площади по сторонам "
                + Integer.toString(a) + ", "
                + Integer.toString(b) + ", "
                + Integer.toString(c) );
        double s = 0;
        try {
            s = Triangle.getSquare(a, b, c);
        } catch (TriangleException e) {
            logger.error("Exception: " + e.toString());
            logger.error("Тест отработал некорректно");
            assertTrue(false);
        }
        assertEquals(s, sA);
        logger.info("Получен верный ответ: " + Double.toString(sA));
    }

    @ParameterizedTest
    @CsvSource({"2, 3, 5, 0"})
    void testNotExistTriangle(int a, int b, int c, double sA) {
        logger.info( "+++++++++++++++++++++++++++++++++++++++++++++++++++");
        logger.info( "2. Негативный сценарий. Треугольник не существует");
        logger.info( "+++++++++++++++++++++++++++++++++++++++++++++++++++");
        logger.info( "Проверка расчета площади по сторонам "
                + Integer.toString(a) + ", "
                + Integer.toString(b) + ", "
                + Integer.toString(c) );
        double s = 0;
        try {
            s = Triangle.getSquare(a, b, c);
        } catch (TriangleException e) {
            logger.info("Exception: " + e.toString());
            assertEquals(e.toString(), "Класс Triangle вызвал исключение: Такого треугольника не существует");
            logger.info("Вызвано верное исключение: Такого треугольника не существует");
            return;
        }
        logger.error("Тест отработал некорректно");
        assertTrue(false);
    }

    @ParameterizedTest
    @CsvSource({"0, 3, 5, 0"})
    void testZeroTriangle(int a, int b, int c, double sA) {
        logger.info( "+++++++++++++++++++++++++++++++++++++++++++++++++++");
        logger.info( "3. Негативный сценарий. Нулевая сторона");
        logger.info( "+++++++++++++++++++++++++++++++++++++++++++++++++++");
        logger.info( "Проверка расчета площади по сторонам "
                + Integer.toString(a) + ", "
                + Integer.toString(b) + ", "
                + Integer.toString(c) );
        double s = 0;
        try {
            s = Triangle.getSquare(a, b, c);
        } catch (TriangleException e) {
            logger.info("Exception: " + e.toString());
            assertEquals(e.toString(), "Класс Triangle вызвал исключение: Длина одной из сторон равна нулю");
            logger.info("Вызвано верное исключение: Длина одной из сторон равна нулю");
            return;
        }
        logger.error("Тест отработал некорректно");
        assertTrue(false);
    }
    @ParameterizedTest
    @CsvSource({"2, -3, 5, 0"})
    void testNegativeTriangle(int a, int b, int c, double sA) {
        logger.info( "+++++++++++++++++++++++++++++++++++++++++++++++++++");
        logger.info( "4. Негативный сценарий. Отрицательная сторона");
        logger.info( "+++++++++++++++++++++++++++++++++++++++++++++++++++");
        logger.info( "Проверка расчета площади по сторонам "
                + Integer.toString(a) + ", "
                + Integer.toString(b) + ", "
                + Integer.toString(c) );
        double s = 0;
        try {
            s = Triangle.getSquare(a, b, c);
        } catch (TriangleException e) {
            logger.info("Exception: " + e.toString());
            assertEquals(e.toString(), "Класс Triangle вызвал исключение: Длина одной из сторон отрицательная");
            logger.info("Вызвано верное исключение: Длина одной из сторон отрицательная");
            return;
        }
        logger.error("Тест отработал некорректно");
        assertTrue(false);
    }
}

