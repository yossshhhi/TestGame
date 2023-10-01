import entity.Monster;
import entity.Player;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(15, 25, "Player");
        Monster monster = new Monster(9, 30, "Monster");
        Battle battle = new Battle();

        battle.fight(player, monster);
    }
}
