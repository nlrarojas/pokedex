package business;

import data.PokemonData;
import tda.ListaCircularEnlazadaDoble;
import util.IConstants;

public class PokemonBusiness implements IConstants{
    private PokemonData pokemonBusiness;
    
    public PokemonBusiness(){
        this.pokemonBusiness = new PokemonData(POKEMON_FILE_NAME);
    }
    
    public ListaCircularEnlazadaDoble read(){
        return this.pokemonBusiness.read();
    }
}
