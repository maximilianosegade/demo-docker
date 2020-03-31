# demo-docker

## Demo App

Dentro del directorio [demo-app](https://github.com/maximilianosegade/demo-docker/tree/master/demo-app) se encuentra una aplicacion con Spring Boot que permite dar de alta clientes y consultarlos. Para ello se conecta a una BD.

### Ejecucion StandAlone

Para facilitar las pruebas, se puede ejecutar el script [docker_run.sh](https://github.com/maximilianosegade/demo-docker/blob/master/demo-app/docker_run.sh), que se encarga de:
* Compilar el codigo y generar el JAR de la aplicacion.
* Hacer el build de la imagen de docker.
* Ejecutar un container con dicha imagen, que escucha en el puerto 8080, y persiste en una DB in-memory H2.
