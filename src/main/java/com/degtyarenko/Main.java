package com.degtyarenko;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {

        start();
    }

    public static void start() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        MainController mainController = new MainController();
        MyProcessor.inject(mainController);
        Scanner scan = new Scanner(System.in);
        System.out.println("Сложение : введите 1");
        System.out.println("Вычитание : введите 2");
        System.out.println("Деление : введите 3");
        System.out.println("Exit : 0");
        while (true) {
            String res = scan.nextLine();
            try {
                if ("0".equals(res)) {
                    break;
                } else {
                    System.out.println("Введите 1е число : ");
                    double value1 = scan.nextDouble();
                    System.out.println("Введите 2е число : ");
                    double value2 = scan.nextDouble();
                    if ("1".equals(res)) {
                        System.out.println(mainController.getMath().addition(value1, value2));
                        System.out.println("-----------------------");
                        start();
                        break;
                    } else if ("2".equals(res)) {
                        System.out.println(mainController.getMath().difference(value1, value2));
                        System.out.println("-----------------------");
                        start();
                        break;
                    } else if ("3".equals(res)) {
                        System.out.println(mainController.getMath().division(value1, value2));
                        System.out.println("-----------------------");
                        start();
                        break;
                    } else {
                        System.out.println("Неккоректно введены данные");
                        System.out.println("-----------------------");
                        start();
                        break;
                    }
                }
            } catch (NullPointerException e) {
                e.printStackTrace();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
