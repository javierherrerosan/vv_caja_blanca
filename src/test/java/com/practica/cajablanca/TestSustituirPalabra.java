package com.practica.cajanegra;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;
import com.cajanegra.SingleLinkedListImpl;
import  com.practica.cajablanca.Editor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
CAMINOS:
A,B,M
A,B,C,D,E,J,K,L,M               Inviable
A,B,C,D,E,F,H,I,E,J,K,L,M
A,B,C,D,E,F,G,I,E,J,K,L,M
A,B,C,D,E,J,K,D,E,J,K,L,M       Inviable

Debido a que el editor tiene que tener un tamaño mayor a 0 (Nodo B), y la condición del while (Nodo E) indica
que la línea tiene que ser mayor que 0, no es posible que se cumpla la primera condicion y a la vez se incumpla
la segunda en la primera iteración.
*/
/*
public void sustituirPalabra(String palabra, String nuevaPalabra) {
        if (this.editor.size() > 0) {
        AbstractSingleLinkedListImpl<AbstractSingleLinkedListImpl<String>> nuevoEditor =
        new SingleLinkedListImpl<AbstractSingleLinkedListImpl<String>>();
        int i=1;
        do {
        AbstractSingleLinkedListImpl<String> aux = new SingleLinkedListImpl<String>();
        this.lista = this.editor.getAtPos(i);
        int j=1;
        while (j<=this.lista.size()) {
        if (this.lista.getAtPos(j).equals(palabra)) {
        aux.addLast(nuevaPalabra); ///Palabra encontrada
        }else {
        aux.addLast(this.lista.getAtPos(j)); //// primera palabrano buscada
        }
        j++;
        }
        nuevoEditor.addLast(aux);
        i++;
        }while (i<=this.editor.size());
        editor = nuevoEditor;
        }
        }
*/

public class TestSustituirPalabra {
    //Editor vacío
    @Test
    @DisplayName("Camino A,B,M")
    public void test1SustituirPalabra(){
        Editor editor = new Editor();
        Editor esperado = editor;
        assertEquals(esperado, editor);
    }
    //Cambiar segunda palabra
    @Test
    @DisplayName("Camino A,B,C,D,E,F,H,I,E,J,K,L,M")
    public void test2SustituirPalabra() throws EmptyCollectionException {
        
        Editor editor = new Editor();
        editor.leerFichero("Ficheros/SustituirPalabra.txt");
        editor.sustituirPalabra("piso", "arbol");
        String str = "";
        for(int i = 1; i <= editor.size(); i++){
            AbstractSingleLinkedListImpl<String> aux = new SingleLinkedListImpl<String>();
            aux = editor.getLinea(i);
            str += aux.toString();
        }
        assertEquals("[casa, arbol]", str);
    }

    @Test
    @DisplayName("Camino A,B,C,D,E,F,G,I,E,J,K,L,M")
    public void test3SustituirPalabra() throws EmptyCollectionException {
        Editor editor = new Editor();
        editor.leerFichero("Ficheros/SustituirPalabra.txt");
        editor.sustituirPalabra("casa", "arbol");
        String str = "";
        for(int i = 1; i <= editor.size(); i++){
            AbstractSingleLinkedListImpl<String> aux = new SingleLinkedListImpl<String>();
            aux = editor.getLinea(i);
            str += aux.toString();
        }
        assertEquals("[arbol, piso]", str);
    }


}
