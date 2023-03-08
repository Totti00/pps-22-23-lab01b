package e1.strategy;

import e1.pieces.Pair;

public class KnightStrategy implements GameStrategy {

    @Override
    public boolean canMove(Pair<Integer, Integer> newPos, int size, Pair<Integer, Integer> knight) {
        insideTheChessboard(newPos, size);
        int x = newPos.getX() - knight.getX();
        int y = newPos.getY() - knight.getY();
        return (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3);
    }

    private void insideTheChessboard(Pair<Integer, Integer> newPos, int size) {
        if (newPos.getX() < 0 || newPos.getY() < 0 || newPos.getX() >= size || newPos.getY() >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

}
