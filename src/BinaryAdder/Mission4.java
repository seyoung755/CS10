package BinaryAdder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Mission4 {

    Convertor convertor = new Convertor();

    @Test
    void dec2binTest() {
        int decimal = 256;
        Boolean[] expectedArr = {false, false, false, false, false, false, false, false, true};
        assertArrayEquals(expectedArr, convertor.dec2bin(decimal));
        assertArrayEquals(new Boolean[]{false}, convertor.dec2bin(0));
    }

    @Test
    void bin2decTest() {
        Boolean[] bin = {false, false, true, true, true};
        int expectedDec = 28;
        assertEquals(expectedDec, convertor.bin2dec(bin));
        assertEquals(12, convertor.bin2dec(new Boolean[]{false, false, true, true, false}));
        assertEquals(0, convertor.bin2dec(new Boolean[]{false}));

    }

    @Test
    void convertDecimalSum2HexTest() {
        assertTrue(new StringBuffer("0x25").toString().equals(convertor.convertDecimalSum2Hex(15, 22).toString()));
        assertTrue(new StringBuffer("0x0F").toString().equals(convertor.convertDecimalSum2Hex(10, 5).toString()));
        assertTrue(new StringBuffer("0x0FF").toString().equals(convertor.convertDecimalSum2Hex(200, 55).toString()));
    }
}
