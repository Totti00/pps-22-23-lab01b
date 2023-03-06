package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightStrategyTest {

    private GameStrategy gameStrategy;

    @BeforeEach
    void setUp() {
        this.gameStrategy = new KnightStrategy();
    }

    @Test
    void checkCanMove() {
        assertTrue(this.gameStrategy.canDoMove(1, 2));
        assertTrue(this.gameStrategy.canDoMove(2, 1));
        assertTrue(this.gameStrategy.canDoMove(-1, 2));
        assertTrue(this.gameStrategy.canDoMove(-2, 1));
    }

    @Test
    void checkCanNotMove() {
        assertFalse(this.gameStrategy.canDoMove(0, 0));
        assertFalse(this.gameStrategy.canDoMove(4, 1));
        assertFalse(this.gameStrategy.canDoMove(0, 5));
        assertFalse(this.gameStrategy.canDoMove(2, 3));
    }

    @Test
    void isALegalMovement() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.gameStrategy.isALegalMovement(-1, 0, 500));
        assertThrows(IndexOutOfBoundsException.class, () -> this.gameStrategy.isALegalMovement(0, -1, 500));
        assertThrows(IndexOutOfBoundsException.class, () -> this.gameStrategy.isALegalMovement(500, 0, 500));
        assertThrows(IndexOutOfBoundsException.class, () -> this.gameStrategy.isALegalMovement(0, 500, 500));
    }
}