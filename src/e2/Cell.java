package e2;

public interface Cell {
    boolean hasMine();

    void setMine();

    CellType getType();

    Pair<Integer, Integer> getPosition();

    boolean canBeHit();

    void hit();

    boolean hasFlag();

    void removeFlag();

    void placeFlag();

    boolean isAdjacent(Pair<Integer, Integer> posButton);
}
