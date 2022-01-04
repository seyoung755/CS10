package BinaryAdder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Mission3 {

    BinaryAdder binaryAdder = new BinaryAdder();

    @Test
    void byteAdderTest() {
        Boolean[] expectedArr = {false, false, false, true, false, true, false, false, true};
        boolean[] byteA = {true, true, false, true, true, false, true, false};
        boolean[] byteB = {true, false, true, true, false, false, true, true};
        assertArrayEquals(expectedArr, binaryAdder.byteAdder(byteA, byteB));
    }
}
