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

        // находим индексы уже установленных кубиков
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                if (indexFirstFixedCube != -1) {
                    indexSecondFixedCube = i;
                } else {
                    indexFirstFixedCube = i;
                }
            }
        }

        // Заполняем первые три значения последовательности
        int firstIndex = indexFirstFixedCube % 3;
        int secondIndex = indexSecondFixedCube % 3;

        // Если индексы первого и второго числа совпадают, меняем индекс второго
        if (firstIndex == secondIndex) {
            secondIndex = firstIndex == 0? 1: 0;
        }

        int thirdIndex = 3 - firstIndex - secondIndex;

        arr[firstIndex] = arr[indexFirstFixedCube];
        arr[secondIndex] = arr[indexSecondFixedCube];
        arr[thirdIndex] = 10 - arr[indexFirstFixedCube] - arr[indexSecondFixedCube];

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
        if (checkCode(arr)) {
            return arr;
        } else {
            return null;
        }
    }

    private boolean checkCode(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            int firstNum = arr[i];
            int secondNum = arr[i + 1];
            int thirdNum = arr[i + 2];
            int sum = firstNum + secondNum + thirdNum;

            if (firstNum <= 0 || secondNum <= 0 || thirdNum <= 0 || sum != 10) {
                return false;
            }
        }
        return true;
    }
}
