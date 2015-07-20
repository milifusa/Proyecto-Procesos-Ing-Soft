Línea Base

Metodología a utilizar: RUP
RUP (Proceso de Desarrollo Unificado) es un modelo de software que permite el desarrollo de software a gran escala, mediante un proceso continuo de pruebas y retroalimentación, garantizando el cumplimiento de ciertos estándares de calidad. 
Actualmente es propiedad de International Business Machines (IBM) y está basado en un enfoque disciplinado de asignación de tareas y responsabilidades dentro de una organización de desarrollo con la finalidad de asegurar la obtención de un software de alta calidad que satisfagan la necesidad de los usuarios finales dentro de un calendario y tiempo predecible.
Un desarrollo RUP se da a través de cuatro fases: Inicio, Elaboración, Construcción y Transición. Este ciclo de fases finaliza con una versión completa del producto de software.
 
Fig. 1 Fases de Rup
 En cada una de las fases antes mencionada cuenta con sus respectivos artefactos; Los artefactos son los elementos tangibles de un proyecto, elementos que el proyecto produce o usa mientras se trabaja en busca del producto final.
Inicio
Esta fase tiene el propósito de desarrollar la descripción del producto final con los patrocinadores e identificar y priorizar los riesgos más importantes. Propone una visión muy general de la arquitectura de software y producir el plan de las fases y el de iteraciones
Artefactos
?	Documento de visión
Desde el punto de vista del analista se analiza los requerimientos iniciales y se realiza la visión inicial de lo que será la aplicación.  Este documento es una declaración clara del problema, la solución propuesta, y las características de alto nivel de un producto que ayudan a establecer las expectativas y reducir los riesgos de efecto del mismo.
El documento Visión es el principal artefacto en el cual el análisis del problema  a solucionar.
Un  documento de visión es aquel en el cual se define el alcance de alto nivel y propósito de un programa, producto o proyecto. Es una declaración clara del problema, la solución propuesta, y las características de alto nivel de un producto  que ayudan a establecer las expectativas y reducir los riesgos de efecto del mismo.

?	Especificación de Requerimientos
Dependiendo de las necesidades que se muestren en el documento de visión, se pueden identificar los requisitos que pueden ser funcionales o no funcionales.   Una descripción completa del comportamiento del sistema que se va a desarrollar. Incluye un conjunto de casos de uso que describe todas las interacciones que tendrán los usuarios con el software. Los casos de uso también son conocidos como requisitos funcionales. Además de los casos de uso, la ERS también contiene requisitos no funcionales (o complementarios). Los requisitos no funcionales son requisitos que imponen restricciones en el diseño o la implementación, como, por ejemplo, restricciones en el diseño o estándares de calidad.
1.	Identificar quien está ocupando el sistema
2.	Escoger uno de esos usuarios.
3.	Definir lo que ese usuario va a realizar en el sistema. Cada cosa que hace el usuario    se convierte en un caso de uso.
4.	Para cada caso de uso se define el curso normal de eventos cuando el usuario se encuentra en el sistema
5.	Describir el curso básico  en la descripción para el caso de uso; describir en términos de lo que hace el usuario en el sistema y lo que el sistema  hace en respuesta que el usuario debe tener en cuenta.
6.	Cuando el curso básico se describe considerar cursos alternativos de eventos y añadir los respectivos extender’s al caso de uso.
7.	Busque por similitudes entre los diferentes casos de uso, extraiga estos y anótelos como casos de uso de curso común
8.	Repetir los pasos del 2 al 7 para todo el resto de actores

Elaboración 
Se seleccionan los casos de uso que permiten definir la arquitectura base del sistema, se realiza la especificación de los casos de uso seleccionados y el primer análisis del dominio del problema, se diseña la solución preliminar.
Artefactos
?	Modelo de casos de uso 
Se realiza el diagrama y especificación de cada uno de los casos de uso dependiendo de los requisitos funcionales que se describen en el documento de visión. El modelo de casos de uso describe la funcionalidad propuesta del nuevo sistema. Un caso de uso representa una unidad discreta de interacción entre un usuario (humano o máquina) y el sistema. Un Caso de Uso es una unidad simple de trabajo significativo
Construcción
El propósito de esta fase es completar la funcionalidad del sistema, para ello se deben clarificar los requerimientos pendientes, administrar los cambios de acuerdo a las evaluaciones realizados por los usuarios y se realizan las mejoras para el proyecto.
Artefactos

?	Diagrama de Clases
Diagrama de estructura estática que describe la estructura de un sistema mostrando las clases del sistema, sus atributos, operaciones (o métodos), y las relaciones entre los objetos. Es importante resaltar que los diagramas de casos de uso no están pensados para representar el diseño y no puede describir los elementos internos de un sistema. Los diagramas de casos de uso sirven para facilitar la comunicación con los futuros usuarios del sistema, y con el cliente, y resultan especialmente útiles para determinar las características necesarias que tendrá el sistema. En otras palabras, los diagramas de casos de uso describen qué es lo que debe hacer el sistema, pero no cómo.
 
Fig. 2 Ejemplo Diagrama de clases.
?	Diagrama de Secuencia
Un diagrama por caso de uso, pero sólo para el flujo básico. Se debe seleccionar sólo los caso de uso de alta prioridad o más importantes para el negocio.
Un diagrama de secuencia muestra la interacción de un conjunto de objetos en una aplicación a través del tiempo. Esta descripción es importante porque puede dar detalle a los casos de uso, aclarándolos al nivel de mensajes de los objetos existentes, como también muestra el uso de los mensajes de las clases diseñadas en el contexto de una operación.
 
Fig. 3 Ejemplo de diagrama de secuencia.
?	Prototipo del Software
Es un modelo del comportamiento del sistema que puede ser usado para entenderlo completamente o ciertos aspectos de él y así clarificar los requerimiento, un prototipo es una representación de un sistema, aunque no es un sistema completo, posee las características del sistema final o parte de ellas


Transición 
Esta fase se enfoca en asegurar que el software esté listo para los usuarios finales, ajustar los errores y defectos encontrados en las pruebas de aceptación.
Artefactos

?	Manual de Usuario
Documento de comunicación técnica destinado a dar asistencia a las personas que utilizan un sistema en particular. Por lo general, este documento está redactado por un escritor técnico, como por ejemplo los programadores del sistema o los directores de proyectos implicados en su desarrollo, o el personal técnico, especialmente en las empresas más pequeñas.

?	Manual de Instalación y configuración 
Documento de comunicación técnica en el cual se brinda asistencia acerca de la instalación correspondiente del programa a utilizar y de las configuraciones correspondientes para su uso correcto.

Bibliografía

•	http://ingsoftware072301.obolog.es/rational-unified-process-rup-proceso-racional-unificado-2006524
•	http://www.utvm.edu.mx/OrganoInformativo/orgJul07/RUP.htm
•	http://rupequipo1.blogspot.com/2012/12/que-es-rup.html
•	https://es.scribd.com/doc/97882986/ARTEFACTOS-RUP
•	Olivares, S., Zacarías, I., Lera, L., Leyton, B., & Durán, R. (2005). Estado nutricional y consumo de alimentos seleccionados en escolares de la Región Metropolitana: Línea base para un proyecto de promoción del consumo de pescado. Revista chilena de nutrición, 32(2), 102-108.
