public class Warrior extends Character{

    Warrior(String name, int level, int health, int melee_damage, int magic_damage, int ranged_damage){
        super(name, level, health, melee_damage, magic_damage, ranged_damage);
    }
    @Override
    public String toString(){
        return "Name = " + name +
                " | Level = " + level +
                " | Health = " + health +
                " | Melee damage = " + melee_damage +
                " | Doesn't use magic" +
                " | Doesn't use ranged";
    }
}
