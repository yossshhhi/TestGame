package entity;

import entity.Creature;

public class Player extends Creature {

    public Player(int minDamage, int maxDamage, String name) {
        super(minDamage, maxDamage, name);
    }

    public Player(int attack, int defense, int minDamage, int maxDamage, String name) {
        super(attack, defense, minDamage, maxDamage, name);
    }
}
