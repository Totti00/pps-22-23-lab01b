package e1.strategy;

import e1.Pair;

public class KnightStrategy implements GameStrategy {

    @Override
    public boolean canMove(Pair<Integer, Integer> newPos, int size, Pair<Integer, Integer> knight) {
        if (newPos.getX() < 0 || newPos.getY() < 0 || newPos.getX() >= size || newPos.getY() >= size) {
            throw new IndexOutOfBoundsException();
        }
        // Below a compact way to express allowed moves for the knight
        int x = newPos.getX() - knight.getX();
        int y = newPos.getY() - knight.getY();
        return (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3);
    }

}
