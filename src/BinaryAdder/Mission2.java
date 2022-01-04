package BinaryAdder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Mission2 {

    BinaryAdder binaryAdder = new BinaryAdder();

    @Test
    void halfAdderTest() {
        boolean[] expectedArr = {true, false};
        boolean bitA = true;
        boolean bitB = true;
        assertArrayEquals(expectedArr, binaryAdder.halfAdder(bitA, bitB));
    }

    @Test
    void fullAdderTest() {
        boolean[] expectedArr = {true, true};
        boolean bitA = true;
        boolean bitB = true;
        boolean carry = true;
        assertArrayEquals(expectedArr, binaryAdder.fullAdder(bitA, bitB, carry));
    }


}
