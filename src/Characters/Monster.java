package Characters;

public class Monster extends Character {
    protected static final int BASE_HP = 120;
    protected static final String BASE_TYPE = "Monster";
    protected static final int BASE_HEALAMOUNT = 17;
    protected static final int BASE_DAMAGE = 35;
    protected static final double BASE_DEFENSE = 0.5;
    protected static final double BASE_CRITRATE = 0.3;

    public Monster(String name) {
        super(name, BASE_TYPE, BASE_HP, BASE_HEALAMOUNT, BASE_DAMAGE, BASE_DEFENSE, BASE_CRITRATE);
    }
}
