import java.util.Random;
import java.util.Scanner;

public class Pve {

    public static void pve(Character player, Scanner sc){

        Random rand = new Random();


        Character[] enemyNpc = {
                new Orc("Ork"),
                new Dragon("Smok"),
                new Slime("Slime")
        };


        System.out.println("\n" + "Walka PvE Rozpoczęta");


        Character enemy = enemyNpc[rand.nextInt(enemyNpc.length)];
        System.out.println("\n" + "Pojawił się przeciwnik: " + enemy.getName());

        while (enemy.getLevel() < player.getLevel()) {
            enemy.levelUp();
        }


        while (player.getHealth() > 0 && enemy.getHealth() > 0){

            System.out.println("\n" + "Twoja postać:");
            player.showStats();


            System.out.println("\n" + "Przeciwnik:");
            enemy.showStats();

            System.out.println("\n" + "Wybierz typ ataku: 1: melee || 2: ranged || 3: magic");
            int attackType = Utils.verificationOfData(sc);
            player.attack(enemy, attackType);


            if (enemy.getHealth() <= 0) {
                System.out.println("\n" + enemy.getName() + " został pokonany przez " + player.getName());
                player.levelUp();
                break;
            }


            int enemyAttackType = rand.nextInt(3) + 1;
            enemy.attack(player, enemyAttackType);


            if (player.getHealth() <= 0) {
                System.out.println("\n" + player.getName() + " poległ w bitwie z " + enemy.getName());
                player.healFull();
                break;
            }
        }

        if (player.health > 0) {
            System.out.println("\n" + "Wygrałeś PvE!");
        }
    }
}
