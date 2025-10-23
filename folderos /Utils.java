import java.util.List;
import java.util.Scanner;

public class Utils {

    public static void addCreatedCharactersToTable(List<Character> characters, int characterClass, String name){

        switch (characterClass){

            case 1:

                System.out.println("\n" + "Utworzono nową postać - " + name);
                characters.add(new Warrior(name));
                break;

            case 2:

                System.out.println("\n" + "Utworzono nową postać - " + name);
                characters.add(new Archer(name));
                break;

            case 3:

                System.out.println("\n" + "Utworzono nową postać - " + name);
                characters.add(new Mage(name));
                break;
        }
    }




    public static void showCharactersToChoose(List<Character> characters){

        int i =  0;
        for (Character c : characters) {

            System.out.print("\n" + i + ": ");
            c.showStats();
            System.out.println();
            i++;
        }
    }


    public static void chooseGameMode(List<Character> characters, int gameMode){

        Scanner sc = new Scanner(System.in);

        switch (gameMode){
            case 1:

                Utils.showCharactersToChoose(characters);

                System.out.println("\n" + "Wybierz pierwszego gracza: ");
                int playerOne = sc.nextInt();

                System.out.println("\n" + "Wybierz drugiego gracza: ");
                int playerTwo = sc.nextInt();

                Pvp.pvp(characters, playerOne, playerTwo);

                break;

            case 2:

                Utils.showCharactersToChoose(characters);

                System.out.println("\n" + "Wybierz postać: ");
                int player = sc.nextInt();

                Pve.pve(characters.get(player));

                break;

            default:
                System.out.println("\n" + "Nie istnieje taki tryb gry (wybierz numer 1 || 2)");
        }
    }

    public static int verifcationOfData(Scanner sc){

        int value;

        while (true){

            try{
                value = sc.nextInt();
                sc.nextLine();
                return value;

            }catch (java.util.InputMismatchException e) {
                System.out.println("\n" + "wpisz poprawną liczbę");
                sc.nextLine();
            }
        }
    }

}
