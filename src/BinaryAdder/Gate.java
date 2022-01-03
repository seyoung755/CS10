package BinaryAdder;

public class Gate {

    public boolean andGate(boolean bitA, boolean bitB) {
        return bitA && bitB;
    }

    public boolean orGate(boolean bitA, boolean bitB) {
        return bitA || bitB;
    }

    public boolean nandGate(boolean bitA, boolean bitB) {
        return !(bitA && bitB);
    }

    public boolean xorGate(boolean bitA, boolean bitB) {
        return (bitA || bitB) && !(bitA && bitB);
    }

}