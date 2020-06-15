package by.epamtc.tsalko.main.task04;

public class Program {

    public void showMostCommonNumber(int[] arr) {
        int mostCommon;
        mostCommon = findMostCommonNumber(arr);

        System.out.printf("Most common number is %d\n", mostCommon);
    }

    private int findMostCommonNumber(int[] arr) {
        int maxFrequency;
        int mostCommonNumber;

        maxFrequency = findMaxFrequency(arr);
        mostCommonNumber = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int num = arr[i];
            // Если число есть в последовательности, у него уже есть одно повторение
            int frequencyForNumber = 1;
            for (int j = i + 1; j < arr.length; j++) {
                int nextNum = arr[j];
                if (num == nextNum) {
                    frequencyForNumber++;
                }
            }
            if (frequencyForNumber == maxFrequency && num < mostCommonNumber) {
                mostCommonNumber = num;
            }
        }

        return mostCommonNumber;
    }

    private int findMaxFrequency(int[] arr) {
        int maxFrequency = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int num = arr[i];
            // Если число есть в последовательности, у него уже есть одно повторение
            int frequency = 1;
            for (int j = i + 1; j < arr.length; j++) {
                int nextNum = arr[j];
                if (num == nextNum) {
                    frequency++;
                }
            }
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        return maxFrequency;
    }
}
