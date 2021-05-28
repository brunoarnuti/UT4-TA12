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

    @Test
    @DisplayName("Test para validar que cambie el tamaño de carreras")
    public void test1() {
        arbolito.armarIndicesCarreras(carreras);
        assertEquals(5,carreras.cantElementos());
    }

    @Test
    @DisplayName("Test para validar que pasa cuando todos los alumnos tienen solo una carrera")
    public void test2() {
        arbolito = new TArbolBBU();

        TElementoAB<Alumno> alumno3 = new TElementoAB<>("51018326", new Alumno(51018326, "Ruibal", "Psicología"));
        TElementoAB<Alumno> alumno5 = new TElementoAB<>("51018326", new Alumno(51018326, "Ruibal", "Psicología"));
        TElementoAB<Alumno> alumno6 = new TElementoAB<>("51018326", new Alumno(51018326, "Ruibal", "Psicología"));

        arbolito.insertar(alumno3);
        arbolito.insertar(alumno5);
        arbolito.insertar(alumno6);
        arbolito.armarIndicesCarreras(carreras);

        assertEquals(1,carreras.cantElementos());
    }
    @Test
    @DisplayName("Test para validar que pasa cuando todos los alumnos tienen solo una carrera que se deberian de repetir")
    public void test3() {
        arbolito = new TArbolBBU();

        TElementoAB<Alumno> alumno3 = new TElementoAB<>("51018326", new Alumno(51018326, "Santiago", "Psicología"));
        TElementoAB<Alumno> alumno5 = new TElementoAB<>("51234852", new Alumno(51018326, "Carlos", "Psicología"));
        TElementoAB<Alumno> alumno6 = new TElementoAB<>("23548752", new Alumno(51018326, "Ruibal", "Psicología"));

        arbolito.insertar(alumno3);
        arbolito.insertar(alumno5);
        arbolito.insertar(alumno6);
        arbolito.armarIndicesCarreras(carreras);

        assertEquals(3,carreras.getPrimero().getDato().getIndiceCarrera().obtenerTamanio());
    }

    @Test
    @DisplayName("Test para validar que si no hay elementos en el arbol carrera no cambia")
    public void test4() {
        arbolito = new TArbolBBU();
        arbolito.armarIndicesCarreras(carreras);
        assertEquals(0,carreras.cantElementos());
    }

}


