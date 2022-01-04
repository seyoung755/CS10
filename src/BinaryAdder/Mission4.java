package BinaryAdder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Mission4 {

    Convertor convertor = new Convertor();

    @Test
    void dec2binTest() {
        int decimal = 256;
        Boolean[] expectedArr = {false, false, false, false, false, false, false, false, true};
        assertArrayEquals(expectedArr, convertor.dec2bin(decimal));
    }

    @Test
    void bin2decTest() {
        boolean[] bin = {false, false, true, true, true};
        int expectedDec = 28;
        assertEquals(expectedDec, convertor.bin2dec(bin));
    }
}
