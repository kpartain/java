public interface PokemonInterface {
    Pokemon createPokemon(String name, int health, String type);
    default void pokemonInfo(Pokemon pokemon){
        String newString = "Name: " + pokemon.getName() + ", Health: " + pokemon.getHealth() + ", Type: " + pokemon.getType();
        System.out.println(newString);
    };
    void listPokemon();
}
