## CINE PROGRAMACION CONCURRENTE 

PROGRAMA DE CONTROL DE VENTAS DE TICKETS EN UN CINE POR SALAS IMPLEMENTANDO PROGRAMACION CONCURRENTE EN JAVA
## Comenzando 🚀
Para Descargar y desplegar el proyecto Es necesario contar Con git ,una terminal o algun cliente git como lo es GitKraken,Plugins en VSC
```bash
    $ git clone https://github.com/DanyeDarko/Cine.git
 ```
 ### CLASE CINE ABSTRACTA
 La clase 'DatosCineAbstracta' contiene todas las variables utiles y metodos implementados de la interfaz 'interfazCine'
 El ArrayList de tipo ArrayList Bidimensional tiene la siguiente arquitectura: 

![ARQUITECTURA DEL ARRAYLIST PRINCIPAL O RECURSO DE LO SHULOS](https://raw.githubusercontent.com/DanyeDarko/Cine/master/ARREGLO.png)

en donde la definicion del arreglo es :

```java
ArrayList< List< List<Integer>>> listaTaquillas = new ArrayList< List< List< Integer>>>(); 
```

Declarando asi ,Un Arreglo de 3 dimensiones donde Cada una de estas dimensiones,Representara Una **Taquilla**,Que a su ves contendran Datos almacenados en un Array de 4 columnas **Numero cliente(numero de hilo),Cant Boletos,Sala,Compra(1) o Devolucion(0)**.

### NOTA : el largo de las filas no es predeterminado ,Puesto que es un arreglo dinamico con el que se manejan los Datos

#### ESTABLECER DIMENSIONES AL ARREGLO
```java
 for (int dimension = 0; dimension < cantidadTaquillas; dimension++) {
            // ITERADOR QUE PERMITE LA CREACION DE N CANTIDAD ESTIPULADA DE DIMENSIONES O TAQUILLAS

            this.listaTaquillas.add(new ArrayList<List<Integer>>());
            // POR CADA ITERACION AGREGA UN ARREGLO BIDIMENSIONAL A LA LISTA DE AREGLOS
            // CADA ARREGLO BIDIMENSIONAL CONTENDRA DATOS DE VENTAS Y DEVOLUCIONES 
            // ACERCA DE UNA ESPECIFICA TAQUILLA,ES DECIR LA DIMENSION EN LA QUE SE ENCUENTRA DICHO ARREGLO
```
       
Cada Dimension que vamos agregando en el primer for dentro del constructor en la clase **'Cine'** representa una taquilla ,si observamos el for ,las 'dimensiones' deben ser **menor a** 'cantidadTaquillas' Parametro que se recibe al instanciar una nueva clase del cine '(MONITORA DE HILOS) '  

#### ESTABLECER COLUMNAS DE TABLA  AL ARREGLO BIDIMENSIONAL ALMACENADO EN CADA DIMENSION
```java
 for (int columna = 0; columna < 4; columna++) {
                // ITERADOR QUE PERMITE AGREGAR 4 COLUMNAS A CADA ARREGLO BIDIMENSIONAL
                // ES DECIR AGREGA UNA LISTA NUEVA POR CADA ITERACION EN CADA UNA DE LAS 4 DIMENSIONES

                this.listaTaquillas.get(dimension).add(new ArrayList<Integer>());
                //SE UTILIZA 'get'(indice) EQUIVALENTE A [indice] EN ARREGLOS COMUNES
                //'add' SE UTILISA PARA AGREGAR ELEMENTOS AL INDICE INDICADO
            }
```
Agregamos 4 columnas  o nuevos `ArrayList <Integer>` a cada una de las dimensiones ,este for se itera dentro del anterior para lograrlo 


Por lo tanto la Tabla de cada taquilla o  ``List<List<Integer>>``  seria la siguiente: 

| Num Cliente | Cant Boletos | Sala | AccionTaquilla|
| ----- | ---- | ----- | ---- |
| 1 | 5 | 2 | 1 | 
| 2 | 3 | 5 | 0 | 

📌 **1 REPRESENTA UNA VENTA,POR LO TANTO SUMA VENTAS EN LA SALA QUE VENDIO Y POR SUPUESTO SUMA A LA TAQUILLA QUE VENDIO** 

📌 **0 REPRESENTA UNA DEVOLUCION POR LO TANTO RESTA VENTAS EN LA SALA QUE DEVOLVIO,Y SUMA DEVOLUCIONES,POR SUPUESTO RESTA LA TAQUILLA DONDE SE DEVOLVIO** 

 Estas Variables seran definida por la variables que pasan al metodo **operacionTaquilla** de la clase **'DatosCineAbstracta'** el cual implementa con *Implements* los metodos de la interfaz **'InterfazCine'**  <-- ESTAS VARIABLE SE CONSTRUYE DESDE EL EL CONSTRUCTOR DEL HILO EL PARAMETRO SE DEFINNE EN **'mainServicioCine'** o clase principal.
 
 ### INTERFAZ CINE
 Construye de manera abstracta los metodos usados principalmente en un cine, son implementados en la **'DatosCineAbstracta'**
 
 - *ObtenerDatosTaquilla *: Recibe como parametro la taquilla que queremos imprimir en este caso (Dimension de el arreglo principal de donde obtendremos los datos) 
 ```java
     public void obtenerDatosTaquilla(int numeroTaquilla);
```
- *operacionTaquilla* : Realisa una nueva compra(nueva insercion)de acuerdo a la Taquilla donde se desea comprar,Normalmente esta accion la realisa un cliente(Hilo Representa al cliente) que planea devolver(0) o comprar(1) **N** cantidad de boletos para **X** sala

 ```java
    public void operacionTaquilla(int numeroCliente, int numTaquilla, int cantidadBoletos, int numeroSala, int tipoOperacion);
```
- *llenarTaquillas*: Las taquillas simplemente transponen los datos de un *'Arreglo Bidimensional'* definido en la clase **'DatosCineAbstract'**  
 ```java
    public void LlenarTaquillas(int numeroTaquillaAllenar);
    
    // DEFINICION DE MATRICES BIDIMENSIONALES EN CLASE 'DatosCineAbstract'     
    protected Integer[][] Taquilla1;
    protected Integer[][] Taquilla2; 
    protected Integer[][] Taquilla3;
    protected Integer[][] Taquilla4;
 ```
 las cuales se Inicialisan en la Clase **'Cine'** objeto que herededa de **'DatosCineAbstracta'** todos sus atributos y metodos ,solo inicialisa valores en esta clase , la inicialisacion de los arreglos se basan en la lectura de un archivo plano 
 Gracias Al metodo 'leerMatrizTxt'
 
 - *leerMatrizTxt* : Permite la lectura de un archivo plano ,Donde se encuentran los datos preescritos de cada *Taquilla* ,Los datos los inserta en una matriz de tipo 'Integer' que es Devuelta para trasnponer *'List < List <Integer>>'* con los datos de el arreglo  *'Integer [][]'* con cada uno de sus elementos
    
```java
    public Integer[][] leerMatrizTxt(String URLArcqyuhivo);
 ```
### HILO THREAD CLIENTE 
Hilo que al desplegarse realizara una compra(tipoOPeracion = 1) o devolucion(tipoOperacion = 0) de **N** *boletos* para **X** *sala* en una *Taquilla* especifica
cada hilo recibe como parametro una Instancia de el objeto **'Cine'** para compartir los recursos que tiene con los otros hilos que se ejecutan bajo una misma instancia.

```java
   public hiloClienteThread(Cine c, int numeroTaquilla, int cliente, int cantBoletos, int numSala, int tipoOperacion) {
        this.Cine = c; // ESTANCIA DE LA CLASE MONITORA 
        this.numeroTaquilla = numeroTaquilla;
        this.cliente = cliente;
        this.cantBoletos = cantBoletos;
        this.numSala = numSala;
        this.tipoPeracion = tipoOperacion;

    }
 ```
En el metodo **Run()** del Hilo Ejecutamos el metodo de el monitor **'Cine'** para llenar la Matriz Correspondiente al umero de hilo ,Es decir ;

**SI EL HILO RECIBE COMO PARAMETRO 1**En numeroTaquilla' este parametro pasa con el  el mismo valor al metodo **LlenarTaquillas** que como ya vimos recibe como parametro el numero de Taquilla a Llenar con el codigo Siguiente :

```java
for (int fila = 0; fila < 8; fila++) {
                for (int columna = 0; columna < 4; columna++) {
                    switch (numeroTaquillaLlenar) {
                        case 0: // METODO add PARA AGREGAR CADA ELEMENTO DE LA MATRIZ[][] EN LA MISMA POCICION QUE EL ARRAYLIST BIDIMENSIONAL
                            getListaDeTaquillas().get(numeroTaquillaLlenar).get(columna).add(getTaquilla1()[fila][columna]);
                            /*TRANSPONE UNA MATRIZ COMUN [8][4] CON EL ARRAYLIST BIDIMENSIONAL DE TIPO INTEGER
                             VARIANTES: SEGUN EL CASO LA VARIANTE DEL METODO 'get' ES EL NUMERO DE MATRIZ[][] TRANSPUESTA*/
                            break;
                        case 1:
                            getListaDeTaquillas().get(numeroTaquillaLlenar).get(columna).add(getTaquilla2()[fila][columna]);
                            break;
                        case 2:
                            getListaDeTaquillas().get(numeroTaquillaLlenar).get(columna).add(getTaquilla3()[fila][columna]);
                            break;

                        case 3:
                            getListaDeTaquillas().get(numeroTaquillaLlenar).get(columna).add(getTaquilla4()[fila][columna]);
                            break;

                    }

                }
            }
```

con el Case nos es posible Durante la Iteracion del Arreglo Saber en que 'Dimension' vamos a colocar los valores del Arreglo *'Bidimensional[][]'*


### MAIN SERVICIO DE CINE 
Esta es la clase principal ,Existen las siguientes variables comunes utilisadas para fines de definicion e iteracion de arreglos
```java
         // DEFINE CANTIDAD DE TAQUILLAS EN EL ARRAYLIST PRINCIPAL 
        short cantidadTaquillas = 4;
        // DEFINE CUANTOS HILOS VAN A SER GENERADOS DURANTE LA EJECUCION DE ESTA CLASE
        short cantidadHilos = 4;
        // ITERADOR PARA RECORRER EL ARREGLO DE HILOS CREADO MAS ADELANTE
        int iterador;
```
Variables con un nivel mas alto de complejidad,Permiten Almacenar los hilos y por supuesto monitorearlos con una sola clase compartiendo recursos 
```java
    /*NUEVA ESTANCIA DE LA CLASE 'Cine'(MONITORA),RECIBE COMO PARAMETRO LAS DIMENSIONES
           O TAQUILLAS DISPONIBLES PARA EL CINE EN ESTE CASO 4 <--- VER CONSTRUCCION EN CLASE 'Cine'*/
        Cine Cine1 = new Cine(cantidadTaquillas);

        /*NUEVA ESTANCIA DE ARREGLO DE TIPO CLASE 'hiloCliente',COMO PARAMETRO 
          LA CANTIDAD DE HILOS QUE SE DESEAN EJECUTAR */
        hiloClienteThread[] Htread = new hiloClienteThread[cantidadHilos];
```
#### NOTA: Durante la creacion de los Hilos es importante brindar un numero de Taquilla ,El cual dictamina que Taquilla es la que llenara el hilo durante la  ejecicion del metodo 'LlenarMatriz(numMatriz)' en el metodo Run() del hilo

La asignacion de numero de hilo se da por un ciclo for en la clase principal representado de la siguiente forma :

```java
   for (iterador = 0; iterador < cantidadHilos; iterador++) { // GENERACION DE N REGISTROS DE COMPRA
            hiloClienteThread nuevoCliente = new hiloClienteThread(Cine1, iterador, iterador, 1, 1, 1);

            //<editor-fold defaultstate="collapsed" desc="EXPLICACION PARAMETROS  QUE RECIBE EL HILO">            
            /*   MONITOR   CLIENTE      TAQUILLA    BOLETOS         SALA  TIPO OPERACION
                   Cine1      0            0      RANDOM(1-15)        0         0   <------- PRIMERA ITERACION iteracion = 0
                   Cine1      1            1      RANDOM(1-15)                  1   <------- SEGUNDA ITERACION iteracion = 1
                   Cine1  iterador(n) iterador(n) RANDOM(1-15)        n         n 

             */
            //</editor-fold>
            Htread[iterador] = nuevoCliente; // AGREGA UN NUEVO HILO AL ARREGLO DE HILOS
            Htread[iterador].run(); // DESPLIEGE DE HILOS
   ```
donde el iterador pasa como valor de *'numTaquilla'* que es el segundo parametro que recibe el hilo .

Es Importante recalcar que al final de OPerar sobre 4 distintos HIlos es necesario Dictaminar que un Proceso termine para iniciar el segundo,es por eso la importancia de hacer **Join()** en el trabajo de los hilos 
 ```java
try {

                for (int j = 0; j < cantidadHilos; j++) {
                    Htread[iterador].join();
                }
            } catch (InterruptedException ex) {
                System.out.println("OCURRIO UN ERROR EN LA SINCRONISACION DE HILOS");
            }
        }
 ```
 
Mira Deployment para conocer como desplegar el proyecto desde Netbeans o Visual Studio Code.
## Pre-requisitos 📋

- JAVA SDK](#)
- NETBEANS ,VISUAL STUDIO CODE O IDE JAVA (#)
- GIT(#)



## Despliegue  📦

Proximamente

## Construido con 🛠️ 

Menciona las herramientas que utilizaste para crear tu proyecto

    Visual Studio Code - IDE de programacion
    Ant - Constructor de Proyectos Java
    Java SDK -JVM para compilar proyecto 
    Apache Netbeans - Usado para Generar el Proyecto ANT

## Contribuyendo 🖇️  

Por favor lee el CONTRIBUTING.md para detalles de nuestro código de conducta, y el proceso para enviarnos pull requests.
Wiki book

## LICENCIA 📄
Este proyecto está bajo una licencia libre ,sientete libre de hacer fork de el codigo o modificarlo . :))

    
