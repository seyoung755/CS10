package BinaryAdder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Mission1 {

    @Test
    void andGateTest() {
        Gate gate = new Gate();
        assertEquals(false, gate.andGate(false, true));
        assertEquals(false, gate.andGate(false, false));
        assertEquals(false, gate.andGate(true, false));
        assertEquals(true, gate.andGate(true, true));
    }

    @Test
    void orGateTest() {
        Gate gate = new Gate();
        assertEquals(true, gate.orGate(false, true));
        assertEquals(false, gate.orGate(false, false));
        assertEquals(true, gate.orGate(true, false));
        assertEquals(true, gate.orGate(true, true));
    }

    @Test
    void nandGateTest() {
        Gate gate = new Gate();
        assertEquals(true, gate.nandGate(false, true));
        assertEquals(true, gate.nandGate(false, false));
        assertEquals(true, gate.nandGate(true, false));
        assertEquals(false, gate.nandGate(true, true));
    }

    @Test
    void xorGateTest() {
        Gate gate = new Gate();
        assertEquals(true, gate.xorGate(false, true));
        assertEquals(false, gate.xorGate(false, false));
        assertEquals(true, gate.xorGate(true, false));
        assertEquals(false, gate.xorGate(true, true));
    }
}
