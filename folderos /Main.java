import java.util.Scanner;

void main() {
    int running = 1;
    Scanner sc = new Scanner(System.in);
    List<Character> characters = new ArrayList<>();

    while (running > 0){

        System.out.println("Wybierz operację: 1: Kreator postaci || 2: Walka || 3: wyjdź z gry");
        int operacja = sc.nextInt();

        switch (operacja){
            case 1:
                System.out.println("Wybierz klasę: 1: Warrior || 2: Archer || 3: Mage");
                int klasa = sc.nextInt();

                System.out.println("Nazwij swoją postać: ");
                String nazwa = sc.next();

                switch (klasa){
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

                switch (trybGry){
                    case 1:
                        for (Character c : characters){
                            c.showStats();
                            System.out.println();
                        }

                        break;

                    case 2:

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

