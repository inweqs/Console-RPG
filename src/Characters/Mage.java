package Characters;

import java.io.Flushable;

public class Mage extends Character {
    protected static final int BASE_HP = 100;
    protected static final String BASE_TYPE = "Mage";
    protected static final int BASE_HEALAMOUNT = 28;
    protected static final int BASE_DAMAGE = 40;
    protected static final double BASE_DEFENSE = 0.1;
    protected static final double BASE_CRITRATE = 0.1;

    public Mage(String name) {
        super(name, BASE_TYPE, BASE_HP, BASE_HEALAMOUNT, BASE_DAMAGE, BASE_DEFENSE, BASE_CRITRATE);
    }
}
