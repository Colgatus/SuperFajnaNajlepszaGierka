public class Character {
    public String name;
    public int level;
    public int health;
    public int melee_damage;
    public int magic_damage;
    public int ranged_damage;

    public Character(String name, int level, int health, int melee_damage, int magic_damage, int ranged_damage){
        this.name = name;
        this.level = level;
        this.health = health;
        this.melee_damage = melee_damage;
        this.magic_damage = magic_damage;
        this.ranged_damage = ranged_damage;
    }
}
