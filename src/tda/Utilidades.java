package tda;

import domain.Pokemon;
import java.text.ParseException;

public class Utilidades {

    public static boolean mayorQue(Object e1, Object e2) throws ParseException {
        boolean mayor = false;
        if (e1 instanceof Integer) {
            mayor = (int) e1 > (int) e2;
        }
        if (e1 instanceof String) {
            mayor = String.valueOf(e1).compareToIgnoreCase(String.valueOf(e2)) > 0;
        }
        if (e1 instanceof Character) {
            mayor = String.valueOf(e1).compareToIgnoreCase(String.valueOf(e2)) > 0;
        }
        if (e1 instanceof Pokemon) {
            Pokemon pokemon1 = (Pokemon) e1;
            int pokemonNumber1 = pokemon1.getNumber();
            
            Pokemon pokemon2 = (Pokemon) e2;
            int pokemonNumber2 = pokemon2.getNumber();

            mayor = pokemonNumber1 > pokemonNumber2;
        }
        return mayor;
    }

    public static boolean menorQue(Object e1, Object e2) throws ParseException {
        boolean menor = false;
        if (e1 instanceof Integer) {
            menor = (int) e1 < (int) e2;
        }
        if (e1 instanceof String) {
            menor = String.valueOf(e1).compareToIgnoreCase(String.valueOf(e2)) < 0;
        }
        if (e1 instanceof Character) {
            menor = String.valueOf(e1).compareToIgnoreCase(String.valueOf(e2)) < 0;
        }
        if (e1 instanceof Pokemon) {
            Pokemon pokemon1 = (Pokemon) e1;
            int pokemonNumber1 = pokemon1.getNumber();
            
            Pokemon pokemon2 = (Pokemon) e2;
            int pokemonNumber2 = pokemon2.getNumber();

            menor = pokemonNumber1 < pokemonNumber2;
        }
        return menor;
    }
}
