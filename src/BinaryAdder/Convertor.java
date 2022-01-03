package BinaryAdder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Convertor {

    public void dec2bin(int decimal) {
        List<Boolean> answer = new ArrayList<Boolean>();
        int dec = decimal;
        while (dec > 0) {
            boolean b = (dec % 2) != 0;
            answer.add(b);
            dec /= 2;
        }
        Boolean[] arr = new Boolean[answer.size()];
        printBin(decimal, answer.toArray(arr));
    }

    public void bin2dec(boolean[] bin) {
        int i = 1, answer = 0;
        for (boolean b : bin) {
            if (b) {
                answer += i;
            }

            i *= 2;
        }
        printDec(bin, answer);
    }

    public void printBin(int decimal, Boolean[] answer) {
        System.out.println("입력 = "+decimal);
        System.out.println("출력 = "+Arrays.toString(answer));
    }

    public void printDec(boolean[] bin, int answer) {
        System.out.println("입력 = "+Arrays.toString(bin));
        System.out.println("출력 = "+answer);
    }


    public static void main(String[] args) {
        Convertor c = new Convertor();
        int decimal = 256;
        c.dec2bin(decimal);
        boolean[] bin = {true, true, true, true, true};
        c.bin2dec(bin);

    }
}
