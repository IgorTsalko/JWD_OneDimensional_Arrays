package by.epamtc.tsalko.main.task03;

import java.util.Arrays;

public class Decoder {

    public void showCode(int[] arr) {
        int[] code = decrypt(arr);

        if (code != null) {
            System.out.printf("Code: %s\n", Arrays.toString(code));
        } else {
            System.out.println("Code doesn't exist");
        }
    }

    private int[] decrypt(int[] arr) {
        int indexFirstFixedCube = -1;
        int indexSecondFixedCube = -1;
        int firstFixedNum;
        int secondFixedNum;

        // находим индексы для установленных кубиков
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                if (indexFirstFixedCube != -1) {
                    indexSecondFixedCube = i;
                } else {
                    indexFirstFixedCube = i;
                }
            }
        }

        // Инициализация фиксированных значений
        firstFixedNum = arr[indexFirstFixedCube];
        secondFixedNum = arr[indexSecondFixedCube];

        /*
        Заполняем первые три числа кода открытия двери чтобы дальше можно было
        считать последовательность
         */
        int firstIndex = indexFirstFixedCube % 3;
        int secondIndex = indexSecondFixedCube % 3;

        if (firstIndex == secondIndex) {
            // Последовательность нельзя решить
            return null;
        }

        int thirdIndex = 3 - firstIndex - secondIndex;

        arr[firstIndex] = firstFixedNum;
        arr[secondIndex] = secondFixedNum;
        arr[thirdIndex] = 10 - firstFixedNum - secondFixedNum;

        // Проверяем каждые три числа по порядку, и дописываем значение
        for (int i = 1; i < arr.length - 2; i++) {
            int firstNum = arr[i];
            int secondNum = arr[i + 1];
            int thirdNum = arr[i + 2];

            if (thirdNum == 0) {
                thirdNum = 10 - firstNum - secondNum;
            }
            arr[i + 2] = thirdNum;
        }

        // Проверка на валидность
        for (int i = 0; i < arr.length - 2; i++) {
            int firstNum = arr[i];
            int secondNum = arr[i + 1];
            int thirdNum = arr[i + 2];
            int sum = firstNum + secondNum + thirdNum;

            if (sum != 10) {
                return null;
            }
        }

        return arr;
    }

}
