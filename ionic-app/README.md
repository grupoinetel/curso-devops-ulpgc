# Servicios docker (Ionic)
Se puede compilar y ejecutar el proyecto Ionic mediante [docker-compose](https://docs.docker.com/compose/install/).
A continuación se describe cómo arrancar los servicios necesarios para ello.

## Servicios disponibles
El fichero [docker-compose.yml](docker-compose.yml) incluye la definición de una serie de servicios, redes y volúmenes preconfigurados para
su inicio que facilitará la compilación y la ejecución del proyecto Ionic.

Los servicios presentes son:
* ___bookReview-ionic___: Ionic 6.20.8

## Volúmenes publicados
Algunos servicios publican volúmenes para poder acceder e interactuar con los ficheros del contenedor
asociados a los directorios que representan dichos volúmenes. En el caso actual, se utilizará la ubicación actual como punto de montaje del volumen.

## Arranque de los servicios
Hay que tener en cuenta que la ejecución del comando de arranque de los servicios docker debe realizarse desde la propia ubicación del proyecto ionic.

El comando que debe utilizarse para arrancar los servicios necesarios para el proyecto Ionic es el siguiente:
```bash
docker-compose run --rm bookReview-ionic
```

El comando iniciará los servicios necesarios que permitirán compilar y ejecutar el proyecto Ionic. 
