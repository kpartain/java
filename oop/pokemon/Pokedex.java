import java.util.ArrayList; 

public class Pokedex extends AbstractPokemon {

    private ArrayList<Pokemon> myPokemons;

    public Pokedex(){
        this.myPokemons = new ArrayList<Pokemon>();
    }

    @Override
    public Pokemon createPokemon(String name, int health, String type){
        Pokemon newPokemon = new Pokemon(name, health, type);
        myPokemons.add(newPokemon);
        return newPokemon;
    };

    @Override
    public void listPokemon(){
        for(Pokemon eachPokemon : this.myPokemons){
            System.out.println(eachPokemon.getName());
        }
    }
}
