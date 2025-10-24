public class Orc extends Character {
    public Orc(String name) {
        super(name);
        this.meleeDamage = 15;
        this.magicDamage = 0;
        this.rangedDamage = 0;
        this.maxHealth = 100;
        this.health = maxHealth;
    }
}
