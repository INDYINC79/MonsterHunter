package livingThings;
abstract class LivingThings {
    String name;
    double attackPower;
    double health;
    String weapon;
    public abstract boolean isAlive(LivingThings things);
    public abstract double attack(LivingThings things);
    public static void main(String[] args) {
        Hero nick = new Hero("Nick", "Mace");
        LivingThings[] creatures = new LivingThings[4];
        creatures[0] = new Ogre("Ogre", "Club");
        creatures[1] = new Goblin("Goblin", "Spear");
        creatures[2] = new Rat("Tiny", "Claws");
        creatures[3] = new Rat("Biggie", "Claws");
        
        nick.fight(creatures);
    }
    
    public LivingThings[] deleteValueArray(LivingThings[] monsters, LivingThings monster){
        int smallArrayLength = monsters.length-1;
        LivingThings[] smallArray = new LivingThings[smallArrayLength];
        for (int i = 0, j = 0; i < monsters.length; i++){
            if(!(monsters[i] == monster)){
                smallArray[j] = monsters[i];
                j++;
            }
        }
        System.out.println(monster.name + " is dead!");
        return smallArray;
    }
    
}
class Rat extends LivingThings {
    int tailLength;
    public Rat(String name, String weapon) {
        this.name = name;
        this.weapon = weapon;
        this.health = 60;
        this.attackPower = 5;
    }
    public double attack(LivingThings hero) {
        double attackMultiplier = Math.random() * 2;
        if(attackMultiplier == 2){
            System.out.println("CRITICAL HIT!");
        }
        double modifiedAttackPower = Math.floor(this.attackPower * attackMultiplier);
        hero.health -= modifiedAttackPower;
        return modifiedAttackPower;
    }
    public boolean isAlive(LivingThings monster) {
        if (this.health > 0) {
            return true;
        } else {
            return false;
        }
    }
}
class Ogre extends LivingThings {
    int piercings;
    public Ogre(String name, String weapon) {
        this.name = name;
        this.weapon = weapon;
        this.health = 120;
        this.attackPower = 30;
    }
    public double attack(LivingThings hero) {
        double attackMultiplier = Math.random() * 2;
        if(attackMultiplier >= 1.5){
            System.out.println("CRITICAL HIT!");
        }
        double modifiedAttackPower = Math.floor(this.attackPower * attackMultiplier);
        hero.health -= modifiedAttackPower;
        return modifiedAttackPower;
    }
    public boolean isAlive(LivingThings monster) {
        if (this.health > 0) {
            return true;
        } else {
            return false;
        }
    }
}
class Goblin extends LivingThings {
    String hairColor;
    public Goblin(String name, String weapon) {
        this.name = name;
        this.weapon = weapon;
        this.health = 80;
        this.attackPower = 10;
    }
    public double attack(LivingThings hero) {
        double attackMultiplier = Math.random() * 2;
        if(attackMultiplier == 2){
            System.out.println("CRITICAL HIT!");
        }
        double modifiedAttackPower = Math.floor(this.attackPower * attackMultiplier);
        hero.health -= modifiedAttackPower;
        return modifiedAttackPower;
    }
    public boolean isAlive(LivingThings monster) {
        if (this.health > 0) {
            return true;
        } else {
            return false;
        }
    }
}
class Hero extends LivingThings {
//Attacks a random monster in the array
    public void fight(LivingThings[] monsters) {
        while (this.isAlive(this) && monsters.length > 0) {

            int randomNum = (int) (Math.random() * monsters.length);
            if (monsters[randomNum].isAlive(monsters[randomNum])) {
                double attackDamage = this.attack(monsters[randomNum]);
                System.out.println(
                        this.name + " attacks " + monsters[randomNum].name + " for " + attackDamage + " damage.  "
                                + monsters[randomNum].name + " health is now " + monsters[randomNum].health + "!");
            } 
            if (monsters[randomNum].isAlive(monsters[randomNum])) {
                double attackDamage = monsters[randomNum].attack(this);
                System.out.println(monsters[randomNum].name + " attacks " + this.name + " for " + attackDamage + " damage. "
                        + this.name + " health is now " + this.health + "!\n");
            }else{
                monsters = deleteValueArray(monsters, monsters[randomNum]);
            }
        }
    }
//Always attacks monsters in order of the array 
    
//  public void fight(LivingThings[] monsters) {
//      while (this.isAlive(this)) {
//          boolean anyAlive = false;
//          for (int i = 0; i < monsters.length; i++) {
//              if (monsters[i].isAlive(monsters[i])) {
//                  anyAlive = true;
//                  double attackDamage = this.attack(monsters[i]);
//                  System.out.println(this.name + " attacks " + monsters[i].name + " for " + attackDamage + " damage. "
//                          + monsters[i].name + " health is now " + monsters[i].health + "!");
//              } else {
//                  System.out.println(monsters[i].name + " is super dead!");
//              }
//
//              if (monsters[i].isAlive(monsters[i])) {
//                  double attackDamage = monsters[i].attack(this);
//                  System.out.println(monsters[i].name + " attacks " + this.name + " for " + attackDamage + " damage. "
//                          + this.name + " health is now " + this.health + "!\n");
//              }
//          }
//          if (!anyAlive) {
//              return;
//          }
//      }
//  }
    public double attack(LivingThings monster) {
        double attackMultiplier = (Math.random() * 2);
        double modifiedAttackPower = Math.floor(this.attackPower * attackMultiplier);
        monster.health -= modifiedAttackPower;
        return modifiedAttackPower;
    }
    public Hero(String name, String weapon) {
        this.name = name;
        this.weapon = weapon;
        this.health = 275;
        this.attackPower = 20;
    }
    public boolean isAlive(LivingThings hero) {
        if (this.health >= 0) {
            return true;
        }
        return false;
    }
}