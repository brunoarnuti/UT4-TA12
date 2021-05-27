
import manejadordearchivos.*;
import tdas.*;
import universidad.*;

import java.util.*;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // crear un nuevo tdas.TArbolBBU de nombre "ucu"
        TArbolBBU ucu = new TArbolBBU();

        // cargar los alumnos en el árbol "ucu" desde el archivo de datos "datos.txt"
        // ci, apellido, carrera
        String[] alumnos = ManejadorArchivosGenerico.leerArchivo("src/Datos.txt");
        try {
            for (String linea : alumnos) {
                String[] registro = linea.split(",");
                if (registro.length == 3) {
                    Alumno unAlumno = new Alumno(Integer.parseInt(registro[0]), registro[1], registro[2]);
                    TElementoAB<Alumno> elem = new TElementoAB<>(unAlumno.getCodigo(), unAlumno);
                    ucu.insertar(elem);
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // crear un nueva lista de carreras
        Lista<Carrera> listaCarreras = new Lista<>();

        // invocar el método armarIndicesCarreras
        ucu.armarIndicesCarreras(listaCarreras);

        // escribir el archivo "unaCarrera.txt" con el nombre de la carrera indicada
        String carreraIndicada = "Psicología";

        Nodo<Carrera> nodoActual = listaCarreras.getPrimero();
        List<String> salida = new ArrayList<>();
        salida.add(carreraIndicada);

        while (nodoActual != null) {
            System.out.println(nodoActual.getDato().getNombreCarrera());
            if (nodoActual.getDato().getNombreCarrera().trim().compareTo(carreraIndicada) == 0) {
                Lista<Alumno> listaAlumnos = nodoActual.getDato().getIndiceCarrera().inorden();
                Nodo<Alumno> alumno = listaAlumnos.getPrimero();
                while (alumno != null) {
                    salida.add(alumno.getDato().getCodigo() + "," + alumno.getDato().getApellido());
                    alumno = alumno.getSiguiente();
                }
            }
            nodoActual = nodoActual.getSiguiente();
        }

        String[] salidas = salida.toArray(new String[0]);
        ManejadorArchivosGenerico.escribirArchivo("unacarrera.txt", salidas);

        // escribir el archivo "todasCarreras.txt"
        Nodo<Carrera> primero = listaCarreras.getPrimero();
        List<String> todaslasCarreras = new ArrayList<>();
        while (primero != null) {
            todaslasCarreras.add("\n");
            todaslasCarreras.add(primero.getEtiqueta().toString() + ":");
            todaslasCarreras.add("\n");
            Lista<Alumno> indices= new Lista<>();
            primero.getDato().getIndiceCarrera().getRaiz().inOrden(indices);
            Nodo<Alumno> aux = indices.getPrimero();
            while (aux != null) {
                todaslasCarreras.add(aux.getEtiqueta() + "," + aux.getDato().getCodigo());
                aux = aux.getSiguiente();
            }
            primero = primero.getSiguiente();
        }
        ManejadorArchivosGenerico.escribirArchivo("TodasCarreras.txt", todaslasCarreras.toArray(new String[0]));
    }
}



