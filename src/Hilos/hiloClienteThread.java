package Hilos;

import Objetos.Cine;

public class hiloClienteThread extends Thread {

    //<editor-fold defaultstate="collapsed" desc="VARIABLES GLOBALES DEL HILO">
    int cliente, numeroTaquilla, cantBoletos, numSala, tipoPeracion;
    Cine Cine;
    //</editor-fold>

    public hiloClienteThread(Cine c, int numeroTaquilla, int cliente, int cantBoletos, int numSala, int tipoOperacion) {
        this.Cine = c; // ESTANCIA DE LA CLASE MONITORA 
        this.numeroTaquilla = numeroTaquilla;
        this.cliente = cliente;
        this.cantBoletos = cantBoletos;
        this.numSala = numSala;
        this.tipoPeracion = tipoOperacion;

    }

    public hiloClienteThread(Cine c, int[] registro) {

    }

    public void run() {
        //Cine.operacionTaquilla(cliente, numeroTaquilla, cantBoletos,numSala,tipoPeracion);
        System.out.println("HILO"+cliente+"LLENANDO MATRIZ"+numeroTaquilla);
        Cine.LlenarTaquillas(numeroTaquilla);
       
    }

}
