package Characters;

// Basic character of the game with general attributes and methods
public abstract class Character {
    private final String name;
    private final String type;
    private int HP;
    private final int maxHP;
    private int healAmount;
    private final int damage;
    private final double defense;
    private final double critRate;
    private boolean isAlive = true;

    // Enum for enumerating brawler types
    public enum Type {
        WARRIOR, MAGE, MONSTER;
    }

    protected Character(String name, String type, int HP, int healAmount, int damage, double defense, double critRate) {
        this.name = name;
        this.type = type;
        this.HP = HP;
        this.maxHP = HP;
        this.healAmount = healAmount;
        this.damage = damage;
        this.defense = defense;
        this.critRate = critRate;
    }

    // The damage method works while the enemy is still alive, calling the takeDamage method.
    public void damage(Character enemy) {
        if (enemy.isAlive) {
            System.out.println("\n" + this.getInfo() + " attacks " + enemy.getInfo());
            enemy.takeDamage(this.damage, this.critRate);

            enemy.printHP();
            System.out.println();
        }
    }

    // This method uses the Character's damage value and critRate value
    public void takeDamage(int damage, double critRate) {
        int finalDamage = 0;
        double roll = Math.random();

        // If the roll value is less than or equals to critRate, the damage will be multiplied
        if (roll <= critRate) {
            finalDamage = (int) (damage * 2 * (1 - defense));
            System.out.println("Critical!");
        }
        else finalDamage = (int) (damage * (1 - defense));

        System.out.print("Damage: " + finalDamage + " | ");
        this.HP -= finalDamage;

        if (this.HP <= 0) this.killed();
    }

    // This method is called when the Character dies
    public void killed() {
        System.out.println(this.getInfo() + " is Dead...");
        this.HP = 0;
        this.isAlive = false;
    }

    // Method for self-healing
    public void healing() {
        if (this.HP + this.healAmount <= this.maxHP) {
            this.HP += this.healAmount;
        }
        else {
            this.HP = this.maxHP;
        }
        System.out.println("\n" + this.name + " uses healing spell | Health: " + this.HP);
    }


    // Several methods for maintaining encapsulation
    public int getHealth() {
        return this.HP;
    }
    public boolean isAlive() {
        return this.isAlive;
    }
    public String getInfo() {
        return this.name + " (" + this.type + ")";
    }
    public int getHealAmount() {
        return this.healAmount;
    }


    // Several methods for convenient information output
    public void printHP() {
        if (this.isAlive) System.out.print(this.name + "'s HP: " + getHealth());
    }
    public static String printStatsOfClass(Type t) {
        switch (t) {
            case WARRIOR -> {
                return "HP: " + Warrior.BASE_HP + " | Damage: " + Warrior.BASE_DAMAGE + " | HealAmount: " + Warrior.BASE_HEALAMOUNT;
            }
            case MAGE -> {
                return "HP: " + Mage.BASE_HP + " | Damage: " + Mage.BASE_DAMAGE + " | HealAmount: " + Mage.BASE_HEALAMOUNT;
            }
            case MONSTER -> {
                return "HP: " + Monster.BASE_HP + " | Damage: " + Monster.BASE_DAMAGE + " | HealAmount: " + Monster.BASE_HEALAMOUNT;
            }
            default -> {
                return "HP: " + Warrior.BASE_HP + " | Damage: " + Warrior.BASE_DAMAGE + " | HealAmount: " + Warrior.BASE_HEALAMOUNT;
            }
        }
    }

}
