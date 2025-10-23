import java.util.List;
import java.util.Scanner;

public class Pvp{

    public static void pvp(List<Character> characters, int playerOne, int playerTwo){

        Scanner sc = new Scanner(System.in);

        if (characters.size() < 2){

            System.out.println("\n" +"Potrzebujesz co najmniej dwóch postaci, żeby rozpocząć PvP");
            return;

        } else if (characters.get(playerOne) == characters.get(playerTwo)){

            System.out.println("\n" +"Nie możesz wlaczyć z tą samą postacią");
            return;
        }


        Character player1 = characters.get(playerOne);
        Character player2 = characters.get(playerTwo);


        System.out.println("\n" + "Walka PvP Rozpoczęta");
        player1.showStats();
        player2.showStats();


        while (player1.health > 0 && player2.health > 0){

            System.out.println("\n" + "Tura " + player1.name);
            System.out.println("\n" + "Gracz 1:");
            player1.showStats();
            System.out.println("\n" + "Wybierz typ ataku: 1: melee || 2: magic || 3: ranged");
            int attackType = Utils.verifcationOfData(sc);


            player1.attack(player2, attackType);

            if (player2.health <= 0) break;


            System.out.println("\n" + "Tura " + player2.name);
            System.out.println("\n" + "Gracz 2:");
            player2.showStats();
            System.out.println("\n" + "Wybierz typ ataku: 1: melee || 2: magic || 3: ranged");
            int enemyAttackType = Utils.verifcationOfData(sc);


            player2.attack(player1, enemyAttackType);
        }

        if (player1.health > 0){
            System.out.println("\n" + player1.name + " Wygrywa PvP");
            player1.levelUp();
        } else{
            System.out.println("\n" + player2.name + " Wygrywa PvP");
            player2.levelUp();
        }


        player1.health = player1.maxHealth;
        player2.health = player2.maxHealth;
    }
}
