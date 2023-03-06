package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LogicsImplTest {

    public static final int SIZE = 500;
    public static final int OUT_OF_BOUND_LESS_OF_MINIMUM = -1;
    public static final int OUT_OF_BOUND_GREATER_OF_MAXIMUM = 600;
    private Logics logics;

    @Test
    void checkSamePositionOfPawnAndKnight() {
        this.logics = new LogicsImpl(SIZE, new KnightStrategy());
        assertNotEquals(this.logics.getPawn(), this.logics.getKnight());
    }

    @Test
    void checkExceptionHit() {
        this.logics = new LogicsImpl(SIZE, new KnightStrategy());
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(OUT_OF_BOUND_LESS_OF_MINIMUM, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(0, OUT_OF_BOUND_LESS_OF_MINIMUM));
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(OUT_OF_BOUND_GREATER_OF_MAXIMUM, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(0, OUT_OF_BOUND_GREATER_OF_MAXIMUM));
    }

    @Test
    void checkHit() {
        this.logics = new LogicsImpl(SIZE, new KnightStrategy(), new Pair<>(0, 0), new Pair<>(2, 1));
        assertTrue(this.logics.hit(2, 1));
    }
}