package Init;

//<editor-fold defaultstate="collapsed" desc="IMPORTACIONES Y LIBRERIAS">
import Objetos.Cine;
import Hilos.hiloCliente;
import javax.swing.text.EditorKit;
//</editor-fold>

public class servicioCine {

    public static void main(String[] args) {

        //<editor-fold defaultstate="collapsed" desc="VARIABLES DE PROGAMA">
        short cantidadTaquillas = 4;
        short cantidadHilos = 8;
        Cine Cine1 = new Cine(cantidadTaquillas); // NUEVA ESTANCIA DE LA CLASE CINE ,RECIBE COMO PARAMETRO LAS DIMENSIONES
        // O TAQUILLAS DISPONIBLES PARA EL CINE EN ESTE CASO 4
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="PRINTS BRINDAN INFO  DE TAQUILLAS">
        System.out.println("NUMERO DE TAQUILLAS " + Cine1.Taquillas.size());
        System.out.println("NUMERO DE COLUMNAS EN CADA TABLA DE TAQUILLAS " + Cine1.Taquillas.get(0).size());
        Hilos.hiloCliente[] Htread = new hiloCliente[cantidadHilos];
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="CREACION DE HILOS THREAD">
        for (int i = 0; i < cantidadHilos; i++) { // GENERACION DE 8 REGISTROS DE COMPRA
            hiloCliente nuevoCliente = new hiloCliente(Cine1, i, 0, (i + 2), 2, 1);
            //   MONITOR  CLIENTE  TAQUILLA  BOLETOS   SALA  TIPO OPERACION  
            Htread[i] = nuevoCliente; // AGREGA UN NUEVO HILO AL ARREGLO DE HILOS
            Htread[i].run(); // DESPLIEGE DE HILOS
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="IMPRESION DE DATOS TAQUILLA">       
        Cine1.obtenerDatosTaquilla(0); // IMPRIME LOS DATOS DE LA TAQUILLA 1(ESTA EN LA POCICION 0 DE LA LISTA 
        // DE ARREGLOS BIDIMENSIONALES);
        //</editor-fold>

    } // <--- LLAVE CERRADURA MAIN
}// <------   LLAVE CERRADURA CLASE
