package e1.factory;

import e1.strategy.*;

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
