public class Orc extends Character {

    public Orc(String name) {
        super(name);
        this.maxHealth = 100;
        this.health = maxHealth;
        this.meleeAttack = 25;
        this.rangedAttack = 10;
        this.magicAttack = 5;
    }

    @Override
    public void attack(Character target) {
        String[] attackTypes = {"melee", "ranged"};
        String chosenAttack = attackTypes[rand.nextInt(attackTypes.length)];

        int damage = switch (chosenAttack) {
            case "melee" -> getRandomDamage(meleeAttack);
            case "ranged" -> getRandomDamage(rangedAttack);
            default -> getRandomDamage(meleeAttack);
        };

        System.out.println(name + " wykonuje " + chosenAttack + " ataku i zadaje " + damage + " obrażeń " + target.name + "!");
        target.health -= damage;
        if (target.health < 0) target.health = 0;
        System.out.println(target.name + " ma teraz " + target.health + " HP.");
    }
}
