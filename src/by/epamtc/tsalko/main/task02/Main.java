package by.epamtc.tsalko.main.task02;

public class Main {

    public static void main(String[] args) {
        Program program = new Program();

        // Random values
        int[] array = {2, 0, 4, 10, 3, 12, 15, 0, 1, 8, 0, 19, 4, 24, 3, 14, 9, 7, 21};

        program.showArrayWithoutMinElements(array);
    }
}
