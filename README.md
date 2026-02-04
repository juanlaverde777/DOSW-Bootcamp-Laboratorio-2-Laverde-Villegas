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