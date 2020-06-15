package by.epamtc.tsalko.main.task01;

public class Program {

    public void showMaxPairSum(double[] arr) {
        double max;
        max = findMaxPairSum(arr);

        System.out.printf("Maximum pair sum: %.2f\n", max);
    }

    private double findMaxPairSum(double[] arr) {
        double max;
        max = Double.MIN_VALUE;

        for (int i = 0, j = arr.length - 1; i < arr.length - 1; i++, j--) {
            double sum = arr[i] + arr[j];
            max = Double.max(sum, max);
        }

        return max;
    }
}
