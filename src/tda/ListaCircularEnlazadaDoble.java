package tda;

import domain.Pokemon;
import java.io.Serializable;

/**
 *
 * @author Juan Carlos Mora B44540
 */
public class ListaCircularEnlazadaDoble implements Lista, Serializable {

    private Nodo startNode;
    private Nodo endNode;

    public ListaCircularEnlazadaDoble() {
        startNode = endNode = null;
    }

    @Override
    public int getSize() {
        if (isEmpty()) {
            return 0;
        }
        Nodo aux = startNode;
        int cont = 0;// para que vaya 1 adelante
        while (aux != endNode) {
            aux = aux.next;
            cont++;
        }
        return cont;
    }

    @Override
    public void annul() {
        startNode = null;
    }

    @Override
    public boolean isEmpty() {
        return startNode == null;
    }

    @Override
    public int getPosicion(Object elemento) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("La lista no existe");
        }
        Nodo aux = startNode;
        int pos = 1;
        while (aux != endNode) {
            if (aux.element.equals(elemento)) {
                return pos;
            }
            aux = aux.next;
            pos++;
        }// se sale delwhile cuando sellega al ultimo nodo

        if (aux.element.equals(elemento)) {
            return pos;
        }
        return -1; // el elemento no existe

    }

    @Override
    public Nodo getNodeByPosition(int posicion) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("La lista no existe");
        }
        Nodo aux = startNode;
        int pos = 1;
        while (aux != endNode) {
            if (pos == posicion) {
                return aux;
            }
            aux = aux.next;
            pos++;
        }
        if (pos == posicion) {
            return aux;
        }
        return null;//no existe laposicion
    }

    @Override
    public Nodo getNodeByName(String elemento) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("La lista no existe");
        }
        Nodo aux = startNode;        
        while (aux != endNode) {
            Pokemon pokemon = (Pokemon) aux.element;
            if (pokemon.getName().equalsIgnoreCase(elemento)) {
                return aux;
            }
            aux = aux.next;
        }
        if (aux.element.equals(elemento)) {
            return aux;
        }
        return null;//no existe elemento
    }

    @Override
    public void insert(Object elemento) {
        Nodo nuevoNodo = new Nodo(elemento);
        if (startNode == null) {
            startNode = nuevoNodo;
            startNode.ant = startNode.next = nuevoNodo;
        } else {
            Nodo aux = startNode;
            while (aux.next != startNode) {
                aux = aux.next;
            }//while
            //se sale del while cuando aux ==fin
            nuevoNodo.next = aux.next;
            aux.next.ant = nuevoNodo;
            aux.next = nuevoNodo;
            nuevoNodo.ant = aux;//se conecta con el nodo anterior
            //hacemos que fin apunte al nuevo nodo
            endNode = nuevoNodo;
            //hacemos enlace circular
            endNode.next = startNode;
        }//else
    }//insertar

    @Override
    public void insertOrdered(Object elemento) {

        Nodo nuevoNodo = new Nodo(elemento);
        if (startNode == null) {
            startNode = endNode = nuevoNodo;
        } else if (startNode.next == endNode.next && esMayorQ(startNode.element, elemento)) {
            nuevoNodo.next = startNode;
            startNode.ant = nuevoNodo;
            startNode = nuevoNodo;
            endNode.next = startNode;//enlace circular
            startNode.ant = endNode;
        } else if (startNode.next == endNode.next && !esMayorQ(startNode.element, elemento)) {
            startNode.next = nuevoNodo;
            nuevoNodo.ant = startNode;
            endNode = nuevoNodo;
            endNode.next = startNode;//enlace circula
            startNode.ant = endNode;
        } else if (esMayorQ(startNode.element, elemento)) {
            nuevoNodo.next = startNode;
            startNode.ant = nuevoNodo;
            startNode = nuevoNodo;
            endNode.next = startNode;//enlace circular
            startNode.ant = endNode;
        } else {
            boolean insertado = false;
            Nodo nodoAnterior = startNode;//un nodo atras
            Nodo aux = startNode.next;
            while (aux != endNode && !insertado) {
                if (esMayorQ(aux.element, elemento)) {
                    nodoAnterior.next = nuevoNodo;
                    nuevoNodo.ant = nodoAnterior;
                    nuevoNodo.next = aux;
                    aux.ant = nuevoNodo;
                    insertado = true;
                }
                nodoAnterior = aux;
                aux = aux.next;
            }//while
            if (!insertado) {
                if (esMayorQ(aux.element, elemento)) {
                    nodoAnterior.next = nuevoNodo;
                    nuevoNodo.ant = nodoAnterior;
                    nuevoNodo.next = aux;
                    aux.ant = nuevoNodo;
                }//if
                else {
                    aux.next = nuevoNodo;
                    nuevoNodo.ant = aux;
                    endNode = nuevoNodo;
                    endNode.next = startNode;
                    startNode.ant = endNode;
                }//else
            }//if(!insertado)
        }//else
        //hacemos el enlace circular
        endNode.next = startNode;

    }

    private boolean esMayorQ(Object a, Object b) {
        switch (instanceOf(a, b)) {
            case "entero":
                int x = (int) a;
                int y = (int) b;
                return x > y;
            case "String":
                String p = (String) a;
                String q = (String) b;
                return p.compareToIgnoreCase(q) > 0;
        }
        return false;
    }

    public String instanceOf(Object a, Object b) {
        if (a instanceof Integer && b instanceof Integer) {
            return "entero";
        }
        if (a instanceof String && b instanceof String) {
            return "String";
        }
        if (a instanceof Integer && b instanceof Integer) {
            return "entero";
        }
        return "desconocido";
    }

    @Override
    public void suppress(Object elemento) throws ListaException {
        //Este metodo elimina todas las ocurrencias  del elemento
        if (isEmpty()) {
            throw new ListaException("La lista no existe");
        }        
        if (startNode == endNode && startNode.element.equals(elemento)) {
            this.annul();// Anulo la lista
        } else if (startNode.element.equals(elemento)) {
            startNode = startNode.next;
            startNode.ant = endNode;
        } else {
            Nodo aux = startNode;
            Nodo ant = null;
            while (aux != endNode && !aux.element.equals(elemento)) {
                ant = aux;
                aux = aux.next;
            }
            //se sale del while cuando alcanza el nodo=fin o encuentra el elemento
            if (aux.element.equals(elemento)) {
                ant.next = aux.next; // Me salto el nodo apuntado por auxiliar
                aux.next.ant = ant;
            }
            //me aseguro que fin apunte al ultimo nodo de la lista
            if (aux == endNode) {
                endNode = ant;//dejo fin apuntando al ultimo
            }
        }
        //mantengo el enlace circular
        endNode.next = startNode;
    }

    @Override
    public boolean exists(Object elemento) throws ListaException {
        Nodo aux = startNode;
        while (aux != endNode) {
            if (aux.element.equals(elemento)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    @Override
    public Object first() throws ListaException {
        if (isEmpty()) {
            throw new ListaException("La lista esta vacia");
        }
        return startNode.element;
    }

    @Override
    public Object last() throws ListaException {
        Nodo aux = startNode;
        while (aux != endNode) {
            aux = aux.next;
        }
        return aux.element;
    }

    @Override
    public Object previous(Object elemento) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("La lista esta vacia");
        }
        if (startNode.element.equals(elemento)) {
            return endNode.element;
        } else {
            Nodo aux = startNode.next;
            Nodo ant = startNode;
            while (aux != endNode) {
                if (aux.ant.element.equals(elemento)) {
                    return ant.ant.element;
                } else if (aux.element.equals(elemento)) {
                    return ant.element;
                } else {
                    ant = aux;
                    aux = aux.next;
                }

            }
            if (aux.element.equals(elemento)) {
                return ant.element;
            }
        }
        return "El elemento no existe";

    }

    @Override
    public Object next(Object elemento) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("La lista esta vacia");
        } else {
            Nodo aux = startNode;
            Nodo post = startNode.next;
            while (aux != endNode) {
                if (aux.element.equals(elemento)) {
                    if (post != endNode) {
                        return post.element;
                    } else {
                        return startNode.element;
                    }
                } else {
                    aux = aux.next;
                    if (aux != null) {
                        post = aux.next;
                    }
                }
            }
            if (aux.element.equals(elemento)) {
                return aux.next.element;
            }
        }
        return "El elemento no existe";
    }

    @Override
    public void radixSortAsc() throws ListaException {
        Pokemon [] arr = toArray();
        radixSortAsc(arr);
        toList(arr);
    }
    //usando burbuja
    private void radixSortAsc(Pokemon pokemonsNames[]) {
        int j;
        boolean flag = true;  // will determine when the sort is finished
        Pokemon temp;

        while (flag) {
            flag = false;
            for (j = 0; j < pokemonsNames.length - 1; j++) {
                if (pokemonsNames[j].getName().compareToIgnoreCase(pokemonsNames[j + 1].getName()) > 0) {                                             // ascending sort
                    temp = pokemonsNames[j];
                    pokemonsNames[j] = pokemonsNames[j + 1];     // swapping
                    pokemonsNames[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }
    
    @Override
    public void radixSortDesc() throws ListaException {
        Pokemon [] arr = toArray();
        radixSortDesc(arr);
        toList(arr);
    }
    //usando burbuja
    private void radixSortDesc(Pokemon pokemonsNames[]) {
        int j;
        boolean flag = true;  // will determine when the sort is finished
        Pokemon temp;

        while (flag) {
            flag = false;
            for (j = 0; j < pokemonsNames.length - 1; j++) {
                if (pokemonsNames[j].getName().compareToIgnoreCase(pokemonsNames[j + 1].getName()) < 0) {                                             // ascending sort
                    temp = pokemonsNames[j];
                    pokemonsNames[j] = pokemonsNames[j + 1];     // swapping
                    pokemonsNames[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }

    @Override
    public void mergeSortAsc() throws ListaException {
        pokemonMergeArray = toArray();
        helperPokemonMergeArray = new Pokemon[pokemonMergeArray.length];
        mergesortAsc(0, pokemonMergeArray.length - 1);
        toList(helperPokemonMergeArray);
    }
    
    private Pokemon[] pokemonMergeArray;
    private Pokemon[] helperPokemonMergeArray;
    
    private void mergesortAsc(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergesortAsc(low, middle);
            mergesortAsc(middle + 1, high);
            mergeAsc(low, middle, high);
        }
    }

    private void mergeAsc(int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            helperPokemonMergeArray[i] = pokemonMergeArray[i];
        }
        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (helperPokemonMergeArray[i].getHeight() <= helperPokemonMergeArray[j].getHeight()) {
                pokemonMergeArray[k] = helperPokemonMergeArray[i];
                i++;
            } else {
                pokemonMergeArray[k] = helperPokemonMergeArray[j];
                j++;
            }
            k++;
        }        
        while (i <= middle) {
            pokemonMergeArray[k] = helperPokemonMergeArray[i];
            k++;
            i++;
        }        
    }

    @Override
    public void mergeSortDesc() throws ListaException {                
        pokemonMergeArray = toArray();
        helperPokemonMergeArray = new Pokemon[pokemonMergeArray.length];
        mergesortDesc(0, pokemonMergeArray.length - 1);
        toList(helperPokemonMergeArray);
    }       
    
    private void mergesortDesc(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergesortDesc(low, middle);
            mergesortDesc(middle + 1, high);
            mergeDesc(low, middle, high);
        }
    }

    private void mergeDesc(int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            helperPokemonMergeArray[i] = pokemonMergeArray[i];
        }
        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (helperPokemonMergeArray[i].getHeight() >= helperPokemonMergeArray[j].getHeight()) {
                pokemonMergeArray[k] = helperPokemonMergeArray[i];
                i++;
            } else {
                pokemonMergeArray[k] = helperPokemonMergeArray[j];
                j++;
            }
            k++;
        }        
        while (i <= middle) {
            pokemonMergeArray[k] = helperPokemonMergeArray[i];
            k++;
            i++;
        }        
    }

    @Override
    public void quickSort() throws ListaException {
        Pokemon arr[] = toArray();
        quickSortAux(arr, 0, getSize() - 1);
        toList(arr);
    }

    private void quickSortAux(Pokemon arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSortAux(arr, low, pi - 1);
            quickSortAux(arr, pi + 1, high);
        }
    }

    //Revisar si es de mayor a menor
    int partition(Pokemon arr[], int low, int high) {
        float pivot = arr[high].getWeight();
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (arr[j].getWeight() >= pivot) {
                i++;
                Pokemon temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Pokemon temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    @Override
    public void bubbleSort() throws ListaException {
        Pokemon arr[] = toArray();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].getNumber() > arr[j + 1].getNumber()) {
                    Pokemon temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        toList(arr);
    }

    private Pokemon[] toArray() {
        Pokemon arr[] = new Pokemon[getSize() + 1];
        Nodo aux = startNode;

        int i = 0;
        while (aux != endNode) {
            arr[i] = (Pokemon) aux.element;
            aux = aux.next;
            if (aux == endNode) {
                arr[++i] = (Pokemon) aux.element;
            }
            i++;
        }
        return arr;
    }

    private void toList(Pokemon[] arr) {
        annul();
        for (Pokemon arr1 : arr) {
            insert(arr1);
        }
    }

    public void printList() {
        Nodo aux = startNode;
        while (aux != endNode) {
            Pokemon pokemon = (Pokemon) aux.element;
            System.out.println(pokemon.getNumber() + " " + pokemon.getName() + " " + pokemon.getHeight() + " " + pokemon.getWeight());
            aux = aux.next;
            if (aux == endNode) {
                pokemon = (Pokemon) aux.element;
                System.out.println(pokemon.getNumber() + " " + pokemon.getName() + " " + pokemon.getHeight() + " " + pokemon.getWeight());
            }
        }
    }
}
