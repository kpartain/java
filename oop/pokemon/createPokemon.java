public interface createPokemon {
    static Pokemon createAPokemon(String name, int health, String type){
        Pokemon createdPokemon = new Pokemon(name, health, type);
        return createdPokemon;
    }
    static String pokemonInfo(Pokemon pokemon){
        String returnString = "Name: " + pokemon.getName() + "\nHealth: " + pokemon.getHealth() + "\nType: " + pokemon.getType();
        return returnString;
    }
    static void listPokemon(Pokedex pokedex){
        String printInOneLine = "";
        for(Pokemon eachPokemon : pokedex) {
            printInOneLine += eachPokemon.getName() + " ";
        }
        System.out.println(printInOneLine);
    }
}
