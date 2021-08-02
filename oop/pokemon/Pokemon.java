public class Pokemon {
    private String name;
    private int health;
    private String type;
    public static int numberOfPokemon = 0;
    public Pokemon(String name, int health, String type) {
        this.name = name;
        this.health = health;
        this.type = type;
        numberOfPokemon++;
    }
    public String getName(){
        return this.name;
    }
    public int getHealth(){
        return this.health;
    }
    public String getType(){
        return this.type;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public void setHealth(int newHealth){
        this.health = newHealth;
    }
    public void setType(String newType){
        this.type = newType;
    }
    public void attackPokemon(Pokemon pokemon){
        pokemon.setHealth((pokemon.getHealth() - 10));
    }

}
