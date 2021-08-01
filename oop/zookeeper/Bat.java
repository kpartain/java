public class Bat extends Mammal {
    public Bat(){
        this.energyLevel = 300;
    }
    public void fly(){
        System.out.println("Bat flying, lose 50 energy");
        this.energyLevel -= 50;
    }
    public void eatHumans(){
        this.energyLevel += 25;
    }
    public void attackTown(){
        System.out.println("This is getting dark... ");
        this.energyLevel -= 100;
    }
}
