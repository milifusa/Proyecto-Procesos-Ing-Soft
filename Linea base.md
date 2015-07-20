L�nea Base

Metodolog�a a utilizar: RUP
RUP (Proceso de Desarrollo Unificado) es un modelo de software que permite el desarrollo de software a gran escala, mediante un proceso continuo de pruebas y retroalimentaci�n, garantizando el cumplimiento de ciertos est�ndares de calidad. 
Actualmente es propiedad de International Business Machines (IBM) y est� basado en un enfoque disciplinado de asignaci�n de tareas y responsabilidades dentro de una organizaci�n de desarrollo con la finalidad de asegurar la obtenci�n de un software de alta calidad que satisfagan la necesidad de los usuarios finales dentro de un calendario y tiempo predecible.
Un desarrollo RUP se da a trav�s de cuatro fases: Inicio, Elaboraci�n, Construcci�n y Transici�n. Este ciclo de fases finaliza con una versi�n completa del producto de software.
 
Fig. 1 Fases de Rup
 En cada una de las fases antes mencionada cuenta con sus respectivos artefactos; Los artefactos son los elementos tangibles de un proyecto, elementos que el proyecto produce o usa mientras se trabaja en busca del producto final.
Inicio
Esta fase tiene el prop�sito de desarrollar la descripci�n del producto final con los patrocinadores e identificar y priorizar los riesgos m�s importantes. Propone una visi�n muy general de la arquitectura de software y producir el plan de las fases y el de iteraciones
Artefactos
?	Documento de visi�n
Desde el punto de vista del analista se analiza los requerimientos iniciales y se realiza la visi�n inicial de lo que ser� la aplicaci�n.  Este documento es una declaraci�n clara del problema, la soluci�n propuesta, y las caracter�sticas de alto nivel de un producto que ayudan a establecer las expectativas y reducir los riesgos de efecto del mismo.
El documento Visi�n es el principal artefacto en el cual el an�lisis del problema  a solucionar.
Un  documento de visi�n es aquel en el cual se define el alcance de alto nivel y prop�sito de un programa, producto o proyecto. Es una declaraci�n clara del problema, la soluci�n propuesta, y las caracter�sticas de alto nivel de un producto  que ayudan a establecer las expectativas y reducir los riesgos de efecto del mismo.

?	Especificaci�n de Requerimientos
Dependiendo de las necesidades que se muestren en el documento de visi�n, se pueden identificar los requisitos que pueden ser funcionales o no funcionales.   Una descripci�n completa del comportamiento del sistema que se va a desarrollar. Incluye un conjunto de casos de uso que describe todas las interacciones que tendr�n los usuarios con el software. Los casos de uso tambi�n son conocidos como requisitos funcionales. Adem�s de los casos de uso, la ERS tambi�n contiene requisitos no funcionales (o complementarios). Los requisitos no funcionales son requisitos que imponen restricciones en el dise�o o la implementaci�n, como, por ejemplo, restricciones en el dise�o o est�ndares de calidad.
1.	Identificar quien est� ocupando el sistema
2.	Escoger uno de esos usuarios.
3.	Definir lo que ese usuario va a realizar en el sistema. Cada cosa que hace el usuario    se convierte en un caso de uso.
4.	Para cada caso de uso se define el curso normal de eventos cuando el usuario se encuentra en el sistema
5.	Describir el curso b�sico  en la descripci�n para el caso de uso; describir en t�rminos de lo que hace el usuario en el sistema y lo que el sistema  hace en respuesta que el usuario debe tener en cuenta.
6.	Cuando el curso b�sico se describe considerar cursos alternativos de eventos y a�adir los respectivos extender�s al caso de uso.
7.	Busque por similitudes entre los diferentes casos de uso, extraiga estos y an�telos como casos de uso de curso com�n
8.	Repetir los pasos del 2 al 7 para todo el resto de actores

Elaboraci�n 
Se seleccionan los casos de uso que permiten definir la arquitectura base del sistema, se realiza la especificaci�n de los casos de uso seleccionados y el primer an�lisis del dominio del problema, se dise�a la soluci�n preliminar.
Artefactos
?	Modelo de casos de uso 
Se realiza el diagrama y especificaci�n de cada uno de los casos de uso dependiendo de los requisitos funcionales que se describen en el documento de visi�n. El modelo de casos de uso describe la funcionalidad propuesta del nuevo sistema. Un caso de uso representa una unidad discreta de interacci�n entre un usuario (humano o m�quina) y el sistema. Un Caso de Uso es una unidad simple de trabajo significativo
Construcci�n
El prop�sito de esta fase es completar la funcionalidad del sistema, para ello se deben clarificar los requerimientos pendientes, administrar los cambios de acuerdo a las evaluaciones realizados por los usuarios y se realizan las mejoras para el proyecto.
Artefactos

?	Diagrama de Clases
Diagrama de estructura est�tica que describe la estructura de un sistema mostrando las clases del sistema, sus atributos, operaciones (o m�todos), y las relaciones entre los objetos. Es importante resaltar que los diagramas de casos de uso no est�n pensados para representar el dise�o y no puede describir los elementos internos de un sistema. Los diagramas de casos de uso sirven para facilitar la comunicaci�n con los futuros usuarios del sistema, y con el cliente, y resultan especialmente �tiles para determinar las caracter�sticas necesarias que tendr� el sistema. En otras palabras, los diagramas de casos de uso describen qu� es lo que debe hacer el sistema, pero no c�mo.
 
Fig. 2 Ejemplo Diagrama de clases.
?	Diagrama de Secuencia
Un diagrama por caso de uso, pero s�lo para el flujo b�sico. Se debe seleccionar s�lo los caso de uso de alta prioridad o m�s importantes para el negocio.
Un diagrama de secuencia muestra la interacci�n de un conjunto de objetos en una aplicaci�n a trav�s del tiempo. Esta descripci�n es importante porque puede dar detalle a los casos de uso, aclar�ndolos al nivel de mensajes de los objetos existentes, como tambi�n muestra el uso de los mensajes de las clases dise�adas en el contexto de una operaci�n.
 
Fig. 3 Ejemplo de diagrama de secuencia.
?	Prototipo del Software
Es un modelo del comportamiento del sistema que puede ser usado para entenderlo completamente o ciertos aspectos de �l y as� clarificar los requerimiento, un prototipo es una representaci�n de un sistema, aunque no es un sistema completo, posee las caracter�sticas del sistema final o parte de ellas


Transici�n 
Esta fase se enfoca en asegurar que el software est� listo para los usuarios finales, ajustar los errores y defectos encontrados en las pruebas de aceptaci�n.
Artefactos

?	Manual de Usuario
Documento de comunicaci�n t�cnica destinado a dar asistencia a las personas que utilizan un sistema en particular. Por lo general, este documento est� redactado por un escritor t�cnico, como por ejemplo los programadores del sistema o los directores de proyectos implicados en su desarrollo, o el personal t�cnico, especialmente en las empresas m�s peque�as.

?	Manual de Instalaci�n y configuraci�n 
Documento de comunicaci�n t�cnica en el cual se brinda asistencia acerca de la instalaci�n correspondiente del programa a utilizar y de las configuraciones correspondientes para su uso correcto.

Bibliograf�a

�	http://ingsoftware072301.obolog.es/rational-unified-process-rup-proceso-racional-unificado-2006524
�	http://www.utvm.edu.mx/OrganoInformativo/orgJul07/RUP.htm
�	http://rupequipo1.blogspot.com/2012/12/que-es-rup.html
�	https://es.scribd.com/doc/97882986/ARTEFACTOS-RUP
�	Olivares, S., Zacar�as, I., Lera, L., Leyton, B., & Dur�n, R. (2005). Estado nutricional y consumo de alimentos seleccionados en escolares de la Regi�n Metropolitana: L�nea base para un proyecto de promoci�n del consumo de pescado. Revista chilena de nutrici�n, 32(2), 102-108.
