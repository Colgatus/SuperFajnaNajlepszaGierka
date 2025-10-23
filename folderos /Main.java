import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

void main() {
    int running = 1;
    Scanner sc = new Scanner(System.in);
    List<Character> characters = new ArrayList<>();

    while (running > 0){

        System.out.println("\n" + "Wybierz operację: 1: Kreator postaci || 2: Walka || 3: wyjdź z gry");
        int operacja = Utils.verifcationOfData(sc);

        switch (operacja){
            case 1:
                System.out.println("\n" + "Wybierz klasę: 1: Warrior || 2: Archer || 3: Mage");
                int characterClass = Utils.verifcationOfData(sc);

                if (characterClass < 1 || characterClass > 3){
                    System.out.println("\n" + "Nie istnieje taka klasa (wybierz numer 1 || 2 || 3)");
                    break;
                }

                System.out.println("\n" + "Nazwij swoją postać: ");
                String name = sc.next();

                if (name.length() < 4){
                    System.out.println("\n" + "Nazwa postaci wymaga co najmniej 4 znaków");
                    break;
                }else if (name.length() > 20){
                    System.out.println("\n" + "Nazwa postaci nie może być większa niż 20 znaków");
                    break;
                }

                Utils.addCreatedCharactersToTable(characters, characterClass, name);

                break;

            case 2:
                System.out.println("\n" + "Wybierz tryb gry: 1: PvP || 2: PvE");
                int gameMode = Utils.verifcationOfData(sc);

                Utils.chooseGameMode(characters, gameMode);

                break;

            case 3:
                System.out.println("\n" + "Dziękujemy za grę");
                running = 0;
                break;

            default:
                System.out.println("\n" + "Nie istnieje taka operacja (wybierz numer 1 || 2 || 3)");
                break;
        }
    }
}
