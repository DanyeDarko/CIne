package Init;

//<editor-fold defaultstate="collapsed" desc="IMPORTACIONES Y LIBRERIAS">
import Objetos.Cine;
import Hilos.hiloCliente;
//</editor-fold>

public class servicioCine {

    public static void main(String[] args) {


        //<editor-fold defaultstate="collapsed" desc="VARIABLES DE PROGAMA">
        short cantidadTaquillas = 4;
        short cantidadHilos = 8;
        Cine Cine1 = new Cine(cantidadTaquillas); // NUEVA ESTANCIA DE LA CLASE CINE ,RECIBE COMO PARAMETRO LAS DIMENSIONES
        // O TAQUILLAS DISPONIBLES PARA EL CINE EN ESTE CASO 4
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="PRINTS BRINDAN INFO  DE TAQUILLAS <---LISTA DE TIPO ARREGLO BIDIMENSIONAL">
        System.out.println("NUMERO DE TAQUILLAS " + Cine1.getListaDeTaquillas().size());
        System.out.println("NUMERO DE COLUMNAS EN CADA TABLA DE TAQUILLAS " + Cine1.getListaDeTaquillas().get(0).size());
        System.out.println("NUMERO DE FILAS  "+Cine1.getListaDeTaquillas().get(0).get(0).size());
        Hilos.hiloCliente[] Htread = new hiloCliente[cantidadHilos];
        //</editor-fold>
        
        
       //<editor-fold defaultstate="collapsed" desc="CREACION DE HILOS THREAD">
        //CODIGO DE UTILIDAD PARA LEVANTAR LOS HILOS   <---------- ESTA EN PRUEBA EL LANSAMIENTO DE RELLENO POR HILO     
         for (int i = 0; i < 1; i++) { // GENERACION DE 8 REGISTROS DE COMPRA
            hiloCliente nuevoCliente = new hiloCliente(Cine1, i, 0, i , i, i);
            //   MONITOR  CLIENTE  TAQUILLA  BOLETOS   SALA  TIPO OPERACION  
            Htread[i] = nuevoCliente; // AGREGA UN NUEVO HILO AL ARREGLO DE HILOS
            Htread[i].run(); // DESPLIEGE DE HILOS
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
