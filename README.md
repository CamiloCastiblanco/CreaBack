# Let´s Draw
![img/img1.png](img/img1.png)
### -Juan Sebastian Garcia Hincapie
### -Juan Pablo contreras Amaya
### -Ricardo Amaya Rivera

## Descripción Básica

Es un juego multijugador en tiempo real, basado en el juego pictionary, el cual cuenta con un sistema de turnos, donde un jugador se encarga de dibujar una palabra especifica definida por el sistema y el resto de jugadores se encarga de adivinarla, mientras mas rápido se adivine, más puntos se obtienen.

## Diagramas
### casos de uso
![img/img2.png](img/img2.png)
![img/img3.png](img/img3.png)

### diagrama de componentes
![img/img5.png](img/img5.png)

### diagrama de despliegue
![img/img6.png](img/img6.png)

### diagrama de clases
![img/img7.png](img/img7.png)

## Funcionamiento
### Vista principal
La primera vista que se muestra permite al usuario seleccionar un nombre y un personaje o skin, ***sin alguno de estos 2 elementos falta no se puede avanzar a la siguiente vista***.
![img/img8.png](img/img8.png)
### Vista menú
Posteriormente nos dirige a la vista del menú, en esta se presentan 3 opciones como se muestra en la imagen.
![img/img9.png](img/img9.png)

### Opcion menú: Crear Sala
La primera opción **CREAR** permite al usuario crear una sala con: nombre, lenguaje, # de jugadores y la posibilidad de ser privado.

![img/img10.png](img/img10.png)

### Opcion menú: Unirse a sala
La segunda opción **UNIRSE** permite al usuario conectarse a una sala en especifico si conoce su numero de id.

![img/img11.png](img/img11.png)

### Opcion menu: Lobby
Por ultimo la opción **LOBBY** despliega la lista de salas disponibles , además de esto permite ver las características de las mismas.

![img/img12.png](img/img12.png)

### Vista al interior de una sala
Cualquiera de las opciones anteriormente mencionadas redirecciona al usuario al interior de una sala , en esta se encuentra una lista de usuarios(parte izquierda) , un chat(parte derecha) y un tablero para dibujar en la parte central.

![img/img13.png](img/img13.png)
además de esto en la parte inferior se encuentran las opciones de salir de la sala, limpiar el canvas , el color y el grosor del pincel .

![img/img15.png](img/img15.png)
Por ultimo podemos ver, cada que se acaba una ronda, una imagen como la que se muestra a continuación.

![img/img14.png](img/img14.png)

## Construido con

* [Java] (https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven] (https://maven.apache.org/)
* [Spring] (https://spring.io/projects/spring-boot)
* [AWS] (https://aws.amazon.com/es/)
* [Heroku] (https://www.heroku.com)

## Calidad de codigo y ci
### Back-end

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/d52e80c1dd0143af9d018f80e1a00e72)](https://www.codacy.com?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Lets-draw/BACKEND&amp;utm_campaign=Badge_Grade)

[![CircleCI](https://circleci.com/gh/Lets-draw/BACKEND/tree/master.svg?style=svg&circle-token=21fee0a4b8fee0df46596f4f2bdce7a9e8166add)](https://circleci.com/gh/Lets-draw/BACKEND/tree/master)

### Front-end

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/6782db487147454da08c649de70c8429)](https://www.codacy.com?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Lets-draw/FRONTEND&amp;utm_campaign=Badge_Grade)

[![CircleCI](https://circleci.com/gh/Lets-draw/FRONTEND/tree/main.svg?style=svg&circle-token=06533787438f4f08a837264a7036ea3b9a6491d5)](https://circleci.com/gh/Lets-draw/FRONTEND/tree/main)

# Licencia & Derechos de Autor

**©** Juan Sebastian Garcia Hincapie , Juan Pablo Contreras , Ricardo Amaya Rivera. [Escuela Colombiana de Ingeniería Julio Garavito](https://www.escuelaing.edu.co/es/)  
Licencia bajo la [GNU General Public License](/LICENSE).

