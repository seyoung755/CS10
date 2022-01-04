package BinaryAdder;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Convertor {

    public Boolean[] dec2bin(int decimal) {
        if (decimal == 0) {
            printBin(decimal, new Boolean[]{false});
            return new Boolean[]{false};
        }

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

    public int bin2dec(Boolean[] bin) {
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

    public StringBuffer convertDecimalSum2Hex(int decA, int decB) {
        BinaryAdder binaryAdder = new BinaryAdder();
        StringBuffer hexa = new StringBuffer("0x");

        Boolean[] binA = this.dec2bin(decA);
        Boolean[] binB = this.dec2bin(decB);
        Boolean[] binSum = binaryAdder.byteAdder(binA, binB);

        int lenOfBin = binSum.length;
        int lenOfHex = lenOfBin / 4;
        for (int i = 0; i < lenOfHex; i++) {
            Boolean[] arr = Arrays.copyOfRange(binSum, 4*i, 4*i+4);
            hexa.insert(2, convertBin2Hex(arr));
        }

        Boolean[] arr = Arrays.copyOfRange(binSum, 4*lenOfHex, lenOfBin);
        hexa.insert(2, convertBin2Hex(arr));

        // 그 다음 HashMap 이용하여 이진수(또는 십진수)를 16진수로 변환하는 표를 하나 만들고 16진수 String으로 반환하는 식으로 구현할 것
        return hexa;
    }

    public String convertBin2Hex(Boolean[] bin) {
        HashMap<Integer, String> map = new HashMap<Integer, String>() {{
            for (int i = 0; i < 10; i++) {
                put(i, String.valueOf(i));
            }
            put(10, "A");
            put(11, "B");
            put(12, "C");
            put(13, "D");
            put(14, "E");
            put(15, "F");
        }};
        int decimal = bin2dec(bin);
        return map.get(decimal);
    }

    public void printBin(int decimal, Boolean[] answer) {
        System.out.println("입력 = " + decimal);
        System.out.println("출력 = " + Arrays.toString(answer));
    }

    public void printDec(Boolean[] bin, int answer) {
        System.out.println("입력 = " + Arrays.toString(bin));
        System.out.println("출력 = " + answer);
    }
}
