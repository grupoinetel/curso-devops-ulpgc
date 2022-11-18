# Servicios docker
Es posible arrancar los servicios necesarios para desplegar y probar la aplicación mediante [docker-compose](https://docs.docker.com/compose/install/). 
A continuación se describe cómo personalizar algunos parámetros y cómo arrancar los servicios.

## Servicios disponibles
El fichero [docker-compose.yml](./docker-compose.yml) configura una serie de servicios preconfiguracos para lanzar para 
iniciar una serie de servicios necesarios para desplegar los diferentes componentes de la aplicación y 
permitir el despliegue de los diferentes componentes y permitir probarlos y depurarlos.

Los servicios presentes son:
* ___sitycleta-postgres___: PostgreSQL 12.x con PostGIS 3.0.x instalado. 
* ___sitycleta-tomcat___: Tomcat 9.0.x con OpenJDK 11, configurado para arrancar en modo debug (_jpda_) para
facilitar la depuración de los componentes desplegados, además de escuchar por HTTPS para obtener un 
comportamiento similar al entorno final (usa un certificado autofirmado por lo que habrá que tenerlo en
cuenta en los clientes usados).
* ___sitycleta-sftp___: servidor SFTP que permite acceder de forma más fácil a los miembros del equipo que 
utilicen Windows en lugar de Linux. Dichos usuarios pueden usar un cliente SFTP (por ejemplo [WinSCP](https://winscp.net/eng/download.php))
y acceder a los volúmenes publicados por los servicios. Las credenciales usuario/contraseña 
son __docker/docker__, y en el directorio `/home/docker` están accesibles los diferentes volúmenes.

## Configuración de los servicios
Los siguientes servicios pueden configurarse usando variables de entorno, o bien presentes en el entorno
donde se ejecutará docker-compose, o bien usando un fichero ___.env___ con los pares `VARIABLE_ENTORNO=VALOR` 
especificados, uno por línea. No se debe incluir este fichero ___.env___ en el sistema de control de versiones ya
que es específico para cada usuario.

Si no se especifican variables de entorno se usarán los valores por defectos indicados.

* ___sitycleta-postgres___
  * POSTGRES_DB: nombre de la base de datos que se creará en el primer arranque de PostgreSQL. Por defecto __"sitycleta"__.
  * POSTGRES_USER: nombre de usuario administrador y  propietario de la anterior base de datos. Por defecto __"sitycleta"__.
  * POSTGRES_PASSWORD: contraseña del usuario. Por defecto __"sitycleta"__.
  * POSTGRES_PORT: puerto por el que será accesible PostgreSQL en el _host_. Por defecto __5432__.
* ___sitycleta-tomcat___
  * TOMCAT_HTTPS_PORT: puerto por el que será accesible Tomcat, usando HTTPS. por defecto ___8443___.
  * TOMCAT_DEBUG_PORT: puerto JPDA por el que será posible conectar el depurador Java a Tomcat. Por defecto ___8000____.
* ___sitycleta-sftp___
  * SFTP_PORT: puerto por el que se podrá acceder al servicio SFTP desde el _host_. Por defecto ___2222___.
  
## Volúmenes publicados
Algunos servicios publican volúmenes para poder acceder e interactuar con los ficheros del contenedor 
asociados a los directorios que representan dichos volúmenes. A continuación se enumeran los volúmenes 
expuestos por cada servicio:

* ___sitycleta-postgres___
  * sitycleta_postgresql_vol: directorio `/var/lib/postgresql/data`.
* ___sitycleta-tomcat___
  * sitycleta_tomcat_tmp_vol: directorio `/tmp`.
  * sitycleta_tomcat_webapps_vol: directorio `/usr/local/tomcat/webapps`.
  * sitycleta_tomcat_logs_vol: directorio `/usr/local/tomcat/logs`.
  
Para acceder al contenido de los volúmenes expuestos al _host_ podremos usar los comando `docker volume *`, 
pero es preferible usar clientres visuales que permitan usar las herramientas más productivas para 
los miembros del equipo:
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

* Mediante **SFTP** (hosts Windows/Linux)

  Ejecutar WinSCP o un cliente similar y acceder a la IP de la interfaz docker, puerto _2222_ 
  (o la indicada en la variable de entorno `SFTP_PORT`), con el usuario
  ___"docker"___, contraseña ___"docker"___ (sin comillas en ambos casos). En el directorio `/home/docker` 
  aparecerán los volúmenes publicados para este proyecto (únicamente los de este proyecto). 

## Red interna
Cada servicio tiene un nombre asociado dentro de la red privada del proyecto, así como unos puertos asociados
a cada servicio:
* ___sitycleta-postgres___:  
  * _postgres:5432_ -> servidor PostgreSQL (publicado en el _host_)
* ___sitycleta-tomcat___: 
  *  _tomcat:8443_ -> servidor Tomcat, protocolo HTTPS (publicado en el _host_)
  *  _tomcat:8080_ -> servidor Tomcat, protocolo HTTP
  *  _tomcat:8000_ -> servidor Tomcat, protocolo JPDA para permitir depurar (publicado en el _host_)
  *  _tomcat:8009_ -> servidor Tomcat, protocolo AJP
* ___sitycleta-sftp___: 
  * _sftp:22_ -> servidor SFTP (publicado en el _host_)
  
## Arranque de los servicios
Los servicios se iniciarán con el comando:
```bash
docker-compose up
```

Una vez arrancado la salida estándar y de error se mostrarán en pantalla. Para parar los servicios habrá
que pulsar `CTRL-C`.
