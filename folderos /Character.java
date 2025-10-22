import java.util.Random;

public abstract class Character {
    protected String name;
    protected int level;
    protected int maxHealth;
    protected int health;
    protected int meleeAttack;
    protected int rangedAttack;
    protected int magicAttack;
    protected Random rand = new Random();

    public Character(String name) {
        this.name = name;
        this.level = 1;
        this.maxHealth = 100;
        this.health = maxHealth;
    }

    public boolean isAlive() {
        return health > 0;
    }

    protected int getRandomDamage(int baseDamage) {
        int min = (int) (baseDamage * 0.75);
        int max = (int) (baseDamage * 1.25);
        return rand.nextInt(max - min + 1) + min;
    }

    public abstract void attack(Character target);

    public void showStats() {
        System.out.println(name + " | LVL: " + level + " | HP: " + health + "/" + maxHealth +
                " | Melee: " + meleeAttack +
                " | Ranged: " + rangedAttack +
                " | Magic: " + magicAttack);
    }

    public void levelUp() {
        this.level++;
        this.maxHealth += 20;
        this.health = this.maxHealth;
        this.meleeAttack += 2;
        this.rangedAttack += 2;
        this.magicAttack += 2;
        System.out.println(name + " awansuje na poziom " + level + "! Statystyki zwiększone.");
    }

    public void silentLevelUp() {
        this.level++;
        this.health += 20;
        this.meleeAttack += 2;
        this.rangedAttack += 2;
        this.magicAttack += 2;
    }

}
