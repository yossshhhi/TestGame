package entity;

import entity.Creature;

public class Monster extends Creature {

    public Monster(int minDamage, int maxDamage, String name) {
        super(minDamage, maxDamage, name);
    }

    public Monster(int attack, int defense, int minDamage, int maxDamage, String name) {
        super(attack, defense, minDamage, maxDamage, name);
    }

}
