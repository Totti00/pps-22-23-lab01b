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
        this.logics.getCells().stream().filter(cell -> !cell.hasMine()).forEach(cell -> this.logics.hit(cell.getPosition()));
        assertTrue(this.logics.checkWin());
    }

    private Pair<Integer, Integer> getCellWithMine() {
        return this.logics.getCellsWithMines().stream().findAny().get().getPosition();
    }

    @Test
    void testPlaceFlag() {
        Pair<Integer, Integer> posCell = getCellWithMine();
        this.logics.placeFlag(posCell);
        assertTrue(this.logics.hasFlag(posCell));
    }

    @Test
    void testRemoveFlag() {
        this.logics.placeFlag(getCellWithMine());
        this.logics.removeFlag(getCellWithMine());
        assertFalse(this.logics.hasFlag(getCellWithMine()));
    }

    @Test
    void testCanHit() {
        assertTrue(this.logics.hit(getCellWithMine()));
        assertFalse(this.logics.hit(new Pair<>(-1, 0)));
        assertFalse(this.logics.hit(new Pair<>(0, -1)));
        assertFalse(this.logics.hit(new Pair<>(6, 0)));
        assertFalse(this.logics.hit(new Pair<>(0, 6)));
    }
}