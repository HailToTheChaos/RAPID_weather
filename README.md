<h1>Introducción de la aplicación.</h1>
Nuestra aplicación se encarga de darnos datos relevantes del tiempo de un determinado municipio de España. 

Recogemos los datos de la Agencia Estatal de Meteorología a través de su propia API.
El funcionamiento de cara al usuario es el siguiente: el usuario realiza una petición de tiempo poniendo el nombre de un municipio. A continuación, pulsaremos el botón ‘CONSULTAR’ para realizar la petición a la API y rescatar los datos necesarios.

El proyecto comenzó siendo una inspiración de la aplicación del tiempo propia de la AEMET. 

Respecto a otras aplicaciones del tiempo, nuestra aplicación implementa la API de AEMET.
Eso nos da más precisión a la hora de consultar el tiempo a nivel del territorio español, ya que la misma agencia tiene sus propias estaciones meteorológicas.

El desarrollo de la aplicación ha sido desde cero, ya que no hemos cogido código existente.
Si es cierto que nos hemos documentado ampliamente en varias fuentes para llegar al resultado actual, ya sea para hacer request a la API, recoger los datos de ella o implementar Firebase.

A la hora de elegir la API, encontramos opciones como Rapidapi.com (distribuidora de APIs)  o elTiempo.net, pero nos decidimos al final por la API de AEMET. 
Al ser la propia API de una institución pública nos transmitía más confianza a la hora de obtener los datos, ya que son de sus propias estaciones meteorológicas.


Ilustración flujo de ejecución de la aplicación
Nuestra aplicación comienza con un login en el que el usuario debe ingresar su email y contraseña. Una vez ingresados dichos campos se le debe dar al botón ‘ACCEDER’ para tener acceso completo a la aplicación. Tenemos un botón especial que sirve para que tu sesión no se cierre una vez cerrada la aplicación que es el botón de ‘Recuerdame’. También tenemos dos apartados más. Uno para crearse una cuenta con la que poder acceder y otro para poder recuperar la contraseña.

Pasemos al crear cuenta. Consta de varios campos necesarios para poder loguearse: Nombre, Email, Contraseña y la confirmación de la contraseña. Tiene dos botones para Volver al Login y otro para confirmar el registro, realiza varias validaciones en los campos para que no haya errores.

A continuación pasaremos a la recuperación de la contraseña. Esta actividad funciona de la siguiente manera. El usuario rellena el apartado de email y le da al botón de ‘Recuperar’, se le enviará a su gmail un mensaje de reseteo de contraseña, a continuación el usuario se debe de dirigir al correo y abrir el enlace. Se le aparecerá una ventana para cambiar la contraseña, ahí deberá insertar la nueva contraseña.



















Una vez el usuario se ha logueado, le aparecerá una nueva actividad que le dejará hacer dos opciones, una Cerrar sesión y otra cambiar a la actividad de consultar tiempo.

Finalmente llegamos a la actividad para consultar el tiempo. En esta actividad hay un EditText en el que debemos de escribir el nombre del municipio. A continuación pulsamos el botón de ‘CONSULTAR’ y nos mostraría algo similar al ejemplo de abajo.


<h2>Elementos introducidos en la aplicación</h2>

<h3>¿Qué es una API?</h3>

Una API (del inglés: Application Programming Interface), es el conjunto de subrutinas, funciones y procedimientos que ofrece cierto ente (en este caso, AEMET) para ser utilizado por un software de un tercero para la obtención de datos, información, documentos, etc.

En este caso, hemos implementado en Java el protocolo API REST, el cual es una un API apoyada totalmente en el estándar HTTP. Visto de una forma más sencilla, una API REST es un servicio que nos provee de funciones que nos dan la capacidad de hacer uso de un servicio web que no es nuestro, dentro de una aplicación propia, de manera segura.

<h3>Tipos de acceso</h3>
En la AEMET OpenData hay dos tipos de acceso a usuarios: el acceso general y el acceso para desarrolladores.

El acceso para el público en general tiene como finalidad el permitir el acceso a los datos para usuarios de una manera amigable. Por otro lado, el acceso para desarrolladores se caracteriza por la posibilidad de ser periódica e incluso programada, realizada a través de un API destinada a un sistema informático, que permite a los usuarios el incluir los datos de AEMET en sus propios sistemas de información.


<h3>Obtención de la API: AEMET OpenData.</h3>
Para la obtención de la API nos hemos metido en la página de AEMET OpenData. Dicha API permite la difusión y la reutilización de la información meteorológica y climatológica de la Agencia Estatal de Meteorología (AEMET).

Primero, hemos solicitado nuestra API Key, la cual es completamente gratuita.
Las API Keys son identificadores únicos otorgados a cada solicitante, mediante los cuales se contabilizan e imputan los accesos que un usuario realiza al API.

La API Key se puede solicitar desde la opción "Obtención de API Key" de la página principal de AEMET OpenData introduciendo su dirección de correo electrónico.
Una vez introducido el email, nos llega un correo con el enlace de activación y posteriormente, te envían otro con la API Key.




<h3>Acceso para desarrolladores</h3>

En nuestro caso, nosotros hemos utilizado el acceso a desarrolladores, el cual ofrece tres apartados para la implementación de la API.



En el primer caso tenemos la parte de documentación, la cual nos da acceso a la documentación dinámica de AEMET OpenData y a la herramienta de HATEOAS, que permite conocer los recursos del API y sus detalles. Swagger UI (aemet.es)

Para la obtención del enlace de petición, nos hemos centrado en el apartado de predicciones específicas.
Para nuestra aplicación, hemos utilizado el enlace de la predicción del municipio diaria.
Previo a ello, se debe conocer el código INE (Instituto Nacional de Estadística) para poder hacer la consulta.


En la propia página se puede hacer una prueba de la consulta.



En segundo lugar, tenemos los ejemplos de como hacer la consulta a la API en distintos lenguajes de programación. En nuestro caso, elegimos Java.



Dentro del ejemplo del cliente de Java, tenemos la opción de hacer la consulta con la librería de OKHTTP o por la de UNIREST. Nosotros hemos elegido la primera opción.
Cabe destacar que las consultas de las API Rest devuelven la información en forma de JSON.

<h3>¿Qué es OKHTTP3?</h3>
OKHTTP3 es una librería de código abierto la cual permite realizar operaciones tanto en HTTP como en SPDY de manera sencilla y eficiente en ambientes Java (versión 1.7 como mínimo) y Android (2.3 como mínimo), sin necesidad de cambiar el código de la aplicación entre ambas plataformas, con una interfaz fluida.

<h3>¿Qué es JSON?</h3>
JSON es un lenguaje de marcas sencillo para el intercambio de datos. Se trata de un subconjunto de la notación literal de objetos de JavaScript, aunque, debido a su amplia adopción como alternativa a XML, se considera un formato independiente del lenguaje.

<h3>Herramientas utilizadas para JSON</h3>
Hemos utilizado el editor de código VSCode para leer el JSON, una extensión para ayudarnos a visualizar el código mejor llamado Sort JSON Objects y Postman, una plataforma para realizar pruebas con API Rest.


 

<h3>Implementación de la API</h3>
Una vez obtenida toda la información de la API, procedemos a implementar la API en Android Studio.
En primer lugar, hemos utilizado las siguientes dependencias: OKHTTP3 (para la consulta de la API) y GSON (para manejar la consulta en formato JSON).



Así es como se implementaría OKHTTP3 a la hora de hacer la Request. En primer lugar creamos un cliente, luego preparamos la “Request” y con el método Builder creamos el cuerpo de la petición. 
A la hora de hacer una petición a la API, se utiliza el método GET para obtener los datos.
En nuestro caso no haría falta ponerle ningún “Body”, ya que la propia API devuelve la consulta en forma de JSON.


Finalmente, metemos la solicitud en cola y a través de la interfaz del cliente OKHTTP recogemos la respuesta.



Como hemos mencionado anteriormente, la respuesta nos la da en JSON, por lo cual el String que nos da lo tenemos que meter en un JSON Array o un JSON Object en función de cómo devuelva la respuesta.

<h3>Métodos empleados</h3>
<b>public void getIDMunicipio(String municipio_nombre, final IDMunicipioCallback callback)</b>
Este método se encuentra en la clase ConsultarTiempo.java y se encarga de buscar el id del municipio correspondiente a lo que se ha escrito en el EditText. Lo que hace es leer un JSON subido en Firebase en el que están todos los municipios de España con sus respectivos IDs. Los parámetros que le entran son: el nombre del municipio que queremos buscar y una interfaz para buscar el municipio. La interfaz que implementamos nos resuelve un problema de sincronización entre el programa y el propio Firebase, actúa como una especie de ‘hilo’ sin serlo. Esta función será llamada dentro de hacerConsulta().
public static String getURL(JSONObject jsonobj)
Este método se encarga de extraer la URL de la primera request que se le hace a la API. Le entra por parámetro un JSONObject, y lo que hace es obtener de esa gama de datos, el que tiene la URL que nos servirá para hacer la segunda request. Retorna un String con la URL obtenida.
public void hacerConsulta(View view) throws IOException
En este método como tal no se hace la consulta directamente. Primero llama a la función getIDMunicipio al que le pasa por parámetro el EditText con la petición del usuario y la interfaz. Una vez ejecutada esta función para obtener el ID, comprueba si lo que retorna está vacío o nulo para dar un feedback al usuario de que no ha encontrado datos, si no llama a la función getEnlaceHttpok que es la que realizará la request.
public static void getEnlaceHttpok(String IDMunicipio)
Esta función de lo que se encarga es de hacer la primera request a la API para la obtención del enlace que nos servirá para la segunda request. Como parámetro le entra la ID del municipio, que es un parámetro que requiere el enlace de la API para poder hacer la request. En este método a su vez se le llama a las funciones getURL, para extraer de la gama de datos la URL, y getTiempo, la request final. Cabe destacar que esta función tiene dos métodos internos ya que se apoya en una interfaz que hemos implementado llamada OkHttpClient, uno por si hay alguna especie de error (onFailure) y el otro método es el que recibe la respuesta (onResponse), que es donde hemos ejecutado todo el código previamente dicho.
private static void getTiempo(String enlace)
Este es el método que hace la request final a la API. Como parámetro le entra el enlace final, obtenido de la función getURL. Tiene dos sub métodos implementados debido al uso de la interfaz OkHttpClient, uno para control de errores (onFailure) y el otro que recoge la respuesta de la API (onResponse), esta última abstrae los datos en un JSONArray que posteriormente es pasado al constructor de nuestra clase propia ModeloReporte, que se encarga de recoger los datos y separarlos en Strings independientes para su posterior impresión en el layout.

<h3>¿Qué es Firebase?</h3>

Firebase es una plataforma de Google en la nube que sirve para el desarrollo de  aplicaciones web y móvil.

Su función es hacer más sencilla el desarrollo de las aplicaciones, proporcionando módulos como base de datos, registro por email,  envío de mensajes por email, etc.
En el módulo de base de datos hemos subido nuestro JSON con todos los municipios de España, siendo el nombre del municipio la id y el código del municipio el valor.


Para subir nuestro JSON teníamos dos opciones, una de pago, que lo gestiona el propio Firebase y otra empleando NodeJS, finalmente nos decantamos por esta segunda opción.

<h3>¿Qué es NodeJS?</h3>

Es un entorno en tiempo de ejecución multiplataforma, de código abierto, para la capa del servidor, basado en JavaScript, con E/S de datos en una arquitectura orientada a eventos y basado en el motor V8 de Google.
¿Cómo se ha realizado la subida del JSON a Firebase?

Primero nos descargamos NodeJS en su página oficial https://nodejs.org/en/.
Después vamos a la consola de Firebase y nos metemos en nuestro proyecto, le damos a la rueda de ‘Descripción General’ y pulsamos la opción de Configuración del proyecto.
Nos aparecerá un menú como el de abajo, entonces le damos a ‘Cuentas de servicio’ 



Nos aparecerá una ventana como esta, pinchamos en Node.js y le damos a ‘Generar nueva clave privada’ y se nos descargará nuestra key para poder hacer la subida.

A continuación les mostraremos el script que hay que realizar para la subida:

Nota: Hay que tener en cuenta que tiene que estar todo en la misma carpeta, tanto como el .js, como el JSON y la key.


Lo que haría este script sería leer el json de municipios, filtrar valores y subirlo al firebase.

Para ejecutarlo abrimos una terminal, primero tenemos que instalar el firebase-admin, entonces ponemos: npm install –save firebase-admin . Posteriormente realizamos la subida del fichero .js, ponemos: node nombre_del_fichero.js, debemos asegurarnos de que estamos en la carpeta del fichero .js, si no, no funciona.


¿Qué utilizamos para que no se cierre sesión una vez cerrada la aplicación?

Hemos implementado la opción de que, si el usuario lo requiere, se puedan guardar sus datos en la aplicación para que no le solicite el inicio de sesión siempre que abre la aplicación.
Para ello hemos utilizado la interfaz SharedPreferences, la cual sirve para guardar las preferencias del usuario en un archivo.
En nuestro caso, solo hemos guardado si el usuario quiere que se le recuerde o no, ya que nos encargamos de rescatar los datos del usuario de Firebase.

A continuación, mostramos como lo hemos implementado:

Primero, verificamos si el usuario ha marcado si quiere mantener su cuenta iniciada.
Si es así, editamos la preferencia para que guarde el valor que queremos.



A la hora de iniciar la aplicación, uno de los primeros métodos que inicia esta actividad es verificar si en las preferencias el usuario ha marcado que quiere mantener su sesión iniciada.

En este caso, lee las preferencias y si en el apartado “name” contiene un “true”, inicia directamente el Main Activity.


A la hora de cerrar sesión, sobreescribimos las preferencias para que no se inicie el main Activity nada más abrir la app.
