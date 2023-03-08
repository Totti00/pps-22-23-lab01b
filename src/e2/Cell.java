package e2;

public interface Cell {
    boolean hasMine();

    void setMine();

    Pair<Integer, Integer> getPosition();
}
