package Hilos;

import Objetos.Cine;

public class hiloCliente extends Thread {

    int cliente, numeroTaquilla, cantBoletos, numSala, tipoPeracion;
    Cine Cine;
    
    public hiloCliente(Cine c,int cliente, int numeroTaquilla, int cantBoletos, int numSala, int tipoOperacion) {
        this.Cine = c;
        this.cliente = cliente;
        this.numeroTaquilla = numeroTaquilla;
        this.cantBoletos = cantBoletos;
        this.numSala = numSala;
        this.tipoPeracion = tipoOperacion;

    }
    public hiloCliente(Cine c,int[] registro){
        
    }

    public void run() {
    //Cine.operacionTaquilla(cliente, numeroTaquilla, cantBoletos,numSala,tipoPeracion);
    Cine.LlenarTaquillas();
    }

}
