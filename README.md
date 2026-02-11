# LABORATORIO 2: SOLID - Patrones de Diseño - Diagramación UML Clases y POO Avanzada

---

### INTEGRANTES

- Juan Manuel Villegas Medina
- Juan José Laverde Ríos

---

#### Evidencias de compilación del proyecto:

- Compilación por 'mvn clean compile':
![img.png](docs/imagenes/MVNCleanCompile.png)


- Compilación por 'mvn exec:java -D"exec.mainClass=edu.dosw.bootcamp.lab.DOSW_Bootcamp_Laboratorio_02.DoswBootcampLaboratorio02Application"'
![img.png](docs/imagenes/SegundaEvidencia.png)

### RETO 1
Iniciamos este reto creando una nueva branch para trabajar separados del main 

<img width="950" height="359" alt="image" src="https://github.com/user-attachments/assets/aae97956-e3ac-4c3b-a312-08b9dc7cfc0c" />

Una vez tenemos nuestro espacio de trabajo configurado creamos dentro de la carpeta de comportamiento nuestro Reto 1 ya que usaremos este patron para darle solucion a nuestro problema C:\Users\josef\DOSW-Bootcamp-Laboratorio-2-Laverde-Villegas\src\main\java\edu\dosw\bootcamp\lab\DOSW_Bootcamp_Laboratorio_02\comportamiento 

Ahora hacemos esto asi ya que el patron de diseño Strategy lo usamos con el objetico de aplicar diferentyes estrategias de descuento segun el tipo de cliente. para esto pensamos una estuctura de clase de esta forma: 

<img width="276" height="173" alt="image" src="https://github.com/user-attachments/assets/29eccbd8-d9d2-426f-acdb-938b3edbe6f6" />

producto representa el objeto con nombre y un precio, cartitem representa un producto con su cantidad dentro del carrito, discountstrategy es la interfaz que define el comportamiento de calculo de descuento, discountnuevo es la estrategia de descuento para nuevos clientes, dicountfrecuente es la estrategia de decuento para clientes frecuentes, carrito es donde gestionamos los productos y el subtotal mas los descuentos, receiptgenerator es donde se genera el recibo de lo comprado, y el Maindemo es donde ejecutamos o sea la clase principal del reto1

Ahora para los principios SOLID los dividimos de esta forma para la funcionalidad de nuestro reto:

#### Principio de Responsabilidad Unica

En el Reto 1 aplicamos el principio de responsabilidad única separando claramente las funciones de cada clase. Por ejemplo, la clase Producto solo representa la información de un producto, Carrito se encarga de gestionar los productos y calcular los valores de la compra, las clases de descuento en discountNuevo y DiscountFrecuente solo calculan el descuento, y ReceiptGenerator se encarga de generar el recibo De esta forma cada clase tiene un propósito específico y no mezcla varias responsabilidades

#### Principio Abierto/Cerrado 

Aplicamos el principio abierto/cerrado al diseñar el sistema de descuentos mediante la interfaz DiscountStrategy Gracias a esto, si en el futuro queremos agregar un nuevo tipo de descuento no es necesario modificar la clase Carrito, sino simplemente crear una nueva clase que implemente la interfaz el sistema puede extenderse sin alterar el código existente lo que hace la solución más flexible y fácil de mantener

#### Principio de Sustitución de Liskov

El principio de sustitución de Liskov se cumple porque las clases DiscountNuevo y DiscountFrecuente pueden usarse en lugar de DiscountStrategy sin afectar el funcionamiento del programa En el carrito no importa qué tipo de descuento se esté utilizando ya que todas las estrategias cumplen el mismo contrato definido por la interfaz Esto permite cambiar el comportamiento del descuento sin romper la lógica del sistema

#### Principio de Segregación de Interfaces

En nuestra solución aplicamos el principio de segregación de interfaces al definir una interfaz DiscountStrategy sencilla que contiene únicamente el método necesario para calcular el descuento De esta manera las clases que implementan la interfaz no se ven obligadas a depender de métodos que no necesitan lo que mantiene las interfaces simples, claras y enfocadas en una sola funcionalidad

#### Principio de Inversión de Dependencias

Aplicamos el principio de inversión de dependencias haciendo que la clase Carrito dependa de la abstracción DiscountStrategy y no de las implementaciones concretas de los descuentos. Esto permite cambiar fácilmente la estrategia de descuento sin modificar el código del carrito Gracias a esto el sistema queda menos acoplado y más preparado para futuros cambios o extensiones

Ahora despues de lo explicada ejecutamos nuestro main y nos da como restado esto en nuestra terminal:

<img width="284" height="187" alt="image" src="https://github.com/user-attachments/assets/7a50d0c1-f015-4de9-b8cd-8fb0c1ceac11" />

<img width="250" height="175" alt="image" src="https://github.com/user-attachments/assets/adf90f7f-2dbe-49de-8cca-6ba62e163554" />

Lo que nos indica que nuestro codigo funciona ya que se aplican los descuentos y los productos de acuerdo a como se propone en el reto

En visual nos queda una estructura de esta forma 

<img width="945" height="779" alt="image" src="https://github.com/user-attachments/assets/fc1b65fe-0134-40c0-9f40-2246633bdf53" />

Ahora con respecto al polimorfismo se aplica dentrro de la clase de la interfaz de DiscountStrategy, la clase de carrito trabaja con la abstraccion discountstrategy pero cuando se ejecuta se pueden usar diferentes implementaciones siendo discountnuevo o discountfrecuente

<img width="723" height="136" alt="image" src="https://github.com/user-attachments/assets/4e9af3ee-7f8e-45ea-a493-750fd62b8452" />

<img width="639" height="844" alt="image" src="https://github.com/user-attachments/assets/ea071881-21d0-446f-ac6a-d13e901184b7" />

Ambos objetos son tratados como discountstrategy pero ejecutan comportamientos diferentes segun el cliente ya que pues hay 2 tipos diferentes de descuento, esto permite que un mismo metodo tenga multiples comportamientos dependiendo de la estrategia utilizada





### Preguntas inciales
 
- 1)¿Qué ventaja ofrece el polimorfismo en el diseño de clases frente al uso de múltiples condicionales para determinar el comportamiento de un objeto?
 
### Respuesta:
 
 - La principal ventaja es que el código se vuelve mucho más claro y fácil de mantener. En lugar de estar llenando las clases de if o switch para decidir qué hacer según el tipo de objeto, dejamos que cada objeto se comporte como le corresponde. Nosotros simplemente llamamos al método y listo. Eso hace que el sistema sea más ordenado, más fácil de extender y menos propenso a errores cuando en el futuro tengamos que agregar nuevos comportamientos, como se plantea en el laborator
 
 - 2)¿Por qué una clase inmutable puede mejorar la seguridad?
 
### Respuesta:
 
 - Porque una clase inmutable no cambia una vez creada, y eso nos da mucha tranquilidad. Sabemos que sus datos no van a ser modificados por accidente ni por otro hilo del programa. Eso reduce errores difíciles de detectar y evita comportamientos inesperados. Además, cuando compartimos ese objeto entre varias partes del sistema, no tenemos que preocuparnos de que alguien lo modifique y afecte a los demás.
 
 - 3)Según el principio de Abierto/Cerrado, ¿cómo deberíamos modificar el sistema si queremos añadir una nueva funcionalidad sin alterar el código existente?
 
### Respuesta:
 
 - La idea es no tocar lo que ya funciona. En lugar de modificar clases existentes, lo que hacemos es crear nuevas clases que se adapten a la estructura que ya está definida, por ejemplo implementando una interfaz o extendiendo una clase abstracta. Así el sistema crece sin romper nada, aprovechando lo que ya está probado y evitando introducir errores innecesarios.
 
 - 4)¿Qué es y por qué usamos el pom.xml?
 
### Respuesta:
 
 - El pom.xml es básicamente el corazón del proyecto cuando usamos Maven. Ahí está toda la información importante: qué dependencias usamos, cómo se compila el proyecto y qué versiones estamos manejando. Lo usamos porque nos ahorra muchísimo trabajo, ya que Maven se encarga de descargar librerías, compilar, ejecutar pruebas y empaquetar el proyecto de forma automática y ordenada, tal como se trabaja en el laboratorio.
 
 - 5)¿Qué diferencia hay entre mvn compile, mvn package y mvn install?
 
### Respuesta:
 
 - mvn compile solo se encarga de compilar el código para verificar que todo esté bien escrito. mvn package va un paso más allá y, además de compilar, genera el archivo final del proyecto, como un .jar. Y mvn install hace todo eso pero además guarda ese resultado en el repositorio local de Maven, lo que permite que otros proyectos nuestros puedan usarlo sin problema.
 
 - 6)¿Qué diferencia existe entre una interfaz y una clase abstracta?
 
### Respuesta:
 
 - La diferencia está en el nivel de responsabilidad que tienen. Una interfaz define qué debe hacer una clase, pero no cómo hacerlo, es más un contrato. En cambio, una clase abstracta ya puede tener parte del comportamiento definido y compartir atributos o métodos entre sus subclases. Nosotros usamos interfaces cuando queremos flexibilidad y clases abstractas cuando hay lógica común que vale la pena reutilizar.
