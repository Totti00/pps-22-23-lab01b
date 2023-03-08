package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicsImplTest {
    private Logics logics;

    @BeforeEach
    void setUp() {
        this.logics = new LogicsImpl(7);
        this.logics.placeMines(5);
    }

    @Test
    void testCheckPlaceMines() {
        assertEquals(5, this.logics.getCellsWithMines().size());
    }

    @Test
    void testLostGame() {
        Pair<Integer, Integer> posCellWithMine = this.logics.getCellsWithMines().stream().findAny().get().getPosition();
        assertTrue(this.logics.hit(posCellWithMine));
        assertFalse(this.logics.checkWin());
    }
}