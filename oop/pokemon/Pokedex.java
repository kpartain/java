public class Pokedex extends AbstractPokemon {
    private ArrayList<Pokemon> myPokemons = new ArrayList<Pokemon>();
    public void createAPokemon(String name, int health, String type){
        Pokemon newPokemon = new Pokemon(name, health, type);
        myPokemons.add(newPokemon);
    }
    private ArrayList<Pokemon> getMyPokemons(){
        return this.myPokemons;
    }
    public void listPokemon(){
        Pokedex thisPokedex = this.getMyPokemons();
        listPokemon(thisPokedex);
    }
}
