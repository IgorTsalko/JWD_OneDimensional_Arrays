package by.epamtc.tsalko.main.task05;

public class Program {

    public void showSumMaxEvenAndMinOddValues(int[] arr) {
        int sum;
        sum = calcSumMaxEvenAndMinOddValues(arr);

        System.out.printf("Result: %d", sum);
    }

    private int calcSumMaxEvenAndMinOddValues(int[] arr) {
        int lengthForEvenArr;
        int lengthForOddArr;
        int[] oddArr;
        int[] evenArr;
        int minOddValue;
        int maxEvenValue;

        lengthForEvenArr = arr.length / 2;
        lengthForOddArr = arr.length - lengthForEvenArr;

        evenArr = formEvenArr(arr, lengthForEvenArr);
        oddArr = formOddArr(arr, lengthForOddArr);

        maxEvenValue = findMaxValue(evenArr);
        minOddValue = findMinValue(oddArr);

        return maxEvenValue + minOddValue;
    }

    private int[] formOddArr(int[] arr, int lengthForOddArr) {
        int[] oddArr = new int[lengthForOddArr];

        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                oddArr[j] = arr[i];
                j++;
            }
        }

        return oddArr;
    }

    private int[] formEvenArr(int[] arr, int lengthForEvenArr) {
        int[] oddArr = new int[lengthForEvenArr];

        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i % 2 != 0) {
                oddArr[j] = arr[i];
                j++;
            }
        }

        return oddArr;
    }

    private int findMaxValue(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    private int findMinValue(int[] arr) {
        int min = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }

        return min;
    }
}
