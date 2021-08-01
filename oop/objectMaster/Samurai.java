public class Samurai extends Human {
    public static int numberOfSamurai = 0;
    public Samurai(){
        this.setHealth(200);
        numberOfSamurai++
    }

    public void dealthBlow(Human targetHuman){
        targetHuman.setHealth(0);
        this.setHealth((this.getHealth()/2));
    }

    public void meditate(){
        this.setHealth((this.getHealth() + (this.getHealth()/2)));
    }

    public int howMany(){
        return numberOfSamurai;
    }
}
