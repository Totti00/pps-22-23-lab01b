package e2;

public interface Cell {
    boolean hasMine();

    void setMine();

    Pair<Integer, Integer> getPosition();

    boolean canBeHit();

    void hit();

    boolean hasFlag();

    void removeFlag();

    void placeFlag();
}
