import entity.Creature;
import entity.Monster;
import entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Battle {

    public void fight(Player player, Monster monster) {
        List<Creature> warriors = new ArrayList<>();
        warriors.add(player);
        warriors.add(monster);

        while (player.isAlive() && monster.isAlive()) {
            for (Creature warrior : warriors) {
                int damage = 0;
                if (warrior.equals(player)) {
                    damage = monster.attacks(player);
                } else {
                    damage = player.attacks(monster);
                }
                if (warrior.isAlive()) {
                    if (warrior.getHealingAmount() > 0 && damage > 0) {
                        warrior.heal();
                    }
                } else {
                    System.out.println("\n" + warrior.getName() + " game over");
                    warriors.remove(warrior);
                    break;
                }
                System.out.println();
            }
        }

        System.out.println(warriors.get(0).getName() + " winner");

    }

}
