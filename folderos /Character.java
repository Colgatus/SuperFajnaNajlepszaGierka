public abstract class Character {
    protected String name;
    protected int level;
    protected int health;
    protected int melee_damage;
    protected int magic_damage;
    protected int ranged_damage;

    public Character(String name, int level, int health, int melee_damage, int magic_damage, int ranged_damage){
        this.name = name;
        this.level = level;
        this.health = health;
        this.melee_damage = melee_damage;
        this.magic_damage = melee_damage;
        this.ranged_damage = ranged_damage;
    }

    public void showStats() {
        System.out.println("=== " + name + " ===");
        System.out.println("Level: " + level);
        System.out.println("Health: " + health);
        System.out.println("Melee: " + melee_damage);
        System.out.println("Magic: " + magic_damage);
        System.out.println("Ranged: " + ranged_damage);
    }
}
