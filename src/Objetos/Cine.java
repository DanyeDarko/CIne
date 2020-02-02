package Objetos;

//<editor-fold defaultstate="collapsed" desc="IMPORTACIONES Y LIBRERIAS">
import java.util.ArrayList;
import java.util.List;
//</editor-fold>

public class Cine extends DatosCineAbstracta { // HEREDA DE LA CLASE ABSTRACTA DE UN CINE 
                                               //  POR LO TANTO HEREDA VARIABLES Y METODOS

    public Cine(int cantidadTaquillas) { // METODO CONSTRUCTOR DEL CINE RECIBE COMO PARAMETRO LA CANTIDAD DE TAQUILLAS
                                         // O DIMENSIONES( N POCICIONES) DE LA LISTA DE ARREGLOS BIDIMENSIONALES

     //<editor-fold defaultstate="collapsed" desc="CONSTRUCCION DEL ARREGLO TRIDIMENSIONAL">
        for (int dimension = 0; dimension < cantidadTaquillas; dimension++) { // ITERADOR QUE PERMITE LA CREACION DE N CANTIDAD 
            // ESTIPULADA DE DIMENSIONES O TAQUILLAS
            Taquillas.add(new ArrayList<List<Integer>>()); // POR CADA ITERACION AGREGA UN ARREGLO BIDIMENSIONAL A LA LISTA DE AREGLOS
            // CADA ARREGLO BIDIMENSIONAL CONTENDRA DATOS DE VENTAS Y DEVOLUCIONES 
            // ACERCA DE UNA ESPECIFICA TAQUILLA,ES DECIR LA DIMENSION EN LA QUE SE ENCUENTR DICHO ARREGLO

            for (int i = 0; i < 4; i++) { // ITERADOR QUE PERMITE AGREGAR 4 COLUMNAS A CADA ARREGLO BIDIMENSIONAL
                // ES DECIR AGREGA UNA LISTA NUEVA POR CADA ITERACION EN CADA UNA DE LAS 4 DIMENSIONES
                Taquillas.get(dimension).add(new ArrayList<Integer>());
                //SE UTILIZA 'get'(indice) EQUIVALENTE A [indice] EN ARREGLOS COMUNES
                //'add' SE UTILISA PARA AGREGAR ELEMENTOS AL INDICE INDICADO
            }
        }
        //</editor-fold>
       
     //<editor-fold defaultstate="collapsed" desc="SEGUNDA FORMA DE CODIGO PARA AGREGAR DATOS A LAS MATRIZS COMUNES">


        /*
     int[][] Taquilla1 = {
       //   HILO  BOLETOS    SALA   ACCION(C0MPRAR O VENDER)
            {1  ,    5   ,    5   ,    1},    // <--- FILA 1 
            {2  ,    4   ,    4   ,    1},
            {3  ,    3   ,    3   ,    1},
            {4  ,    2   ,    2   ,    1},
            {5  ,    1   ,    1   ,    1},
            {6  ,    6   ,    5   ,    0},
            {7  ,    3   ,    3   ,    0},
            {8  ,    5   ,    1   ,    1}
        };
      
        int[][] Taquilla2 = {
       //  HILO  BOLETOS    SALA   ACCION(C0MPRAR O VENDER)
            {9  ,   10   ,    5   ,    1},
            {10 ,   10   ,    4   ,    0},
            {11 ,    7   ,    2   ,    1},
            {12 ,    1   ,    1   ,    0},
            {13 ,    5   ,    5   ,    0},
            {14 ,    3   ,    2   ,    1},
            {15 ,    7   ,    4   ,    0},
            {16 ,    5   ,    5   ,    1}
        };

        int[][] Taquilla3 = {
        // HILO  BOLETOS    SALA   ACCION(C0MPRAR O VENDER)
            {17 ,     7  ,    2   ,    1},
            {18 ,     4  ,    5   ,    1},
            {19 ,     1  ,    3   ,    1},
            {20 ,     1  ,    1   ,    0},
            {21 ,     7  ,    5   ,    1},
            {22 ,     8  ,    1   ,    0},
            {23 ,     6  ,    3   ,    1},
            {24 ,     2  ,    4   ,    0}
        };

        int[][] Taquilla4 = {
        // HILO  BOLETOS    SALA   ACCION(C0MPRAR O VENDER)
            {25 ,    5   ,    5   ,    1},
            {26 ,    4   ,    4   ,    1},
            {27 ,    3   ,    3   ,    1},
            {28 ,    2   ,    2   ,    1},
            {29 ,    1   ,    1   ,    1},
            {30 ,    6   ,    5   ,    0},
            {31 ,    3   ,    3   ,    0},
            {32 ,    5   ,    1   ,    0}
        };

        
         */
        //</editor-fold>
        
    } // <---------- FIN DEL METODO CONSTRUCTOR
} // <-------------- FIN DE LA CLASE 
