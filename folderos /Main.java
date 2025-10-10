import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner newName = new Scanner(System.in);
        String userName;
        System.out.println("Enter username");
        userName = newName.nextLine();

        Warrior warrior = new Warrior(userName, 1, 175, 50, 0, 0);

        int n = 1;
        boolean repeat=false;

        do {
            Scanner newCharacter = new Scanner(System.in);
            String charClass;
            System.out.println("Pick a class: Warrior, Mage, Archer");
            charClass = newCharacter.nextLine();

            n++;
            repeat=false;
            switch (charClass.toLowerCase()) {
                case "warrior":
                    System.out.println(warrior); // after entering "yes" in the second switch, for whatever reason it prints the stats once again
                    break;
                default:
                    System.out.println("No available class selected, try again.");
                    repeat=true;
            }
        } while (repeat);

        int i = 1;
        boolean repeating=false;

        do {
            Scanner encounter = new Scanner(System.in);
            String fight;
            System.out.println("Enter fight? Yes | No");
            fight = encounter.nextLine();

            i++;
            repeating=false;
            switch (fight.toLowerCase()) {
                case "yes":
                    System.out.println(warrior);
                    break;
                case "no":
                    break;
                default:
                    repeating=true;
            }
        } while (repeating);
    }
}
