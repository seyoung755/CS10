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

    public Boolean[] byteAdder(Boolean[] byteA, Boolean[] byteB) {
        int min_len = Math.min(byteA.length, byteB.length);
        int max_len = Math.max(byteA.length, byteB.length);
        boolean carry = false;

        List<Boolean> answer = new ArrayList<Boolean>();

        for (int i = 0; i < max_len; i++) {
            boolean bitA = (byteA.length > i) ? byteA[i] : false;
            boolean bitB = (byteB.length > i) ? byteB[i] : false;
            boolean[] result = this.fullAdder(bitA, bitB, carry);
            carry = result[0];
            answer.add(result[1]);
        }

        answer.add(carry);

        return answer.toArray(new Boolean[answer.size()]);
    }
}