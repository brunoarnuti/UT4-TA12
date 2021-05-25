import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import tdas.*;
import universidad.Alumno;
import universidad.Carrera;

public class TArbolBBUtest{

    TArbolBBU arbolito;
    Lista<Carrera> carreras;

    @BeforeEach
    public void setUp() throws Exception{

        //Arbol de entrada
        arbolito = new TArbolBBU();
        carreras = new Lista<Carrera>();

        TElementoAB<Alumno> alumno = new TElementoAB<>("50757706", new Alumno(50757706, "Gonzalez", "Medicina"));
        TElementoAB<Alumno> alumno1 = new TElementoAB<>("51017676", new Alumno(51017676, "Arnuti", "Ing. Informatica"));
        TElementoAB<Alumno> alumno2 = new TElementoAB<>("52345678", new Alumno(52345678, "Ruiz", "Tecnologo carnico"));
        TElementoAB<Alumno> alumno3 = new TElementoAB<>("51018326", new Alumno(51018326, "Ruibal", "Psicología"));
        TElementoAB<Alumno> alumno4 = new TElementoAB<>("50757701", new Alumno(50757701, "Gomez", "Lic. Fisica"));

        arbolito.insertar(alumno);
        arbolito.insertar(alumno1);
        arbolito.insertar(alumno2);
        arbolito.insertar(alumno3);
        arbolito.insertar(alumno4);
    }

//    @Test
//    @DisplayName("Test para validar que cambie el tamaño de carreras")
//    public void test1() {
//        assertEquals(5, arbolito.armarIndicesCarreras(carreras).cantElementos());
//    }
//    @Test
//    @DisplayName("Test para validar")
//    public void test1() {
//        assertEquals(, , );
//    }
//    @Test
//    @DisplayName("Test para validar")
//    public void test1() {
//        assertEquals(, , );
//    }
//    @Test
//    @DisplayName("Test para validar")
//    public void test1() {
//        assertEquals(, , );
//    }
//    @Test
//    @DisplayName("Test para validar")
//    public void test1() {
//        assertEquals(, , );
//    }
}


