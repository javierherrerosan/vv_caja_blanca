package com.practica.cajablanca;

import com.cajanegra.EmptyCollectionException;
import com.practica.cajablanca.Editor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class mayorLongitudTest {

    @Test
    public void mayorLongitudSize0() throws EmptyCollectionException {
        Editor Ed = new Editor();

        assertEquals(null,Ed.mayorLongitud());

        // El codigo no tira la excepcion que se espera
    }

    @Test
    public void mayorLongitudSize1() throws EmptyCollectionException {
        //Editor de size 1 para que entre en el if final solo una vez
        Editor Ed1 = new Editor();
        Ed1.leerFichero("Ficheros/MayorLongitudSize1Fichero.txt");
        assertEquals("Buenas",Ed1.mayorLongitud());
    }

    @Test
    public  void mayorLongitud2() throws EmptyCollectionException {
        //editor de Size 2 cuya segunda linea sea de mayor longitud que la primera
        Editor Ed2 = new Editor();
        Ed2.leerFichero("Ficheros/MayorLongitudSize2Fichero.txt");
        assertEquals("Buenas",Ed2.mayorLongitud());


    }

    @Test
    public  void mayorLongitud3() throws EmptyCollectionException {
        //editor de Size 2 cuya segunda linea sea de menor longitud que la primera
        Editor Ed3 = new Editor();
        Ed3.leerFichero("Ficheros/MayorLongitudSize3Fichero.txt");
        assertEquals("Buenas",Ed3.mayorLongitud());

    }

}
