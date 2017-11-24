package data;

import domain.Pokemon;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import tda.ListaCircularEnlazadaDoble;

/**
 *
 * @author Nelson
 */
public class PokemonData {

    private String fileName;

    public PokemonData(String pFileName) {
        this.fileName = pFileName;
    }

    public ListaCircularEnlazadaDoble read() {
        ListaCircularEnlazadaDoble listaPokemones = new ListaCircularEnlazadaDoble();
        try {
            try (FileReader textFileReader = new FileReader(fileName)) {
                BufferedReader bufReader = new BufferedReader(textFileReader);

                String line = bufReader.readLine();
                while (line != null) {
                    String [] pokemonRow = line.split(";");
                    Pokemon pokemon = new Pokemon(Integer.parseInt(pokemonRow[0]), pokemonRow[1], pokemonRow[2], pokemonRow[3], pokemonRow[4], pokemonRow[5], 
                            pokemonRow[6], pokemonRow[7], pokemonRow[8], pokemonRow[9], pokemonRow[10], Float.parseFloat(pokemonRow[11]), 
                            Float.parseFloat(pokemonRow[12]), pokemonRow[13], pokemonRow[14], pokemonRow[15], Integer.parseInt(pokemonRow[16]));
                    listaPokemones.insert(pokemon);
                    line = bufReader.readLine();
                }                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaPokemones;
    }
}
