package BinaryAdder;

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

    public static void main(String[] args) {

        BinaryAdder binaryAdder = new BinaryAdder();
        boolean[] answer = binaryAdder.fullAdder(false, false, true);

        for (boolean a : answer) {
            System.out.println(a);
        }

    }
}