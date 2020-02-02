package Objetos;/*<---------- CLASE ABSTRACTA PERTENECIENTE AL PAQUETE DE OBJETOS 
                 PAQUETE QUE ALMACENA CLASES ABSTRACTAS Y OBJETOS UTILES DE PROGRAMA */

//<editor-fold defaultstate="collapsed" desc="IMPORTACIONES Y LIBRERIAS ">
import java.util.ArrayList;  // CLASE ARRAYLIST PARA INSTANCIAR OBJETO DE TIPO LISTA DE ARREGLOS  
import java.util.List;
import Interfaces.InterfazCine;
// </editor-fold>

public abstract class DatosCineAbstracta implements InterfazCine {
// CLASE ABSTRACTA NO SE PUEDE INSTANCIAR SOLO HEREDAR ATRIBUTOS Y METODOS LOS CUALES IMPLEMENTA DE LA INTERFAZ 'interfazCine'
// <editor-fold defaultstate="collapsed" desc="VARIABLES UTILES DE CLASE ABSTRACTA QUE SE HEREDAN A OBJETOS  QUE EXTIENDA DE 'DatosCineAbstracta' ">

    protected ArrayList< List< List<Integer>>> listaTaquillas = new ArrayList< List< List< Integer>>>();
   /* LISTA QUE ALMACENARA EN CADA POCICION[] UNA MATRIZ BIDIMENSIONAL CON 4 PRINCIPALES 
   COLUMNAS Y FILAS INDETERMINADAS */
    
//<editor-fold defaultstate="collapsed" desc="EXPLICACION DE LISTA (ARRAYLIST) DE TIPO ARREGLO BIDIMENSIONAL">
    /*ARRAY DE ARRAYS EN LA POCICION [0] DE 'Taquillas' :
                 
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
    //<editor-fold defaultstate="collapsed" desc="<ARREGLOS BIDIMENSIONALES CON VALORES CONSTANTES PROPUESTOS EN CLASE">
    // CADA TAQUILLA LLEVA EL CONTROL DE LOS BOLETOS QUE VENDE(ACCION 1) O DEVUELVEN(ACCION 0) IDENTIFICADOS CON NUMERO DE CLIENTE O TICKET(HILO), 
    // CANTIDAD DE BOLETOS Y OPERACION REALISADA( 0 |  1)
    protected Integer[][] Taquilla1 = {
        //  HILO  BOLETOS    SALA   ACCION(C0MPRAR O VENDER)
        {1, 5, 5, 1}, // <--- FILA 0
        {2, 4, 4, 1},
        {3, 3, 3, 1},
        {4, 2, 2, 1},
        {5, 1, 1, 1},
        {6, 6, 5, 0},
        {7, 3, 3, 0},
        {8, 5, 1, 1}
    };

    protected int[][] Taquilla2 = {
        //  HILO  BOLETOS    SALA   ACCION(C0MPRAR O VENDER)
        {9, 10, 5, 1},
        {10, 10, 4, 0},
        {11, 7, 2, 1},
        {12, 1, 1, 0},
        {13, 5, 5, 0},
        {14, 3, 2, 1},
        {15, 7, 4, 0},
        {16, 5, 5, 1}
    };

    protected int[][] Taquilla3 = {
        // HILO  BOLETOS    SALA   ACCION(C0MPRAR O VENDER)
        {17, 7, 2, 1},
        {18, 4, 5, 1},
        {19, 1, 3, 1},
        {20, 1, 1, 0},
        {21, 7, 5, 1},
        {22, 8, 1, 0},
        {23, 6, 3, 1},
        {24, 2, 4, 0}
    };

    protected int[][] Taquilla4 = {
        // HILO  BOLETOS    SALA   ACCION(C0MPRAR O VENDER)
        {25, 5, 5, 1},
        {26, 4, 4, 1},
        {27, 3, 3, 1},
        {28, 2, 2, 1},
        {29, 1, 1, 1},
        {30, 6, 5, 0},
        {31, 3, 3, 0},
        {32, 5, 1, 0}
    };
    //</editor-fold>

    // </editor-fold>
//<editor-fold defaultstate="collapsed" desc="METODOS ABSTRACTOS DE LA CLASE">
    @Override
    public void obtenerDatosTaquilla(int numeroTaquilla) { // RECIBE COMO PARAMETRO NUMERO DE TAQUILLA A IMPRIMIR
        System.out.println(" \tTAQUILLA " + (numeroTaquilla + 1));
        System.out.print("Hilo\tBoletos\tSala\tStatus\t\n");

        for (int fila = 0; fila < getListaDeTaquillas().get(numeroTaquilla).get(0).size(); fila++) { // EL ITERADOR DE FILAS DEBE SER MENOR AL NUMERO DE REGISTROS
            // DEL ARREGLO BIDIMENSIONAL EN LA POCICION DE LA TAQUILLA ESPECIFICADA 
            for (int columna = 0; columna < getListaDeTaquillas().get(numeroTaquilla).size(); columna++) { // EL ITERADOR DE COLUMNAS DEBE SER MENOR AL NUMERO DE COLUMNAS
                //O LISTAS AGREGADAS EN LA TAQUILLA ESPECIFICADA

                System.out.print(getListaDeTaquillas().get(numeroTaquilla).get(columna).get(fila) + "\t");
                /*OBTIENE LA ULTIMA ACTUALISACION DE VALORES DEL LA LISTA ,<---getListaDeTaquillas
                  COLOCA EL PUNTERO DE LA PRIMERA DIMENSION EN EL NUMERO DE TAQUILLA DESEADO<---get(numeroTaquilla)
                  OBTIENE EL VALOR DE UN REGISTRO RESULTANTE DEL VALOR DE  EL CRUCE DE LA COLUMNA Y LA FILA SEGUN LA ITERACION 
                **/
            }
            System.out.println("");
        }
    }

    @Override
    public void operacionTaquilla(int numeroCliente, int numTaquilla, int cantidadBoletos, int numeroSala, int tipoOperacion) {
        getListaDeTaquillas().get(numTaquilla).get(0).add(numeroCliente);
        getListaDeTaquillas().get(numTaquilla).get(1).add(cantidadBoletos);
        getListaDeTaquillas().get(numTaquilla).get(2).add(numeroSala);
        getListaDeTaquillas().get(numTaquilla).get(3).add(tipoOperacion);
    }

    public void LlenarTaquillas() {
        for (int numTaquilla = 0; numTaquilla < 4; numTaquilla++) {
            for (int fila = 0; fila < 8; fila++) {
                for (int columna = 0; columna < 4; columna++) {
                    switch (numTaquilla) {
                        case 0: // METODO add PARA AGREGAR CADA ELEMENTO DE LA MATRIZ[][] EN LA MISMA POCICION QUE EL ARRAYLIST BIDIMENSIONAL
                            getListaDeTaquillas().get(numTaquilla).get(columna).add(getTaquilla1()[fila][columna]);
                            /*TRANSPONE UNA MATRIZ COMUN [8][4] CON EL ARRAYLIST BIDIMENSIONAL DE TIPO INTEGER
                             VARIANTES: SEGUN EL CASO LA VARIANTE DEL METODO 'get' ES EL NUMERO DE MATRIZ[][] TRANSPUESTA*/
                            break;
                        case 1:
                            getListaDeTaquillas().get(numTaquilla).get(columna).add(getTaquilla2()[fila][columna]);
                            break;
                        case 2:
                            getListaDeTaquillas().get(numTaquilla).get(columna).add(getTaquilla3()[fila][columna]);
                            break;

                        case 3:
                            getListaDeTaquillas().get(numTaquilla).get(columna).add(getTaquilla4()[fila][columna]);
                            break;

                    }

                }
            }
        }
    }

//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="METODOS DE ENCAPSULAMIENTO">
    /**
     * @return the Taquillas
     */
    public ArrayList< List< List<Integer>>> getListaDeTaquillas() {
        return listaTaquillas;
    }

    /**
     * @param Taquillas the Taquillas to set
     */
    public void setTaquillas(ArrayList< List< List<Integer>>> Taquillas) {
        this.listaTaquillas = Taquillas;
    }

    /**
     * @return the Taquilla1
     */
    public Integer[][] getTaquilla1() {
        return Taquilla1;
    }

    /**
     * @param Taquilla1 the Taquilla1 to set
     */
    public void setTaquilla1(Integer[][] Taquilla1) {
        this.Taquilla1 = Taquilla1;
    }

    /**
     * @return the Taquilla2
     */
    public int[][] getTaquilla2() {
        return Taquilla2;
    }

    /**
     * @param Taquilla2 the Taquilla2 to set
     */
    public void setTaquilla2(int[][] Taquilla2) {
        this.Taquilla2 = Taquilla2;
    }

    /**
     * @return the Taquilla3
     */
    public int[][] getTaquilla3() {
        return Taquilla3;
    }

    /**
     * @param Taquilla3 the Taquilla3 to set
     */
    public void setTaquilla3(int[][] Taquilla3) {
        this.Taquilla3 = Taquilla3;
    }

    /**
     * @return the Taquilla4
     */
    public int[][] getTaquilla4() {
        return Taquilla4;
    }

    /**
     * @param Taquilla4 the Taquilla4 to set
     */
    public void setTaquilla4(int[][] Taquilla4) {
        this.Taquilla4 = Taquilla4;
    }
    //</editor-fold>
}
