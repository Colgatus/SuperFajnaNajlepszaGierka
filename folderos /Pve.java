import java.util.Random;
import java.util.Scanner;

public class Pve {

    public static void pve(Character player){

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();


        Character[] enemyNpc = {
                new Orc("Ork"),
                new Dragon("Smok"),
                new Slime("Slime")
        };


        System.out.println("\n" + "Walka PvP Rozpoczęta");


        Character enemy = enemyNpc[rand.nextInt(enemyNpc.length)];
        System.out.println("\n" + "Pojawił się przeciwnik: " + enemy.name);

        if (player.level > enemy.level){
            for(int i = player.level; i < enemy.level; i++){
                enemy.levelUp();
            }
        }


        while (player.health > 0 && enemy.health > 0){

            System.out.println("\n" + "Twoja postać:");
            player.showStats();


            System.out.println("\n" + "Przeciwnik:");
            enemy.showStats();

            System.out.println("\n" + "Wybierz typ ataku: 1: melee || 2: ranged || 3: magic");
            int attackType = Utils.verifcationOfData(sc);
            player.attack(enemy, attackType);


            if (enemy.health <= 0) {
                System.out.println("\n" + enemy.name + " został pokonany przez " + player.name);
                player.levelUp();
                break;
            }


            int enemyAttackType = rand.nextInt(3) + 1;
            enemy.attack(player, enemyAttackType);


            if (player.health <= 0) {
                System.out.println("\n" + player.name + " poległ w bitwie z " + enemy.name);
                player.health = player.maxHealth;
                break;
            }
        }

        if (player.health > 0) {
            System.out.println("\n" + "Wygrałeś PvE!");
        }
    }
}
