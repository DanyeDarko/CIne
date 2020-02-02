package Objetos;

//<editor-fold defaultstate="collapsed" desc="IMPORTACIONES Y LIBRERIAS">
import java.util.ArrayList;
import java.util.List;
//</editor-fold>

public class Cine extends DatosCineAbstracta {
// HEREDA DE LA CLASE ABSTRACTA DE UN CINE POR LO TANTO HEREDA VARIABLES Y METODOS

    public Cine(int cantidadTaquillas) {
        // METODO CONSTRUCTOR DEL CINE RECIBE COMO PARAMETRO LA CANTIDAD DE TAQUILLAS
        // O DIMENSIONES( N POCICIONES) DE LA LISTA DE ARREGLOS BIDIMENSIONALES 'listaTaquillas'

        //<editor-fold defaultstate="collapsed" desc="CONSTRUCCION DEL ARREGLO TRIDIMENSIONAL">
        //<editor-fold defaultstate="collapsed" desc="ESTABLECER DIMENSIONES(CARAS) O N TAQUILLAS">
        for (int dimension = 0; dimension < cantidadTaquillas; dimension++) {
            // ITERADOR QUE PERMITE LA CREACION DE N CANTIDAD ESTIPULADA DE DIMENSIONES O TAQUILLAS

            listaTaquillas.add(new ArrayList<List<Integer>>());
            // POR CADA ITERACION AGREGA UN ARREGLO BIDIMENSIONAL A LA LISTA DE AREGLOS
            // CADA ARREGLO BIDIMENSIONAL CONTENDRA DATOS DE VENTAS Y DEVOLUCIONES 
            // ACERCA DE UNA ESPECIFICA TAQUILLA,ES DECIR LA DIMENSION EN LA QUE SE ENCUENTRA DICHO ARREGLO
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="AGREGAR COLUMNAS AL ARREGLO BIDIMENSIONAL ALOJADO EN CADA TAQUILLA ">
            for (int columna = 0; columna < 4; columna++) {
                // ITERADOR QUE PERMITE AGREGAR 4 COLUMNAS A CADA ARREGLO BIDIMENSIONAL
                // ES DECIR AGREGA UNA LISTA NUEVA POR CADA ITERACION EN CADA UNA DE LAS 4 DIMENSIONES

                listaTaquillas.get(dimension).add(new ArrayList<Integer>());
                //SE UTILIZA 'get'(indice) EQUIVALENTE A [indice] EN ARREGLOS COMUNES
                //'add' SE UTILISA PARA AGREGAR ELEMENTOS AL INDICE INDICADO
            }
        }
        //</editor-fold>

//        LlenarTaquillas(); // INICIALISAMOS LAS TAQUILLAS CON LOS DATOS PROPUESTOS EN EL EJERCICIO EN CLASE 
        //</editor-fold>

    }
}
