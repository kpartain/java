public class Gorilla extends Mammal {

    public void throwSomething() {
        System.out.println("The gorilla threw something, energy level decreased by 5");
        this.energyLevel -= 5;
    }

    public void eatBananas(){
        System.out.println("Gorilla likes bananas. Increase energy 10.");
        this.energyLevel += 10;
    }
    
    public void climb(){
        System.out.println("Gorilla climbed a tree, decreases energy by 10");
       this.energyLevel -= 10;
    }

}
