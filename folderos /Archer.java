import java.util.Scanner;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.maxHealth = 110;
        this.health = maxHealth;
        this.meleeAttack = 15;
        this.rangedAttack = 30;
        this.magicAttack = 10;
    }

    @Override
    public void attack(Character target) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== " + name + " (Archer) ===");
        System.out.println("Wybierz typ ataku: 1 - Melee | 2 - Ranged | 3 - Magic");
        int choice = sc.nextInt();

        int damage = 0;
        String attackType = "";

        switch (choice) {
            case 1:
                damage = getRandomDamage(meleeAttack);
                attackType = "Melee";
                break;
            case 2:
                damage = getRandomDamage(rangedAttack);
                attackType = "Ranged";
                break;
            case 3:
                damage = getRandomDamage(magicAttack);
                attackType = "Magic";
                break;
            default:
                damage = getRandomDamage(rangedAttack);
                attackType = "Ranged";
                break;
        }

        System.out.println(name + " używa " + attackType + " attack i zadaje " + damage + " obrażeń " + target.name + "!");
        target.health -= damage;
        if (target.health < 0) target.health = 0;
        System.out.println(target.name + " ma teraz " + target.health + " HP.");
    }
}
