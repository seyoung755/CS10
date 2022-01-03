package BinaryAdder;

import java.util.ArrayList;
import java.util.List;

public class Convertor {

    public Boolean[] dec2bin(int decimal) {
        List<Boolean> answer = new ArrayList<Boolean>();
        while (decimal > 0) {
            boolean b = (decimal % 2) != 0;
            answer.add(b);
            decimal /= 2;
        }
        Boolean[] arr = new Boolean[answer.size()];
        return answer.toArray(arr);
    }

    public static void main(String[] args) {
        Convertor c = new Convertor();
        int decimal = 256;
        Boolean[] result = c.dec2bin(decimal);
        for (Boolean a : result) {
            System.out.println(a);
        }
    }
}
