## CINE PROGRAMACION CONCURRENTE 

PROGRAMA DE CONTROL DE VENTAS DE TICKETS EN UN CINE POR SALAS IMPLEMENTANDO PROGRAMACION CONCURRENTE EN JAVA
## Comenzando 🚀
Para Descargar y desplegar el proyecto Es necesario contar Con git ,una terminal o algun cliente git como lo es GitKraken,Plugins en VSC
```bash
    $ git clone https://github.com/DanyeDarko/Cine.git
 ```
 ## CLASE CINE ABSTRACTA
 La clase 'DatosCineAbstracta' contiene todas las variables utiles y metodos implementados de la interfaz 'interfazCine'
 El ArrayList de tipo ArrayList Bidimensional tiene la siguiente arquitectura: 

![ARQUITECTURA DEL ARRAYLIST PRINCIPAL O RECURSO DE LO SHULOS](https://raw.githubusercontent.com/DanyeDarko/Cine/master/ARREGLO.png)

en donde la definicion del arreglo es :
'ArrayList< List< List<Integer>>> listaTaquillas = new ArrayList< List< List< Integer>>>();'

Declarando asi ,Un Arreglo de 3 dimensiones donde Cada una de estas dimensiones,Representara Una *Taquilla*,Que a su ves contendran Datos almacenados en un Array de 4 columnas *Numero cliente(numero de hilo)*,*Cant Boletos*,*Sala*,*Compra(1) o Devolucion(0)*.

### NOTA : el largo de las filas no es predeterminado ,Puesto que es un arreglo dinamico con el que se manejan los Datos


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
Este proyecto está bajo la Licencia (Tu Licencia) - mira el archivo LICENSE.md para detalles

    