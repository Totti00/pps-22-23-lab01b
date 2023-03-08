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
        assertTrue(this.logics.hit(getCellWithMine()));
    }

    @Test
    void testWinGame() {

    }

    private Pair<Integer, Integer> getCellWithMine() {
        return this.logics.getCellsWithMines().stream().findAny().get().getPosition();
    }

    @Test
    void testPlaceFlag() {
        this.logics.placeFlag(getCellWithMine());
        assertTrue(this.logics.hasFlag(getCellWithMine()));
    }
}