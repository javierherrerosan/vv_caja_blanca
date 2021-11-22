package com.practica.cajablanca;

import com.cajanegra.AbstractSingleLinkedListImpl;
import com.cajanegra.EmptyCollectionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestsnumPalabras {
    private final Editor editor= new Editor();

    @ParameterizedTest
    @ValueSource(ints = {0,-5,-1})
    public void emptyPalabras(int inicio){
        assertThrows(java.lang.IllegalArgumentException.class, ()->{
            if (inicio <= 0)
                throw new IllegalArgumentException("La línea de inicio no puede ser menor o igual a cero");
        });
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,5})
    public void notEmptyPalabras(int inicio){
        assertDoesNotThrow(()->{
            if (inicio <= 0)
                throw new IllegalArgumentException("La línea de inicio no puede ser menor o igual a cero");
        });
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2",
            "5, 5"
    })
    public void editorMaxSize(int inicio, int fin){
        if (inicio <= 0)
            throw new IllegalArgumentException("La línea de inicio no puede ser menor o igual a cero");
        assertThrows(java.lang.IllegalArgumentException.class,()->{
            if (fin > this.editor.size())
                throw new IllegalArgumentException("La línea fin no puede ser mayor que el máximo de líneas");
        });
    }
    @ParameterizedTest
    @CsvSource({
            "1, 1"
    })
    public void editorNotMaxSize(int inicio, int fin){
        editor.leerFichero("Ficheros/numPalabras.txt");
        if (inicio <= 0)
            throw new IllegalArgumentException("La línea de inicio no puede ser menor o igual a cero");
        assertDoesNotThrow(()->{
            if (fin > this.editor.size())
                throw new IllegalArgumentException("La línea fin no puede ser mayor que el máximo de líneas");
        });
    }
    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2, 0"
    })
    public void noApariciones(int inicio, int fin){
        if (inicio <= 0)
            throw new IllegalArgumentException("La línea de inicio no puede ser menor o igual a cero");
        if (fin > this.editor.size())
            throw new IllegalArgumentException("La línea fin no puede ser mayor que el máximo de líneas");
        int apariciones = 0;
        if (this.editor.size() > 0){}
        assertEquals(0, apariciones);
    }
    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2, 0"
    })
    public void apariciones(int inicio, int fin){
        editor.leerFichero("Ficheros/numPalabras.txt");
        if (inicio <= 0)
            throw new IllegalArgumentException("La línea de inicio no puede ser menor o igual a cero");
        if (fin > this.editor.size())
            throw new IllegalArgumentException("La línea fin no puede ser mayor que el máximo de líneas");
        int apariciones = 0;
        if (this.editor.size() > 0){
            while (inicio < fin) {}
            assertEquals(0, apariciones);
        }
    }
    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2, 0"
    })
    public void apariciones2(int inicio, int fin) throws EmptyCollectionException {
        editor.leerFichero("Ficheros/numPalabras.txt");
        AbstractSingleLinkedListImpl<String> lista;
        if (inicio <= 0)
            throw new IllegalArgumentException("La línea de inicio no puede ser menor o igual a cero");
        if (fin > this.editor.size())
            throw new IllegalArgumentException("La línea fin no puede ser mayor que el máximo de líneas");
        int apariciones = 0;
        if (this.editor.size() > 0){
            while (inicio < fin) {
                lista = this.editor.getLinea(inicio);
                int pos = 1;
                while (pos <= lista.size()) {}
                inicio++;
            }

            assertEquals(0, apariciones);
        }
    }
}
