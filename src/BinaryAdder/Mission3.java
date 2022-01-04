package BinaryAdder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Mission3 {

    BinaryAdder binaryAdder = new BinaryAdder();

    @Test
    void byteAdderTest() {
        Boolean[] expectedArr = {false, false, false, true, false, true, false, false, true};
        Boolean[] byteA = {true, true, false, true, true, false, true, false};
        Boolean[] byteB = {true, false, true, true, false, false, true, true};
        assertArrayEquals(expectedArr, binaryAdder.byteAdder(byteA, byteB));
        Boolean[] byteC = {false, true, false, true};
        Boolean[] byteD = {false, true, true};
        Boolean[] expectedArr2 = {false, false, false, false, true};
        assertArrayEquals(expectedArr2, binaryAdder.byteAdder(byteC, byteD));
        assertArrayEquals(new Boolean[]{true, true, true, true, false}, binaryAdder.byteAdder(byteC, new Boolean[]{true, false, true}));
    }
}
