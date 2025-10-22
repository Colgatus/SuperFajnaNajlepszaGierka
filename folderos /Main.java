import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

void main() {
    int running = 1;
    Scanner sc = new Scanner(System.in);
    List<Character> characters = new ArrayList<>();

    while (running > 0){

        System.out.println("Wybierz operację: 1: Kreator postaci || 2: Walka || 3: wyjdź z gry");
        int operacja = sc.nextInt();

        switch (operacja) {
            case 1:
                System.out.println("Wybierz klasę: 1: Warrior || 2: Archer || 3: Mage");
                int klasa = sc.nextInt();

                System.out.println("Nazwij swoją postać: ");
                String nazwa = sc.next();

                switch (klasa) {
                    case 1:
                        System.out.println("Utworzono nową postać - " + nazwa);
                        characters.add(new Warrior(nazwa));
                        break;
                    case 2:
                        System.out.println("Utworzono nową postać - " + nazwa);
                        characters.add(new Archer(nazwa));
                        break;
                    case 3:
                        System.out.println("Utworzono nową postać - " + nazwa);
                        characters.add(new Mage(nazwa));
                        break;
                }

                break;

            case 2:
                System.out.println("Wybierz tryb gry: 1: PvP || 2: PvE");
                int trybGry = sc.nextInt();

                switch (trybGry) {
                    case 1:
                        for (Character c : characters) {
                            c.showStats();
                            System.out.println();
                        }
                        
                        break;

                    case 2:
                        Random rand = new Random();

                        System.out.println("Tryb PvE został wybrany!");
                        System.out.println("Wybierz poziom trudności: 1: Łatwy | 2: Normalny | 3: Trudny");
                        int difficulty = sc.nextInt();

                        System.out.println("Wybierz swoją postać:");
                        for (int i = 0; i < characters.size(); i++) {
                            System.out.println(i + ": " + characters.get(i).name);
                        }

                        int playerIndex = sc.nextInt();
                        Character player = characters.get(playerIndex);

                        int waveCount = 1;

                        while (true) {
                            System.out.println("\n==== FALA " + waveCount + " ====");
                            Character enemy;

                            if (waveCount % 5 == 0) {
                                enemy = new Dragon("Dragon");
                            } else {
                                enemy = rand.nextBoolean() ? new Slime("Slime") : new Orc("Orc");
                            }

                            int scale = switch (difficulty) {
                                case 1 -> waveCount / 2;
                                case 2 -> waveCount;    
                                case 3 -> waveCount * 2;
                                default -> waveCount;
                            };

                            for (int i = 1; i < scale; i++) {
                                enemy.silentLevelUp();
                            }

                            System.out.println("Wróg: ");
                            enemy.showStats();
                            System.out.println("Twoja postać:");
                            player.showStats();

                            // Walka turowa
                            while (player.isAlive() && enemy.isAlive()) {
                                player.attack(enemy);
                                if (enemy.isAlive()) {
                                    enemy.attack(player);
                                }
                            }

                            if (player.isAlive()) {
                                System.out.println("Wygrałeś falę " + waveCount + "!");
                                player.levelUp();
                                waveCount++;
                            } else {
                                System.out.println("Zostałeś pokonany na fali " + waveCount + "!");
                                break;
                            }

                            System.out.println("Kontynuować? (1 = tak / 0 = nie)");
                            int kontynuuj = sc.nextInt();
                            if (kontynuuj == 0) break;
                        }
                        break;
                }
                break;

            case 3:
                System.out.println("Dziękujemy za grę");
                running = 0;
                break;

            default:
                System.out.println("error");
                break;
        }
    }
}
