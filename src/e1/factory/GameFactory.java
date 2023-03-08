package e1.factory;

import e1.strategy.KnightStrategy;
import e1.strategy.PawnStrategy;

public interface GameFactory {
    KnightStrategy createKnightStrategy();

    PawnStrategy createPawnStrategy();
}
