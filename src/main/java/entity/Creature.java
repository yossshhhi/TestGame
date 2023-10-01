package entity;

import static utils.RandomIntGenerator.generateRandomInt;

public abstract class Creature {

    private String name;
    private int attack;
    private int defense;
    private int health;
    private int minDamage;
    private int maxDamage;
    private int healingAmount;


    public Creature(int minDamage, int maxDamage, String name) {
        this.attack = generateRandomInt(1, 30);
        this.defense = generateRandomInt(1, 30);
        this.health = getMaxHealth();
        this.healingAmount = 4;
        this.minDamage = minDamage > 0 ? minDamage : 6;
        this.maxDamage = maxDamage > this.minDamage ? maxDamage : 20;
        this.name = name;
    }

    public Creature(int attack, int defense, int minDamage, int maxDamage, String name) {
        this.attack = Math.max(1, Math.min(30, attack));
        this.defense = Math.max(1, Math.min(30, defense));
        this.health = getMaxHealth();
        this.healingAmount = 4;
        this.minDamage = minDamage > 0 ? minDamage : 6;
        this.maxDamage = maxDamage > this.minDamage ? maxDamage : 20;
        this.name = name;
    }

    public void heal() {
        if (healingAmount > 0 && health > 0) {
            int healing = (int) (0.3 * getMaxHealth());
            int currentHealth = getHealth() + healing;
            setHealth(currentHealth);
            healingAmount--;
            System.out.println(getName() + " regained " + healing + " lives. " + getName() + " health: " + getHealth());
        } else {
            System.out.println(getName() + " can no longer restore life");
        }
    }

    public void takeDamage(int damage) {
        int currentHealth = getHealth() - damage;
        setHealth(Math.max(0, currentHealth));
    }

    public int damageCalculate() {
        int modifier = getAttack() - getDefense() + 1;
        int diceRolls = Math.max(1, modifier);
        int damage = 0;
        for (int i = 0; i < diceRolls; i++) {
            int roll = generateRandomInt(1, 6);
            if (roll >= 5) {
                damage += generateRandomInt(getMinDamage(), getMaxDamage());
            }
        }
        return damage;
    }

    public int attacks(Creature defending) {
        int damage = damageCalculate();

        defending.takeDamage(damage);
        System.out.println("The " + getName() + " takes " + damage + " damage to the " + defending.getName());
        System.out.println(defending.getName() + " health: " + defending.getHealth());

        return damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getMaxHealth() {
        return 100;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getHealingAmount() {
        return healingAmount;
    }

    public void setHealingAmount(int healingAmount) {
        this.healingAmount = healingAmount;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
