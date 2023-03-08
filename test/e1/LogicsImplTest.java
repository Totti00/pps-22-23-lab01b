package e1;

import e1.factory.GameFactory;
import e1.factory.GameFactoryImpl;
import e1.pieces.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LogicsImplTest {

    public static final int SIZE = 500;
    public static final int OUT_OF_BOUND_LESS_OF_MINIMUM = -1;
    public static final int OUT_OF_BOUND_GREATER_OF_MAXIMUM = 600;
    private Logics logics;
    private final GameFactory factory = new GameFactoryImpl();

    @Test
    void checkSamePositionOfPawnAndKnight() {
        this.logics = new LogicsImpl(SIZE, factory);
        assertNotEquals(this.logics.getPawn(), this.logics.getKnight());
    }

    @Test
    void checkExceptionHit() {
        this.logics = new LogicsImpl(SIZE, factory);
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(OUT_OF_BOUND_LESS_OF_MINIMUM, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(0, OUT_OF_BOUND_LESS_OF_MINIMUM));
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(OUT_OF_BOUND_GREATER_OF_MAXIMUM, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(0, OUT_OF_BOUND_GREATER_OF_MAXIMUM));
    }

    @Test
    void checkHit() {
        final Pair<Integer, Integer> posKnight = new Pair<>(0, 0);
        final Pair<Integer, Integer> posPawn = new Pair<>(2, 1);
        this.logics = new LogicsImpl(SIZE, factory, posKnight, posPawn);
        assertTrue(this.logics.hit(2, 1));
    }
}