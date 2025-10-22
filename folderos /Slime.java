public class Slime extends Character {

    public Slime(String name) {
        super(name);
        this.maxHealth = 60;
        this.health = maxHealth;
        this.meleeAttack = 10;
        this.rangedAttack = 5;
        this.magicAttack = 8;
    }

    @Override
    public void attack(Character target) {
        String[] attackTypes = {"melee", "ranged", "magic"};
        String chosenAttack = attackTypes[rand.nextInt(attackTypes.length)];

        int damage = switch (chosenAttack) {
            case "melee" -> getRandomDamage(meleeAttack);
            case "ranged" -> getRandomDamage(rangedAttack);
            case "magic" -> getRandomDamage(magicAttack);
            default -> getRandomDamage(meleeAttack);
        };

        System.out.println(name + " używa " + chosenAttack + " ataku i zadaje " + damage + " obrażeń " + target.name + "!");
        target.health -= damage;
        if (target.health < 0) target.health = 0;
        System.out.println(target.name + " ma teraz " + target.health + " HP.");
    }
}
