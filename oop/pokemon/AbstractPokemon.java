import java.util.ArrayList;

public abstract class AbstractPokemon implements PokemonInterface {
    public abstract void listPokemon();

    public abstract Pokemon createPokemon(String name, int health, String type);
}
