Autor del proyecto
Nombre: Rodrigo Flores Elizondo
Seccion 002_A
Carrera: Analista Programador Computacional
Sede: Campus Online

Descripcion del proyecto
El proyecto es una continuacion del proyector anterior para la empresa SpeedFast, en la que se resuelve la problematica de que repartidores acceden a la vez a la zona de carga provocando errores y entregas duplicadas.

Estructura general del proyecto
El proyecto esta estructurado en 3 paquetes: Model que contiene la clase Repartidor implementando la interfaz Runnable, la clase Pedido y ZonaDeCarga; el paquete States que contiene la clase enum Estado; y el paquete app que contiene la clase Main

Instrucciones
1- Clone el repositorio desde Github https://github.com/rodrigoflo02/DOO-II---Semana5.git
2- Abrir el proyecto con Intellij Idea 
3- En menu, abrir el proyecto seleccionando la carpeta de este 
4- Si desea modificar el codigo debe editar la informacion base de las instancias ubicadas en la clase Main (ejemplo, direcciones en instancias de Pedido como Pedido[] pedidos = {
                new Pedido(1, "Av. Vickuña Mackenna 2354", Estado.PENDIENTE)}; , en caso de cambiar la logica de metodos modificar metodos en clase ZonaDeCarga
5- Ejecutar la clase Main.java desde el paquete UI (Ctrl + F5).


