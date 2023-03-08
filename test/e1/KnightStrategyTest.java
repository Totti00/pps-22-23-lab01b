package e1;

import e1.factory.GameFactory;
import e1.factory.GameFactoryImpl;
import e1.pieces.Pair;
import e1.strategy.GameStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightStrategyTest {

    public static final int SIZE = 500;
    private GameStrategy strategy;

    @BeforeEach
    void setUp() {
        GameFactory factory = new GameFactoryImpl();
        this.strategy = factory.createKnightStrategy();
    }

    @Test
    void checkCanMove() {
        assertTrue(this.strategy.canMove(new Pair<>(5, 2), SIZE, new Pair<>(4, 4)));
        assertTrue(this.strategy.canMove(new Pair<>(2, 1), SIZE, new Pair<>(0, 0)));
    }

    @Test
    void checkCanNotMove() {
        assertFalse(this.strategy.canMove(new Pair<>(0, 0), SIZE, new Pair<>(0, 0)));
        assertFalse(this.strategy.canMove(new Pair<>(4, 1), SIZE, new Pair<>(0, 0)));
        assertThrows(IndexOutOfBoundsException.class, () -> this.strategy.canMove(new Pair<>(-1, 5), SIZE, new Pair<>(0, 0)));
        assertThrows(IndexOutOfBoundsException.class, () -> this.strategy.canMove(new Pair<>(2, -3), SIZE, new Pair<>(0, 0)));
    }
}