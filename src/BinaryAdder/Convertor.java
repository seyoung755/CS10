package BinaryAdder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Convertor {

    public void dec2bin(int decimal) {
        List<Boolean> answer = new ArrayList<Boolean>();
        while (decimal > 0) {
            boolean b = (decimal % 2) != 0;
            answer.add(b);
            decimal /= 2;
        }
        Boolean[] arr = new Boolean[answer.size()];
        printBin(answer.toArray(arr));
    }

    public void printBin(Boolean[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Convertor c = new Convertor();
        int decimal = 256;
        c.dec2bin(decimal);

    }
}
