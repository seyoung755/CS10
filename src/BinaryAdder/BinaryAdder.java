package BinaryAdder;

public class BinaryAdder {
    Gate gate = new Gate();

    public boolean[] halfAdder(boolean bitA, boolean bitB) {
        boolean[] answer = {gate.andGate(bitA, bitB), gate.xorGate(bitA, bitB)};
        return answer;
    }

    public static void main(String[] args) {
//        System.out.println("Hello World adder");
//        boolean bitA=true, bitB=false;
//        Gate gate = new Gate();
//        System.out.println(gate.andGate(bitA, bitB));
//        System.out.println(gate.orGate(bitA, bitB));
//        System.out.println(gate.nandGate(bitA, bitB));
//        System.out.println(gate.xorGate(bitA, bitB));
        BinaryAdder binaryAdder = new BinaryAdder();
        boolean[] answer = binaryAdder.halfAdder(true, true);

        for (boolean a : answer) {
            System.out.println(a);
        }
    }
}