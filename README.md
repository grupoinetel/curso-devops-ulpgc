# curso-devops-ulpgc

Aplicación de ejemplo sobre Reseñas de Libros para explicar el proceso completo de desarrollo y despliegue.

# Servicios docker "docker-compose.yml"
Es posible arrancar los servicios necesarios para desplegar y probar la aplicación mediante [docker-compose](https://docs.docker.com/compose/install/). 
A continuación se describe cómo personalizar algunos parámetros y cómo arrancar los servicios.

## Servicios disponibles
El fichero [docker-compose.yml](docker-compose.yml) configura una serie de servicios preconfiguracos para lanzar para iniciar una serie de servicios necesarios para desplegar los diferentes componentes de la aplicación y permitir el despliegue de los diferentes componentes y permitir probarlos.

Los servicios presentes son:
* ___bookReview_bdd___: PostgreSQL 15.1 
* ___bookReview_back___: Tomcat - API
* ___bookReview_front___: Nginx - Ionic/Angular

## Configuración de los servicios
Los siguientes servicios pueden configurarse usando variables de entorno, o bien presentes en el entorno donde se ejecutará docker-compose, o bien usando un fichero ___.env___ con los pares `VARIABLE_ENTORNO=VALOR` especificados, uno por línea. No se debe incluir este fichero ___.env___ en el sistema de control de versiones ya que es específico para cada usuario.

Si no se especifican variables de entorno se usarán los valores por defectos indicados.

* ___bookReview_bdd___
  * POSTGRES_DB: nombre de la base de datos que se creará en el primer arranque de PostgreSQL. Por defecto __"cursoDevops"__.
  * POSTGRES_USER: nombre de usuario administrador y  propietario de la anterior base de datos. Por defecto __"cursoDevops"__.
  * POSTGRES_PASSWORD: contraseña del usuario. Por defecto __"cursoDevops"__.
  
## Volúmenes publicados
Algunos servicios publican volúmenes para poder acceder e interactuar con los ficheros del contenedor asociados a los directorios que representan dichos volúmenes. A continuación se enumeran los volúmenes expuestos por cada servicio:

* ___bookReview_bdd___
  * bookReview_bdd_vol: directorio `/var/lib/postgresql/data`.
* ___bookReview_back___
  * bookReview_back_tmp_vol: directorio `/tmp` en el que se encuentra el resultado del compilado.
* ___bookReview_front___
  * bookReview_front_dist_vol: directorio `/app/dist` en el que se encuentra el resultado del compilado.
  
Para acceder al contenido de los volúmenes expuestos al _host_ podremos usar los comando `docker volume *`, pero es preferible usar clientres visuales que permitan usar las herramientas más productivas para los miembros del equipo:

Ruta para acceder a los volúmenes (puede cambiar según versiones):
* En windows: \\wsl$\docker-desktop-data\data\docker\volumes
* En linux: /var/lib/docker/volumes/
* Mediante **CIFS/SMB** (hosts Linux)

  Usar el siguiente comando para publicar los volúmenes en una unidad CIFS: 
  ```bash
  docker run --name volume-sharer \
             --rm \
             -d \
             -v volume-sharer-conf:/etc/samba \
             -v /var/lib/docker/volumes:/docker_volumes \
             -p 1139:139 \
             -p 1445:445 \
             -v /var/run/docker.sock:/var/run/docker.sock \
             gdiepen/volume-sharer

  ```
  Esto creará una unidad compartida accesible en el puerto 1139, accesible, por ejemplo, mediante `smb://127.0.0.1:1139`.
  
  Esta solución permite acceder no sólo a los volúmenes de este proyecto, sino a todos los volúmenes presentes
  en el _host_.

## Red interna
Cada servicio tiene un nombre asociado dentro de la red privada del proyecto, así como unos puertos asociados a cada servicio:
* ___bookReview_bdd___:  
  * _bdd:5432_ -> servidor PostgreSQL (publicado en el _host_)
* ___bookReview_back___:  
  * _back:8080_ -> servidor Tomcat (publicado en el _host_)
* ___bookReview_front___:  
  * _front:80_ -> servidor NGinx (publicado en el _host_)
  
## Arranque de los servicios
Los servicios se iniciarán con el comando:
```bash
docker-compose up
```

Una vez arrancado la salida estándar y de error se mostrarán en pantalla. Para parar los servicios habrá que pulsar `CTRL-C`.

# Servicios docker "docker-compose.api.yml"
Este docker compose es equivalente pero no arranca la parte del front. Es apropiado para arrancar el desarrollo en el front, ya que hace posible disponer del API.