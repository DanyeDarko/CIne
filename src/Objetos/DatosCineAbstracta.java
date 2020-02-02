package Objetos;/*<---------- CLASE ABSTRACTA PERTENECIENTE AL PAQUETE DE OBJETOS 
                 PAQUETE QUE ALMACENA CLASES ABSTRACTAS Y OBJETOS UTILES DE PROGRAMA */

//<editor-fold defaultstate="collapsed" desc="IMPORTACIONES Y LIBRERIAS ">

import java.util.ArrayList;  // CLASE ARRAYLIST PARA INSTANCIAR OBJETO DE TIPO LISTA DE ARREGLOS  
import java.util.List;
import Interfaces.InterfazCine;
//DONDE LA PRIMERA DIMENSION(FILAS) CUENTA CON 8 POCICIONES <-------PUEDEN SER 32 Y SEPARARLAS DE 8 EN 8 
//LA SEGUNDA DIMENSION(COLUMNAS) CUENTA CON 4 POCICIONES  

// </editor-fold>
public abstract class DatosCineAbstracta implements InterfazCine {
// CLASE ABSTRACTA NO SE PUEDE INSTANCIAR SOLO HEREDAR ATRIBUTOS Y METODOS LOS CUALES IMPLEMENTA DE LA INTERFAZ 'interfazCine'

// <editor-fold defaultstate="collapsed" desc="VARIABLES UTILES DE CLASE ABSTRACTA QUE SE HEREDAN A OBJETOS  QUE EXTIENDA DE 'DatosCineAbstracta' ">
    public ArrayList< List< List<Integer>>> Taquillas = new ArrayList< List< List< Integer>>>();

    /* LISTA QUE ALMACENARA EN CADA POCICION[] UNA MATRIZ BIDIMENSIONAL CON 4 PRINCIPALES 
   COLUMNAS Y FILAS INDETERMINADAS 
                      

ARRAY DE ARRAYS EN LA POCICION [0] DE 'Taquillas' :
                 
                  **LIST<INTEGER> 0**          **LIST<INTEGER> 1**        **LIST<INTEGER> 2**        **LIST<INTEGER> 3**
                     NUMERO HILO                   BOLETOS                   SALA DE BOLETO                   Status
                      (CLIENTES) 
                         [0]                          [1]                        [2]                            [3]        
                                                                                                (0 ->> DEVOLUCION 1->>COMPRA)  
             -_____________________  ____________________________________  __________________ ________________________________
          F [0]  --->     1        | REQUIERE ---->    5      DE LA SALA | -----> 5   PARA   | --->          1 (COMPRA = SUMAR BOLETOS A SALA CORRESPONDIENTE <----ARREGLO DE BOLETOS )
          I [1]  --->     2        | REQUIERE ---->    4      DE LA SALA | -----> 4   PARA   | --->          1 (COMPRA = SUMAR BOLETOS A SALA CORRESPONDIENTE <----ARREGLO DE BOLETOS )            
          L [2]  --->     3        | REQUIERE ---->    3      DE LA SALA | -----> 3   PARA   | --->          1 (COMPRA = SUMAR BOLETOS            
          A [3]  --->     4        | REQUIERE ---->    2      DE LA SALA | -----> 2   PARA   | --->          1 (COMPRA = SUMAR BOLETOS
          S [4]  --->     5        | REQUIERE ---->    1      DE LA SALA | -----> 1   PARA   | --->          1 (COMPRA = SUMAR BOLETOS                                |
            [5]  --->     6        | REQUIERE ---->    6      DE LA SALA | -----> 5   PARA   | --->          0 (DEVOLUCION = SUMAR BOLETOS DEVUELTOS Y RESTAR A VENDIDOS                             
            [6]  --->     7        | REQUIERE ---->    3      DE LA SALA | -----> 3   PARA   | --->          0 (DEVOLUCION = SUMAR BOLETOS DEVUELTOS Y RESTAR A VENDIDOS                              
            [7]  --->     8        | REQUIERE ---->    5      DE LA SALA | -----> 1   PARA   | --->          0 (DEVOLUCION = SUMAR BOLETOS DEVUELTOS Y RESTAR A VENDIDOS               
               ____________________  ___________________________________  __________________ _________________________________
    
    CADA  FILA REPRESENTARIA LA EJECUCION DE UN HILO  
    ES DECIR EL HILO SERIA UN CLIENTE QUE RECIBIRA COMO PARAMETROS : 
            EL NUMERO DE *HILO EN EJECUCION (CLIENTE QUE COMPRO(1) O DEVOLVIO (O)  <--- INSERCION EN NUEVO REGISTRO(FILA) EN COLUMNA[0] DEL ARREGLO
            EL NUMERO DE **BOLETOS QUE PIENSA COMPRAR(1) O DEVOLVER(0)             <--- INSERCION EN NUEVO REGISTRO(FILA) EN COLUMNA[1] DEL ARREGLO
            EL NUMERO DE ***SALA EN LA QUE DESEA LA PELICULA                       <--- INSERCION EN NUEVO REGISTRO(FILA) EN COLUMNA[2] DEL ARREGLO
            EL STATUS DE ACCION DEL CLIENTE(HILO DE INSERSION 1 COMPRAR 0 DEVOLVER <--- INSERCION EN NUEVO REGISTRO(FILA) EN COLUMNA[3] DEL ARREGLO
                                                              
      8(DE 0 A 7) FILAS POR LAS 8 INSERCCIONES QUE SE REALIZARAN MEDIANTE UN HILO ,UN HILO PARA CADA INSERCION
      EL HILO INSERTA SU NUMERO DE CLIENTE (EJEMPLO 1) LOS BOLETOS A COMPRAR (EJEMPLO: 5 ) Y DE LA SALA A COMPRAR[5 SALAS DISPONIBLES]
     */
    // </editor-fold>
//<editor-fold defaultstate="collapsed" desc="METODOS ABSTRACTOS DE LA CLASE">
    @Override
    public void obtenerDatosTaquilla(int numeroTaquilla) { // RECIBE COMO PARAMETRO NUMERO DE TAQUILLA A IMPRIMIR
        System.out.println(" \tTAQUILLA " + (numeroTaquilla + 1));
        System.out.print("Hilo\tBoletos\tSala\tStatus\t\n");

        for (int fila = 0; fila < Taquillas.get(numeroTaquilla).get(0).size(); fila++) { // EL ITERADOR DE FILAS DEBE SER MENOR AL NUMERO DE REGISTROS
            // DEL ARREGLO BIDIMENSIONAL EN LA POCICION DE LA TAQUILLA ESPECIFICADA
            for (int columna = 0; columna < Taquillas.get(numeroTaquilla).size(); columna++) { // EL ITERADOR DE COLUMNAS DEBE SER MENOR AL NUMERO DE COLUMNAS
                //O LISTAS AGREGADAS EN LA TAQUILLA ESPECIFICADA

                System.out.print(Taquillas.get(numeroTaquilla).get(columna).get(fila) + "\t");
            }
            System.out.println("");
        }
    }

    @Override
    public void operacionTaquilla(int numeroCliente, int numTaquilla, int cantidadBoletos, int numeroSala, int tipoOperacion) {

        Taquillas.get(numTaquilla).get(0).add(numeroCliente);
        Taquillas.get(numTaquilla).get(1).add(cantidadBoletos);
        Taquillas.get(numTaquilla).get(2).add(numeroSala);
        Taquillas.get(numTaquilla).get(3).add(tipoOperacion);
    }
//</editor-fold>

}
