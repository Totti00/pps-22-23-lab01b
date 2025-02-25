package e1;

import e1.factory.GameFactory;
import e1.pieces.Knight;
import e1.pieces.Pair;
import e1.pieces.Pawn;
import e1.strategy.GameStrategy;

public class LogicsImpl implements Logics {
	
	private final Pawn pawn;
	private final Knight knight;
	private final int size;
	private final GameStrategy strategy;

	public LogicsImpl(int size, GameFactory factory){
    	this.size = size;
		Pair<Integer, Integer> support = new Pair<>(0, 0);
		this.pawn = new Pawn(support.randomEmptyPosition(this.size));
        this.knight = new Knight(support.randomEmptyPosition(this.size));
		this.strategy = factory.createKnightStrategy();
    }

	protected LogicsImpl(int size, GameFactory factory, Pair<Integer, Integer> knight, Pair<Integer, Integer> pawn) {
		this.size = size;
		this.pawn = new Pawn(pawn);
		this.knight = new Knight(knight);
		this.strategy = factory.createKnightStrategy();
	}

	@Override
	public boolean hit(int row, int col) {
		if (this.strategy.canMove(new Pair<>(row, col), size, this.knight)) {
			this.knight.setPos(new Pair<>(row,col));
			return this.pawn.equals(this.knight);
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.equals(new Knight(new Pair<>(row,col)));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pawn(new Pair<>(row,col)));
	}

	@Override
	public Pair<Integer, Integer> getPawn() {
		return this.pawn;
	}

	@Override
	public Pair<Integer, Integer> getKnight() {
		return this.knight;
	}
}
