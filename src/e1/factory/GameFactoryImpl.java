package e1.factory;

import e1.strategy.KnightStrategy;
import e1.strategy.PawnStrategy;

public class GameFactoryImpl implements GameFactory {
    @Override
    public KnightStrategy createKnightStrategy() {
        return new KnightStrategy();
    }

    @Override
    public PawnStrategy createPawnStrategy() {
        return new PawnStrategy();
    }
}
