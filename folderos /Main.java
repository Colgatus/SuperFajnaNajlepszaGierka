import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner newName = new Scanner(System.in);
        String userName;
        System.out.println("Enter username");
        userName = newName.nextLine();

        Warrior warrior = new Warrior(userName, 1, 175, 50, 0, 0);

        int n = 1;
        boolean repeatChar=false;

        do {
            Scanner newCharacter = new Scanner(System.in);
            String charClass;
            System.out.println("Pick a class: Warrior, Mage, Archer");
            charClass = newCharacter.nextLine();

            n++;
            repeatChar=false;
            switch (charClass.toLowerCase()) {
                case "warrior":
                    System.out.println(warrior);
                    break;
                default:
                    System.out.println("No available class selected, try again.");
                    repeatChar=true;
            }
        } while (repeatChar);

        int i = 1;
        boolean repeatFight=false;

        do {
            Scanner encounter = new Scanner(System.in);
            String fight;
            System.out.println("Enter fight? Yes | No");
            fight = encounter.nextLine();

            i++;
            repeatFight=false;
            switch (fight.toLowerCase()) {
                case "yes":
                    System.out.println("Fight start!");
                    break;
                case "no":
                    break;
                default:
                    repeatFight=true;
            }
        } while (repeatFight);
    }
}
