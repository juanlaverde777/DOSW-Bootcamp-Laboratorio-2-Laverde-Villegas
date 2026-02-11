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

### RETO 2

- Categoría del patrón de diseño: Creacional
- Patrón Utilizado: Builder
- Justificación: El armado de la hamburguesa se hace paso a paso y puede variar según los ingredientes elegidos, por lo que separar la construcción del resultado final mantiene el código claro y abierto a nuevas combinaciones.
- ¿Cómo lo aplicó?: El `ChefApp` guía al usuario por consola para elegir ingredientes, `BurgerChef` usa `CustomBurgerBuilder` para añadir cada paso y `Burger` calcula el total con streams, mostrando al final la hamburguesa personalizada.

### RETO 4

- Categoría del patrón de diseño: Creacional
- Patrón Utilizado: Factory Method
- Justificación: La creación de un convertidor adecuado para la moneda origen se delega a un método fábrica, permitiendo cambiar o extender las tasas sin alterar el flujo de captura o reporte.
- ¿Cómo lo aplicó?: `ExchangeConsoleApp` lee múltiples transacciones por consola, `ConversionService` solicita un convertidor al `ConverterFactory` para cada moneda origen y `CurrencyConverter` (basado en tasas reales) convierte a los destinos; luego agrega totales por moneda con streams.
