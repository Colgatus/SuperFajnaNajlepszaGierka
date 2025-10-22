import java.util.Scanner;

public class Mage extends Character {

    public Mage(String name) {
        super(name);
        this.maxHealth = 90;
        this.health = maxHealth;
        this.meleeAttack = 10;
        this.rangedAttack = 15;
        this.magicAttack = 35;
    }

    @Override
    public void attack(Character target) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== " + name + " (Mage) ===");
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
                damage = getRandomDamage(magicAttack);
                attackType = "Magic";
                break;
        }

        System.out.println(name + " rzuca " + attackType + " spell i zadaje " + damage + " obrażeń " + target.name + "!");
        target.health -= damage;
        if (target.health < 0) target.health = 0;
        System.out.println(target.name + " ma teraz " + target.health + " HP.");
    }
}
