import java.util.List;

public class Runner {
    public static void main(String[] args){
        Pokedex myDex = new Pokedex();
        Pokemon pikachu = myDex.createPokemon("Pikachu", 100, "electric");
        Pokemon chancey = myDex.createPokemon("Ditto", 100, "fairy");
        pikachu.attackPokemon(chancey);
        chancey.attackPokemon(pikachu);
        myDex.listPokemon();
    }
}
