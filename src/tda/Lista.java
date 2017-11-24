package tda;

public interface Lista {

    public int getSize() throws ListaException; // Devuelve el numero de elementos en la lista

    public void annul(); //Elimina toda la lista

    public boolean isEmpty(); // true si la lista esta vacia

    public int getPosicion(Object elemento) throws ListaException; //devuelve la posicion de un elemento en la lista

    public void insert(Object elemento); // Agrega un elemento a la lista en forma secuencial

    public void insertOrdered(Object elemento); // Agrega un elemento a la lista en forma ordenada

    public void suppress(Object elemento) throws ListaException; //Suprime un elemento de la lista

    public boolean exists(Object elemento) throws ListaException; //true si el elemento existe en la lista

    public Object first() throws ListaException; //Devuelve el primer elemento de la lista

    public Object last() throws ListaException; //Devuelve el ultimo elemento de la lista

    //Métodos adicionales  
    public Object previous(Object elemento) throws ListaException; //Devuelve el elemento anterior al actual en la lista

    public Object next(Object elemento) throws ListaException;

    public Nodo getNodeByPosition(int posicion) throws ListaException;// devuelve el elemento en laposicion indicada

    public Nodo getNodeByName(String element) throws ListaException;// devuelve el nodo 
    
    public void radixSortAsc() throws ListaException;
    
    public void radixSortDesc() throws ListaException;
    
    public void mergeSortAsc() throws ListaException;
    
    public void mergeSortDesc() throws ListaException;
    
    public void quickSort() throws ListaException; //Ordena los elementos de la lista
    
    public void bubbleSort() throws ListaException;
}//fin de Interface Lista
