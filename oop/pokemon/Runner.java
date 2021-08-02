public class Runner {
    public static void main(String[] args){
        Pokemon pikachu = createAPokemon("Pikachu", 100, "electric");
        Pokemon chancey = createAPokemon("Ditto", 100, "fairy");
        pikachu.attackPokemon(chancey);
        chancey.attackPokemon(pikachu);
        listPokemon();
    }
}
