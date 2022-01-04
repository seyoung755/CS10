package BinaryAdder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Convertor {

    public Boolean[] dec2bin(int decimal) {
        List<Boolean> answer = new ArrayList<Boolean>();
        int dec = decimal;
        while (dec > 0) {
            boolean b = (dec % 2) != 0;
            answer.add(b);
            dec /= 2;
        }
        Boolean[] arrAnswer = answer.toArray(new Boolean[answer.size()]);
        printBin(decimal, arrAnswer);
        return arrAnswer;

    }

    public int bin2dec(boolean[] bin) {
        int i = 1, answer = 0;
        for (boolean b : bin) {
            if (b) {
                answer += i;
            }

            i *= 2;
        }
        printDec(bin, answer);
        return answer;
    }

    public void printBin(int decimal, Boolean[] answer) {
        System.out.println("입력 = " + decimal);
        System.out.println("출력 = " + Arrays.toString(answer));
    }

    public void printDec(boolean[] bin, int answer) {
        System.out.println("입력 = " + Arrays.toString(bin));
        System.out.println("출력 = " + answer);
    }
}
