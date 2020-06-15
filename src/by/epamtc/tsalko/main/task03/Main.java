package by.epamtc.tsalko.main.task03;

public class Main {

    public static void main(String[] args) {
        Decoder decoder = new Decoder();

        // random value;
        int[] lock = {0, 4, 0, 1, 0, 0, 0, 0, 0, 0};
        decoder.showCode(lock);
    }
}
