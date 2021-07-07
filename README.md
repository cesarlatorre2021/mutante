API REST para detectar secuencias de ADN

## Objetivo

Evaluar conocimientos en desarrollo API/Rest a través de la elaboración el proyecto para identificar el adn mutante para Magneto

## Introducción

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men. En donde se recibe como parámetro un array de Strings que representan cada fila de una tablade (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las cuales representa cada base nitrogenada del ADN.


## Status del Proyecto

Nivel 3 completo: 
* API REST con el objetivo de detectar ADN mutante desplegado en Heroku. 
* Agregado de estadísticas y persistencia en Base de Datos postgreSQL. 
* Test Coverage: 83%

## Instrucciones para su prueba

El servicio se encuentra desplegado en [https://adnmutantes.herokuapp.com/](https://adnmutantes.herokuapp.com/)

El servicio actualmente cuenta con los siguientes métodos:
 
 * Método POST para detectar si un ADN dado es mutante:<br><br>
  La URL del método es [https://adnmutantes.herokuapp.com/adn-mutante/api/mutant](https://adnmutantes.herokuapp.com/adn-mutante/api/mutant)<br><br>
Se puede detectar si un humano es mutante enviando la secuencia de ADN mediante un HTTP POST con un Json el cual tenga el siguiente formato:<br><br>
POST → /mutant/<br />
{<br />
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]<br />
}<br><br>
En caso de verificar que el ADN enviado es mutante, el método devuelve como respuesta un HTTP 200-OK, en caso contrario un
403-Forbidden <br><br>
* Método GET para obtener las estadísticas de las verificaciones de ADN para Magneto<br><br>
La URL del método es [https://adnmutantes.herokuapp.com/adn-mutante/api/stats](https://adnmutantes.herokuapp.com/adn-mutante/api/stats)<br><br>

## Descarga del código fuente
   
   Este proyecto utiliza Apache Maven embebido. Antes de empezar, asegurese de descargarlo e instalarlo. Luego, Maven descargará automáticamente las librerias requeridas por el proyecto
   
   #### Repositorio
   
   El código se encuentra alojado en GitHub. Para descargarlo necesita un cliente git, que puede encontrarlo en https://git-scm.com/downloads
   
   * Cree una carpeta en donde se incluirá el código fuente<br>
   * Abra su consola y posicionese en la carpeta previamente creada<br>
   * Ejecute el comando<br>
   
    git clone https://github.com/cesarlatorre2021/mutante.git
   
   Luego de que termine la descarga, usted tendrá clonado el branch master en la carpeta previamente creada.

## Environment

* Open jdk version 11
* IDE: Eclipse IDE 
* PostgreSQL

