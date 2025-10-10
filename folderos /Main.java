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
            System.out.println("Pick a class: melee, magic, ranged");
            charClass = newCharacter.nextLine();

            n++;
            repeat=false;
            switch (charClass.toLowerCase()) {
                case "melee":
                    System.out.println(warrior);
                    break;
                default:
                    System.out.println("No available class selected, try again.");
                    repeat=true;
            }
        } while (repeat);
    }
}
