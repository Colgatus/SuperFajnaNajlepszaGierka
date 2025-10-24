public abstract class Character implements Attackable {
    protected String name;
    protected int level;
    protected int maxHealth;
    protected int health;
    protected int meleeDamage;
    protected int magicDamage;
    protected int rangedDamage;

    public Character(String name) {
        this.name = name;
        this.level = 1;
        this.maxHealth = 100;
        this.health = maxHealth;
        this.meleeDamage = 10;
        this.magicDamage = 10;
        this.rangedDamage = 10;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getMeleeDamage() {
        return meleeDamage;
    }

    public int getMagicDamage() {
        return magicDamage;
    }

    public int getRangedDamage() {
        return rangedDamage;
    }



    public void showStats() {
        System.out.println(name + " || LVL: " + level + " || HP: " + health + "/" + maxHealth +
                " || Melee: " + meleeDamage +
                " || Magic: " + magicDamage +
                " || Ranged: " + rangedDamage);
    }

    public void levelUp() {
        level++;
        maxHealth += 20;
        health = maxHealth;
        meleeDamage += 5;
        magicDamage += 5;
        rangedDamage += 5;
        System.out.println(name + " awansował na poziom " + level + "!");
        showStats();
    }

    public void healFull() {
        health = maxHealth;
    }


    @Override
    public void attack(Character target, int attackType) {
        int damage;
        String attackName;
        switch (attackType) {
            case 1:
                damage = meleeDamage;
                attackName = "uderza wręcz";
                break;
            case 2:
                damage = magicDamage;
                attackName = "uderza zaklęciem";
                break;
            case 3:
                damage = rangedDamage;
                attackName = "uderza strzałem";
                break;
            default:
                System.out.println("Nieznany typ ataku!");
                return;
        }
        System.out.println(name + " atakuje " + target.name + " " + attackName + " za " + damage + " obrażeń");
        target.health -= damage;
    }
}
