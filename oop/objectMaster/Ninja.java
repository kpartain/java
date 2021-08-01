public class Ninja extends Human  {
    public Ninja(){
        this.setStealth(10);
    }

    public void steal(Human targetHuman) {
        int thisAmount = this.getStealth();
        targetHuman.setHealth((targetHuman.getHealth() - thisAmount));
        this.setHealth((this.getHealth() + thisAmount));
    }

    public void runAway(){
        this.setHealth((this.getHealth() - 10));
    }
}
