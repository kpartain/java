public class Wizard extends Human {
    public Wizard(){
        this.setHealth(50);
        this.setIntelligence(8);
    }

    public void healHuman(Human targetHuman){
        int newHealth = targetHuman.getHealth() + this.getIntelligence();
        targetHuman.setHealth(newHealth);
    }

    public void fireball(Human targetHuman) {
        int newHealth = targetHuman.getHealth() - (3* this.getIntelligence());
        targetHuman.setHealth(newHealth);
    }
}
