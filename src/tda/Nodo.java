package tda;

import java.io.Serializable;

public class Nodo implements Serializable {

    //Atributos
    public Object element; //informacion del nodo
    public Nodo ant, next; //apuntador

    //Constructor No. 1
    public Nodo(Object elemento) {
        this.element = elemento;
        this.ant = this.next = null;
    }//Constructor
}//fin de la clase Nodo
