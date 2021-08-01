public class Human {
    private int strength;
    private int intelligence;
    private int stealth;
    private int health;
    public Human(){
        this.strength = 3;
        this.intelligence = 3;
        this.stealth = 3;
        this.health = 100;
    }
    public int getStrength(){
        return this.strength;
    }
    public int getIntelligence(){
        return this.intelligence;
    }
    public int getStealth(){
        return this.stealth;
    }
    public int getHealth(){
        return this.health;
    }
    public void setStrength(int newValue){
        this.strength = newValue;
    }
    public void setIntelligence(int newValue){
        this.intelligence = newValue;
    }
    public void setStealth(int newValue){
        this.stealth = newValue;
    }
    public void setHealth(int newValue){
        this.health = newValue;
    }
    public void attack(Human attackTarget){
        int newHealth = attackTarget.getHealth() - this.getStrength();
        attackTarget.setHealth(newHealth);
    }
}
