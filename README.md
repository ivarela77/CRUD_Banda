# CRUD_Banda

![imagen principal](/capturas/crudBanda01.png)


> CRUD para gestionar una banda de música y los instrumentos.


### DESCRIPCIÓN
```
Primera parte del ejercicio que consta de una aplicación en la que se puede almacenar y 
gestionar los datos de los músicos e instrumentos de una banda. Para almacenar los datos
se realiza la conexión con la base de datos.
Se crea la clase Combo para gestionar los ComboBox que tienen las clases "Principal" y
"NuevoInstrumento", y para la gestión de fechas la librería JCalendar.

```
### DISEÑO
```
La aplicación consta de dos JDialog para dar de alta los nuevos músicos e instrumentos y
un JFrameForm principal en el que se encuentran todos los controles para añadir, modificar 
y eliminar tanto músicos como instrumentos. Para mostrar los resultados se utiliza un 
JTabbedPanel con una pestaña para los músicos y otra para los instrumentos. 
Dentro de cada pestaña se utiliza un JTable para listar los resultados correspondientes. 

```  

### FUNCIONAMIENTO

Para el funcionamiento de la aplicación tienes que cambiar los datos de la conexión en la clase 
"Principal" del paquete principal linea 26 con tus datos.
```java
ConexionBD conexion=new ConexionBD("Dirección ip","Usuario","Contraseña","BaseDeDatos");
```
> En la carpeta [dist/lib](https://github.com/ivarela77/CRUD_Banda/tree/master/dist) se encuentran las librerias necesarias y el script de la base de datos.
