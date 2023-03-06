package e1;

public interface GameStrategy {

    boolean canDoMove(int x, int y);

    boolean isALegalMovement(int x, int y, int size);
}
