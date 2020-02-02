package Init;

//<editor-fold defaultstate="collapsed" desc="IMPORTACIONES Y LIBRERIAS">
import Objetos.Cine;
import Hilos.hiloClienteThread;
import java.util.logging.Level;
import java.util.logging.Logger;
//</editor-fold>

public class servicioCine {

    public static void main(String[] args) {

        //<editor-fold defaultstate="collapsed" desc="VARIABLES DE PROGAMA">
        short cantidadTaquillas = 4;
        short cantidadHilos = 1;
        short iterador;

        /*NUEVA ESTANCIA DE LA CLASE 'Cine'(MONITORA),RECIBE COMO PARAMETRO LAS DIMENSIONES
           O TAQUILLAS DISPONIBLES PARA EL CINE EN ESTE CASO 4 <--- VER CONSTRUCCION EN CLASE 'Cine'*/
        Cine Cine1 = new Cine(cantidadTaquillas);

        /*NUEVA ESTANCIA DE ARREGLO DE TIPO CLASE 'hiloCliente',COMO PARAMETRO 
          LA CANTIDAD DE HILOS QUE SE DESEAN EJECUTAR */
        hiloClienteThread[] Htread = new hiloClienteThread[cantidadHilos];

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="PRINTS BRINDAN INFO  DE TAQUILLAS <---LISTA DE TIPO ARREGLO BIDIMENSIONAL">
        System.out.println("NUMERO DE TAQUILLAS " + Cine1.getListaDeTaquillas().size());
        System.out.println("NUMERO DE COLUMNAS EN CADA TABLA DE TAQUILLAS " + Cine1.getListaDeTaquillas().get(0).size());
        System.out.println("NUMERO DE FILAS  " + Cine1.getListaDeTaquillas().get(0).get(0).size());

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="CREACION DE HILOS THREAD">
        //CODIGO DE UTILIDAD PARA LEVANTAR LOS HILOS   
        for (iterador = 0; iterador < cantidadHilos; iterador++) { // GENERACION DE N REGISTROS DE COMPRA
            hiloClienteThread nuevoCliente = new hiloClienteThread(Cine1, iterador, 0, iterador, iterador, iterador);

            //<editor-fold defaultstate="collapsed" desc="EXPLICACION PARAMETROS  QUE RECIBE EL HILO">            
            /*   MONITOR  CLIENTE  TAQUILLA  BOLETOS   SALA  TIPO OPERACION
                   Cine1      0    RANDOM(1-4)   0        0         0   <------- PRIMERA ITERACION iteracion = 0
                   Cine1      1    RANDOM(1-4)   1        1         1   <------- SEGUNDA ITERACION iteracion = 1
                   Cine1      n    RANDOM(1-4)   n        n         n 

             */
            //</editor-fold>
            Htread[iterador] = nuevoCliente; // AGREGA UN NUEVO HILO AL ARREGLO DE HILOS
            Htread[iterador].run(); // DESPLIEGE DE HILOS

            try {

                for (int j = 0; j < cantidadHilos; j++) {
                    Htread[iterador].join();
                }
            } catch (InterruptedException ex) {
                System.out.println("OCURRIO UN ERROR EN LA SINCRONISACION DE HILOS");
            }
        }

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="IMPRESION DE DATOS TAQUILLA">       
        for (int i = 0; i < 4; i++) {
            Cine1.obtenerDatosTaquilla(i);  // IMPRIME LOS DATOS DE LA TAQUILLA 1(ESTA EN LA POCICION 0 DE LA LISTA 
            // DE ARREGLOS BIDIMENSIONALES);  
            System.out.println("");
        }

        //</editor-fold>
    }

}
