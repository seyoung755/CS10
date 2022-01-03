package BinaryAdder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryAdder {
    Gate gate = new Gate();

    public boolean[] halfAdder(boolean bitA, boolean bitB) {
        boolean[] answer = {gate.andGate(bitA, bitB), gate.xorGate(bitA, bitB)};
        return answer;
    }

    public boolean[] fullAdder(boolean bitA, boolean bitB, boolean carry) {
        boolean[] h1 = this.halfAdder(bitA, bitB);
        boolean[] h2 = this.halfAdder(h1[1], carry);

        boolean[] answer = {gate.orGate(h1[0], h2[0]), h2[1]};
        return answer;
    }

    public Boolean[] byteAdder(boolean[] byteA, boolean[] byteB) {
        int min_len = Math.min(byteA.length, byteB.length);
        int max_len = Math.max(byteA.length, byteB.length);
        boolean carry = false;

        List<Boolean> answer = new ArrayList<Boolean>();

        for (int i = 0; i < min_len; i++) {
            boolean bitA = byteA[i], bitB = byteB[i];
            boolean[] result = this.fullAdder(bitA, bitB, carry);
            carry = result[0];
            answer.add(result[1]);
        }

        if (max_len != min_len) {
            for (int j = min_len; j < max_len; j++) {
                boolean bitA = (byteA.length > byteB.length) ? byteA[j] : false;
                boolean bitB = (byteA.length < byteB.length) ? byteB[j] : false;
                boolean[] result = this.fullAdder(bitA, bitB, carry);
                carry = result[0];
                answer.add(result[1]);
            }
        } else {
            answer.add(carry);
        }

        return answer.toArray(new Boolean[answer.size()]);
    }

    public static void main(String[] args) {

        BinaryAdder binaryAdder = new BinaryAdder();
        boolean[] byteA = {true, true, false, true, true, false, true, false};
        boolean[] byteB = {true, false, true, true, false, false, true, true};

        Boolean[] answer = binaryAdder.byteAdder(byteA, byteB);

        System.out.println("byte A = " + Arrays.toString(byteA));
        System.out.println("byte B = " + Arrays.toString(byteB));
        System.out.println("결과 = " + Arrays.toString(answer));

    }
}