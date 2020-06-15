package by.epamtc.tsalko.main.task02;

import java.util.Arrays;

public class Program {

    public void showArrayWithoutMinElements(int[] arr) {
        int[] newArr;
        newArr = formArrayWithoutMinElements(arr);

        System.out.printf("New array without min elements: %s\n", Arrays.toString(newArr));
    }

    private int[] formArrayWithoutMinElements(int[] arr) {
        int[] result;
        int newLength = 0;
        int min;
        min = findMinValue(arr);

        // Определяем новую длину массива, если min элементов > 1;
        for (int num : arr) {
            if (num != min) {
                newLength++;
            }
        }

        result = new int[newLength];
        for (int i = 0, j = 0; i < arr.length; i++) {
            int num = arr[i];
            if (num != min) {
                result[j] = num;
                j++;
            }
        }

        return result;
    }

    private int findMinValue(int[] arr) {
        int min;

        /*
        Инициализация min не нулем а первым значением позледовательности, так как
        если наименьшее число массива меньше нуля и оно стоит первым, то результат
        метода будет неверным!
        */
        min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int nextNum = arr[i];
            if (nextNum < min) {
                min = nextNum;
            }
        }

        return min;
    }
}
