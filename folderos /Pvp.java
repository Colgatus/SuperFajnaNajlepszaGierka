import java.util.List;
import java.util.Scanner;

public class Pvp{

    public static void pvp(List<Character> characters, int playerOne, int playerTwo, Scanner sc){



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


        while (player1.getHealth() > 0 && player2.getHealth() > 0){

            System.out.println("\n" + "Tura " + player1.getName());
            System.out.println("\n" + "Gracz 1:");
            player1.showStats();
            System.out.println("\n" + "Wybierz typ ataku: 1: melee || 2: magic || 3: ranged");
            int attackType = Utils.verificationOfData(sc);


            player1.attack(player2, attackType);

            if (player2.getHealth() <= 0) break;


            System.out.println("\n" + "Tura " + player2.getName());
            System.out.println("\n" + "Gracz 2:");
            player2.showStats();
            System.out.println("\n" + "Wybierz typ ataku: 1: melee || 2: magic || 3: ranged");
            int enemyAttackType = Utils.verificationOfData(sc);


            player2.attack(player1, enemyAttackType);
        }

        if (player1.getHealth() > 0){
            System.out.println("\n" + player1.getName() + " Wygrywa PvP");
            player1.levelUp();
        } else{
            System.out.println("\n" + player2.getName() + " Wygrywa PvP");
            player2.levelUp();
        }


        player1.healFull();
        player2.healFull();
    }
}
