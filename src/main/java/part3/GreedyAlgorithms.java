package part3;

import java.util.Scanner;

//Часть 3.2 "Жадные алгоритмы". Всего одно задание
public class GreedyAlgorithms {
    public static void Start() {
        Scanner scanner = new Scanner(System.in);

        //Выбираем количество интервалов
        System.out.println("Введите количество отрезков:");
        int intervalCount = scanner.nextInt();
        //Выделяем массив для отрезков
        System.out.println("Enter data array:");
        int[][] arrayLine = new int[intervalCount][2];

        //Переменная для записи конца самого раннего отрезка
        int rLineMin = 0;
        //Переменная для записи количества таких отрезков
        int countLine = 0;

        //Заполняем массив данными отрезков
        for (int l = 0; l < intervalCount; l++) {
            for (int r = 0; r < 2; r++) {
                arrayLine[l][r] = scanner.nextInt();
            }
        }

        //Берем конец первого отрезка, записываем его в переменную
        rLineMin = arrayLine[0][1];
        //Чемпионский отрезок найден, увеличиваем переменную
        countLine++;

        //Найдем самый наименьший r из всех отрезков
        for (int i = 0; i < intervalCount; i++) {
            if (arrayLine[i][1] <= rLineMin) {
                rLineMin = arrayLine[i][1];
            }
        }

        for (int l = 1; l < intervalCount; l++) {
            for (int r = 0; r < 2; r++) {
                if (arrayLine[l][0] > rLineMin) {
                    rLineMin = arrayLine[l][1];
                    countLine++;
                }
            }
        }

        System.out.println(countLine);
    }
}
