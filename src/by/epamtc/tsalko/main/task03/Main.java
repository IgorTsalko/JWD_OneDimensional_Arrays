package by.epamtc.tsalko.main.task03;

public class Main {

    public static void main(String[] args) {
        Decoder decoder = new Decoder();

        // random value;
        int[] lock    = {0, 4, 0, 0, 2, 0, 0, 0, 0, 0};
        decoder.showCode(lock);
        lock = new int[]{0, 6, 2, 0, 0, 0, 0, 0, 0, 0};
        decoder.showCode(lock);
        lock = new int[]{1, 3, 0, 0, 0, 0, 0, 0, 0, 0};
        decoder.showCode(lock);
        lock = new int[]{5, 0, 0, 0, 0, 0, 0, 0, 3, 0};
        decoder.showCode(lock);
    }
}
