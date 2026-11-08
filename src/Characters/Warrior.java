package Characters;

public class Warrior extends Character {
    protected static final int BASE_HP = 150;
    protected static final String BASE_TYPE = "Warrior";
    protected static final int BASE_HEALAMOUNT = 15;
    protected static final int BASE_DAMAGE = 25;
    protected static final double BASE_DEFENSE = 0.3;
    protected static final double BASE_CRITRATE = 0.2;

    public Warrior(String name) {
        super(name, BASE_TYPE, BASE_HP, BASE_HEALAMOUNT, BASE_DAMAGE, BASE_DEFENSE, BASE_CRITRATE);
    }
}
