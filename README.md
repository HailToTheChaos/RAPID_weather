<body class="c25 c35 doc-content">
    <p class="c17 c21"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 658.00px; height: 859.50px;"><img
                alt="" src="images/image2.png"
                style="width: 658.00px; height: 859.50px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <h1 class="c19 c9" id="h.6avoa2b8iahn"><span class="c16">Introducci&oacute;n de la aplicaci&oacute;n.</span></h1>
    <p class="c3"><span class="c1">Nuestra aplicaci&oacute;n se encarga de darnos datos relevantes del tiempo de los
            municipios de Espa&ntilde;a. </span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Recogemos los datos de la Agencia Estatal de Meteorolog&iacute;a a trav&eacute;s de
            su propia API.</span></p>
    <p class="c3"><span class="c1">El funcionamiento de cara al usuario es el siguiente: el usuario realiza una
            petici&oacute;n de tiempo poniendo el nombre de un municipio. A continuaci&oacute;n, pulsaremos el
            bot&oacute;n &lsquo;CONSULTAR&rsquo; para realizar la petici&oacute;n a la API y rescatar los datos
            necesarios.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">El proyecto comenz&oacute; siendo una inspiraci&oacute;n de la aplicaci&oacute;n del
            tiempo propia de la AEMET. </span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Respecto a otras aplicaciones del tiempo, nuestra aplicaci&oacute;n implementa la API
            de AEMET.</span></p>
    <p class="c3"><span class="c1">Eso nos da m&aacute;s precisi&oacute;n a la hora de consultar el tiempo a nivel del
            territorio espa&ntilde;ol, ya que la misma agencia tiene sus propias estaciones
            meteorol&oacute;gicas.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">El desarrollo de la aplicaci&oacute;n ha sido desde cero, ya que no hemos cogido
            c&oacute;digo existente.</span></p>
    <p class="c3"><span class="c1">Si es cierto que nos hemos documentado ampliamente en varias fuentes para llegar al
            resultado actual, ya sea para hacer request a la API, recoger los datos de ella o implementar
            Firebase.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span>A la hora de elegir la API, encontramos opciones como </span><span class="c24"><a class="c0"
                href="https://www.google.com/url?q=https://rapidapi.com/&amp;sa=D&amp;source=editors&amp;ust=1677965118887561&amp;usg=AOvVaw1Xz8hBx0xapkgQWNZM0ARx">Rapidapi.com</a></span><span>&nbsp;(distribuidora
            de APIs)</span><span>&nbsp; o </span><span class="c24"><a class="c0"
                href="https://www.google.com/url?q=https://www.el-tiempo.net/api&amp;sa=D&amp;source=editors&amp;ust=1677965118887925&amp;usg=AOvVaw07MWso_bt71cnbriFgUwqr">elTiempo.net</a></span><span
            class="c1">, pero nos decidimos al final por la API de AEMET. </span></p>
    <p class="c3"><span>Al ser la propia API de una instituci&oacute;n p&uacute;blica nos transmit&iacute;a m&aacute;s
            confianza a la hora de obtener los datos, ya que son de sus propias estaciones meteorol&oacute;gicas.</span>
    </p>
    <p class="c5"><span class="c1"></span></p>
    <p class="c5"><span class="c1"></span></p>
    <h1 class="c19 c9" id="h.krlsuk4tzblr"><span class="c16">Flujo de ejecuci&oacute;n de la aplicaci&oacute;n</span>
    </h1>
    <h2 class="c20 c9" id="h.qax35hobgsal"><span class="c13">Login</span></h2>
    <p class="c3"><span class="c1">Nuestra aplicaci&oacute;n comienza con un login en el que el usuario debe ingresar su
            email y contrase&ntilde;a. Una vez ingresados dichos campos se le debe dar al bot&oacute;n
            &lsquo;ACCEDER&rsquo; para tener acceso completo a la aplicaci&oacute;n. Tenemos un bot&oacute;n especial
            que sirve para que tu sesi&oacute;n no se cierre una vez cerrada la aplicaci&oacute;n que es el bot&oacute;n
            de &lsquo;Recuerdame&rsquo;. Tambi&eacute;n tenemos dos apartados m&aacute;s. Uno para crearse una cuenta
            con la que poder acceder y otro para poder recuperar la contrase&ntilde;a.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c2"><span class="c1"></span></p>
    <h2 class="c3 c9" id="h.asnufjgnpxdr"><span class="c13">Registro</span></h2>
    <p class="c17"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 497.00px; height: 330.00px;"><img
                alt="" src="images/image28.png"
                style="width: 497.00px; height: 330.00px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Pasemos al crear cuenta. Consta de varios campos necesarios para poder loguearse:
            Nombre, Email, Contrase&ntilde;a y la confirmaci&oacute;n de la contrase&ntilde;a. Tiene dos botones para
            Volver al Login y otro para confirmar el registro, realiza varias validaciones en los campos para que no
            haya errores.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Al crear una cuenta, la aplicaci&oacute;n manda un correo al usuario que se ha
            registrado. Esto sirve para controlar el acceso para las cuentas verificadas.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <h2 class="c3 c9 c28" id="h.w5in0twoosx"><span class="c13"></span></h2>
    <h2 class="c3 c9" id="h.p8tjdwfcqff"><span class="c13">Recuperar contrase&ntilde;a</span></h2>
    <p class="c5"><span class="c1"></span></p>
    <p class="c3"><span class="c1">A continuaci&oacute;n, pasaremos a la recuperaci&oacute;n de la
            contrase&ntilde;a.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Esta actividad funciona de la siguiente manera: el usuario rellena el apartado de
            email y le da al bot&oacute;n de &lsquo;Recuperar&rsquo;, se le enviar&aacute; a su gmail un mensaje de
            reseteo de contrase&ntilde;a, a continuaci&oacute;n el usuario se debe de dirigir al correo y abrir el
            enlace. Se le aparecer&aacute; una ventana para cambiar la contrase&ntilde;a, ah&iacute; deber&aacute;
            insertar la nueva contrase&ntilde;a.</span></p>
    <p class="c17"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 518.65px; height: 337.43px;"><img
                alt="" src="images/image33.png"
                style="width: 518.65px; height: 337.43px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c5"><span class="c1"></span></p>
    <h2 class="c20 c9" id="h.yq84u3m144jo"><span class="c13">Main activity, consulta de datos y cerrado de
            sesi&oacute;n</span></h2>
    <p class="c5"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Una vez el usuario se ha logueado, le aparecer&aacute; una nueva actividad que le
            dejar&aacute; hacer dos opciones, una Cerrar sesi&oacute;n y otra cambiar a la actividad de consultar
            tiempo.</span></p>
    <p class="c5"><span class="c1"></span></p>
    <p class="c17"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 462.15px; height: 252.58px;"><img
                alt="" src="images/image24.png"
                style="width: 462.15px; height: 252.58px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c17 c27"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Finalmente llegamos a la actividad para consultar el tiempo. En esta actividad hay un
            EditText en el que debemos de escribir el nombre del municipio. A continuaci&oacute;n pulsamos el
            bot&oacute;n de &lsquo;CONSULTAR&rsquo; y nos mostrar&iacute;a algo similar al ejemplo de abajo.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <h2 class="c20 c9" id="h.73zkn1b12qd1"><span class="c13">Men&uacute; de navegaci&oacute;n y
            Configuraci&oacute;n</span></h2>
    <p class="c5"><span class="c1"></span></p>
    <p class="c20"><span class="c1">Aqu&iacute; mostramos como se puede navegar entre pantallas una vez se inicia
            sesi&oacute;n.</span></p>
    <p class="c17"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 362.15px; height: 276.88px;"><img
                alt="" src="images/image26.png"
                style="width: 362.15px; height: 276.88px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c5"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Dentro del apartado de configuraci&oacute;n, hemos a&ntilde;adido la opci&oacute;n de
            cambiar la contrase&ntilde;a de la cuenta, de eliminar la cuenta y de cambiar el idioma de la
            aplicaci&oacute;n.</span></p>
    <p class="c17"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 444.15px; height: 382.86px;"><img
                alt="" src="images/image18.png"
                style="width: 444.15px; height: 382.86px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <hr style="page-break-before:always;display:none;">
    <h1 class="c19 c9" id="h.ewztw7u1a7at"><span class="c16">Elementos introducidos en la aplicaci&oacute;n</span></h1>
    <h2 class="c20 c9 c28" id="h.urgtjpxc8dbz"><span class="c13"></span></h2>
    <h2 class="c20 c9" id="h.aqsgnbmm8255"><span class="c13">&iquest;Qu&eacute; es una API?</span></h2>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Una API (del ingl&eacute;s: Application Programming Interface), es el conjunto de
            subrutinas, funciones y procedimientos que ofrece cierto ente (en este caso, AEMET) para ser utilizado por
            un software de un tercero para la obtenci&oacute;n de datos, informaci&oacute;n, documentos, etc.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">En este caso, hemos implementado en Java el protocolo API REST, el cual es una un API
            apoyada totalmente en el est&aacute;ndar HTTP. Visto de una forma m&aacute;s sencilla, una API REST es un
            servicio que nos provee de funciones que nos dan la capacidad de hacer uso de un servicio web que no es
            nuestro, dentro de una aplicaci&oacute;n propia, de manera segura.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <h2 class="c20 c9" id="h.w42e6auatmk"><span class="c13">Tipos de acceso</span></h2>
    <p class="c5"><span class="c1"></span></p>
    <p class="c3"><span>En la </span><span class="c32"><a class="c0"
                href="https://www.google.com/url?q=https://opendata.aemet.es/centrodedescargas/inicio&amp;sa=D&amp;source=editors&amp;ust=1677965118892906&amp;usg=AOvVaw3alEfd9cTK6KmZJpJxyUQS">AEMET
                OpenData</a></span><span class="c1">&nbsp;hay dos tipos de acceso a usuarios: el acceso general y el
            acceso para desarrolladores.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">El acceso para el p&uacute;blico en general tiene como finalidad el permitir el
            acceso a los datos para usuarios de una manera amigable. Por otro lado, el acceso para desarrolladores se
            caracteriza por la posibilidad de ser peri&oacute;dica e incluso programada, realizada a trav&eacute;s de un
            API destinada a un sistema inform&aacute;tico, que permite a los usuarios el incluir los datos de AEMET en
            sus propios sistemas de informaci&oacute;n.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c17"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 324.50px; height: 187.74px;"><img
                alt="" src="images/image7.png"
                style="width: 324.50px; height: 187.74px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c5"><span class="c1"></span></p>
    <hr style="page-break-before:always;display:none;">
    <h2 class="c20 c9 c28" id="h.2bue5yhc1z6p"><span class="c13"></span></h2>
    <h2 class="c20 c9" id="h.f9839xvi3hhp"><span>Obtenci&oacute;n </span><span>de la API: AEMET OpenData.</span></h2>
    <p class="c3"><span>Para la obtenci&oacute;n de la API nos hemos metido en la p&aacute;gina de </span><span
            class="c32"><a class="c0"
                href="https://www.google.com/url?q=https://opendata.aemet.es/centrodedescargas/inicio&amp;sa=D&amp;source=editors&amp;ust=1677965118893928&amp;usg=AOvVaw1FcAgWeDItCu6YSNk1GZfp">AEMET
                OpenData</a></span><span class="c25">. Dicha API permite la difusi&oacute;n y la reutilizaci&oacute;n de
            la informaci&oacute;n meteorol&oacute;gica y climatol&oacute;gica de la Agencia Estatal de
            Meteorolog&iacute;a (AEMET).</span></p>
    <p class="c20"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 601.70px; height: 322.67px;"><img
                alt="" src="images/image19.png"
                style="width: 601.70px; height: 322.67px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c5"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Primero, hemos solicitado nuestra API Key, la cual es completamente gratuita.</span>
    </p>
    <p class="c3"><span>Las API Keys son identificadores &uacute;nicos otorgados a cada solicitante,</span><span
            class="c25 c31">&nbsp;</span><span class="c25">mediante los cuales se contabilizan e imputan los accesos que
            un usuario realiza al API</span><span class="c1">.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">La API Key se puede solicitar desde la opci&oacute;n &quot;Obtenci&oacute;n de API
            Key&quot; de la p&aacute;gina principal de AEMET OpenData introduciendo su direcci&oacute;n de correo
            electr&oacute;nico.</span></p>
    <p class="c3"><span class="c1">Una vez introducido el email, nos llega un correo con el enlace de activaci&oacute;n
            y posteriormente, te env&iacute;an otro con la API Key.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c20"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 601.70px; height: 214.67px;"><img
                alt="" src="images/image16.png"
                style="width: 601.70px; height: 214.67px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c5"><span class="c1"></span></p>
    <p class="c5"><span class="c1"></span></p>
    <p class="c5"><span class="c1"></span></p>
    <h2 class="c20 c9 c28" id="h.5bcvwv7wwhag"><span class="c13"></span></h2>
    <h2 class="c20 c9" id="h.vdlguz2pgu0g"><span class="c13">Acceso para desarrolladores</span></h2>
    <p class="c5"><span class="c1"></span></p>
    <p class="c3"><span class="c1">En nuestro caso, nosotros hemos utilizado el acceso a desarrolladores, el cual ofrece
            tres apartados para la implementaci&oacute;n de la API.</span></p>
    <p class="c5"><span class="c1"></span></p>
    <p class="c20"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 583.50px; height: 309.14px;"><img
                alt="" src="images/image35.png"
                style="width: 583.50px; height: 309.14px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c5"><span class="c1"></span></p>
    <p class="c3"><span class="c37">En el primer caso tenemos la parte de documentaci&oacute;n, la cual nos da acceso a
            la documentaci&oacute;n din&aacute;mica de AEMET OpenData y a la herramienta de HATEOAS, que permite conocer
            los recursos del API y sus detalles. </span><span class="c4"><a class="c0"
                href="https://www.google.com/url?q=https://opendata.aemet.es/dist/index.html?%23/&amp;sa=D&amp;source=editors&amp;ust=1677965118896170&amp;usg=AOvVaw1qksl5c-G7-MJXCUESqdHS">Swagger
                UI (aemet.es)</a></span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Para la obtenci&oacute;n del enlace de petici&oacute;n, nos hemos centrado en el
            apartado de predicciones espec&iacute;ficas.</span></p>
    <p class="c3"><span class="c1">Para nuestra aplicaci&oacute;n, hemos utilizado el enlace de la predicci&oacute;n del
            municipio diaria.</span></p>
    <p class="c3"><span class="c1">Previo a ello, se debe conocer el c&oacute;digo INE (Instituto Nacional de
            Estad&iacute;stica) para poder hacer la consulta.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c20"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 601.70px; height: 186.67px;"><img
                alt="" src="images/image36.png"
                style="width: 601.70px; height: 186.67px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c5"><span class="c1"></span></p>
    <p class="c5"><span class="c1"></span></p>
    <p class="c3"><span class="c1">En la propia p&aacute;gina se puede hacer una prueba de la consulta.</span></p>
    <p class="c5"><span class="c1"></span></p>
    <p class="c20"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 602.00px; height: 211.20px;"><img
                alt="" src="images/image13.png"
                style="width: 602.00px; height: 380.00px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c5"><span class="c1"></span></p>
    <p class="c3"><span class="c1">En segundo lugar, tenemos los ejemplos de como hacer la consulta a la API en
            distintos lenguajes de programaci&oacute;n. En nuestro caso, elegimos Java.</span></p>
    <p class="c5"><span class="c1"></span></p>
    <p class="c20"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 601.70px; height: 388.00px;"><img
                alt="" src="images/image15.png"
                style="width: 601.70px; height: 388.00px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Dentro del ejemplo del cliente de Java, tenemos la opci&oacute;n de hacer la consulta
            con la librer&iacute;a de OKHTTP o por la de UNIREST. Nosotros hemos elegido la primera
            opci&oacute;n.</span></p>
    <p class="c3"><span class="c1">Cabe destacar que las consultas de las API Rest devuelven la informaci&oacute;n en
            forma de JSON.</span></p>
    <p class="c20"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 601.70px; height: 282.67px;"><img
                alt="" src="images/image22.png"
                style="width: 601.70px; height: 282.67px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <h2 class="c3 c9" id="h.kk1xikj65yqw"><span class="c13">&iquest;Qu&eacute; es OKHTTP3?</span></h2>
    <p class="c3"><span class="c1">OKHTTP3 es una librer&iacute;a de c&oacute;digo abierto la cual permite realizar
            operaciones tanto en HTTP como en SPDY de manera sencilla y eficiente en ambientes Java (versi&oacute;n 1.7
            como m&iacute;nimo) y Android (2.3 como m&iacute;nimo), sin necesidad de cambiar el c&oacute;digo de la
            aplicaci&oacute;n entre ambas plataformas, con una interfaz fluida.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <h2 class="c3 c9" id="h.cvnz524q6su4"><span class="c13">&iquest;Qu&eacute; es JSON?</span></h2>
    <p class="c3"><span class="c1">JSON es un lenguaje de marcas sencillo para el intercambio de datos. Se trata de un
            subconjunto de la notaci&oacute;n literal de objetos de JavaScript, aunque, debido a su amplia
            adopci&oacute;n como alternativa a XML, se considera un formato independiente del lenguaje.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <h2 class="c3 c9" id="h.zafspjmo3goe"><span class="c13">Herramientas utilizadas para JSON</span></h2>
    <p class="c3"><span class="c1">Hemos utilizado el editor de c&oacute;digo VSCode para leer el JSON; una
            extensi&oacute;n para ayudarnos a visualizar el c&oacute;digo mejor llamado Sort JSON Objects y Postman, una
            plataforma para realizar pruebas con API Rest.</span></p>
    <p class="c5"><span class="c1"></span></p>
    <p class="c17"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 323.00px; height: 74.00px;"><img
                alt="" src="images/image6.png"
                style="width: 323.00px; height: 74.00px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c5"><span class="c1"></span></p>
    <p class="c17"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 601.70px; height: 166.67px;"><img
                alt="" src="images/image32.png"
                style="width: 601.70px; height: 166.67px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c20"><span class="c1">&nbsp;</span></p>
    <p class="c5"><span class="c1"></span></p>
    <h2 class="c3 c9" id="h.34s8rezcowff"><span class="c13">Implementaci&oacute;n de la API</span></h2>
    <p class="c3"><span class="c1">Una vez obtenida toda la informaci&oacute;n de la API, procedemos a implementar la
            API en Android Studio.</span></p>
    <p class="c3"><span class="c1">En primer lugar, hemos utilizado las siguientes dependencias: OKHTTP3 (para la
            consulta de la API) y GSON (para manejar la consulta en formato JSON).</span></p>
    <p class="c5"><span class="c1"></span></p>
    <h2 class="c17 c9" id="h.kos0609a8gji"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 567.00px; height: 87.00px;"><img
                alt="" src="images/image39.png"
                style="width: 567.00px; height: 87.00px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></h2>
    <p class="c5"><span class="c1"></span></p>
    <p class="c3"><span class="c1">As&iacute; es como se implementar&iacute;a OKHTTP3 a la hora de hacer la Request. En
            primer lugar creamos un cliente, luego preparamos la &ldquo;Request&rdquo; y con el m&eacute;todo Builder
            creamos el cuerpo de la petici&oacute;n. </span></p>
    <p class="c3"><span class="c1">A la hora de hacer una petici&oacute;n a la API, se utiliza el m&eacute;todo GET para
            obtener los datos.</span></p>
    <p class="c3"><span class="c1">En nuestro caso no har&iacute;a falta ponerle ning&uacute;n &ldquo;Body&rdquo;, ya
            que la propia API devuelve la consulta en forma de JSON.</span></p>
    <p class="c5"><span class="c1"></span></p>
    <p class="c20"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 601.70px; height: 138.67px;"><img
                alt="" src="images/image9.png"
                style="width: 601.70px; height: 138.67px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c3"><span class="c1">Finalmente, metemos la solicitud en cola y a trav&eacute;s de la interfaz del cliente
            OKHTTP recogemos la respuesta.</span></p>
    <p class="c17"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 471.33px; height: 365.50px;"><img
                alt="" src="images/image8.png"
                style="width: 471.33px; height: 365.50px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c3"><span class="c1">Como hemos mencionado anteriormente, la respuesta nos la da en JSON, por lo cual el
            String que nos da lo tenemos que meter en un JSON Array o un JSON Object en funci&oacute;n de c&oacute;mo
            devuelva la respuesta.</span></p>
    <p class="c5"><span class="c14 c22"></span></p>
    <h2 class="c3 c9" id="h.4pbpnk36tr8d"><span class="c13">M&eacute;todos empleados</span></h2>
    <p class="c3"><span class="c22">public void </span><span class="c7">getIDMunicipio</span><span class="c11">(String
            municipio_nombre</span><span class="c22">, final </span><span class="c11">IDMunicipioCallback
            callback)</span></p>
    <p class="c3"><span class="c1">Este m&eacute;todo se encuentra en la clase ConsultarTiempo.java y se encarga de
            buscar el id del municipio correspondiente a lo que se ha escrito en el EditText. Lo que hace es leer un
            JSON subido en Firebase en el que est&aacute;n todos los municipios de Espa&ntilde;a con sus respectivos
            IDs. Los par&aacute;metros que le entran son: el nombre del municipio que queremos buscar y una interfaz
            para buscar el municipio. La interfaz que implementamos nos resuelve un problema de sincronizaci&oacute;n
            entre el programa y el propio Firebase, act&uacute;a como una especie de &lsquo;hilo&rsquo; sin serlo. Esta
            funci&oacute;n ser&aacute; llamada dentro de hacerConsulta().</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c22">public static </span><span class="c11">String </span><span
            class="c7">getURL</span><span class="c14 c11">(JSONObject jsonobj)</span></p>
    <p class="c3"><span class="c1 c25">Este m&eacute;todo se encarga de extraer la URL de la primera request que se le
            hace a la API. Le entra por par&aacute;metro un JSONObject, y lo que hace es obtener de esa gama de datos,
            el que tiene la URL que nos servir&aacute; para hacer la segunda request. Retorna un String con la URL
            obtenida.</span></p>
    <p class="c2"><span class="c1 c25"></span></p>
    <p class="c3"><span class="c22">public void </span><span class="c7">hacerConsulta</span><span class="c11">(View
            view) </span><span class="c22">throws </span><span class="c14 c11">IOException</span></p>
    <p class="c3"><span class="c1 c25">En este m&eacute;todo como tal no se hace la consulta directamente. Primero llama
            a la funci&oacute;n getIDMunicipio al que le pasa por par&aacute;metro el EditText con la petici&oacute;n
            del usuario y la interfaz. Una vez ejecutada esta funci&oacute;n para obtener el ID, comprueba si lo que
            retorna est&aacute; vac&iacute;o o nulo para dar un feedback al usuario de que no ha encontrado datos, si no
            llama a la funci&oacute;n getEnlaceHttpok que es la que realizar&aacute; la request.</span></p>
    <p class="c2"><span class="c1 c25"></span></p>
    <p class="c3"><span class="c22">public static void </span><span class="c7">getEnlaceHttpok</span><span
            class="c11 c14">(String IDMunicipio)</span></p>
    <p class="c3"><span class="c1 c25">Esta funci&oacute;n de lo que se encarga es de hacer la primera request a la API
            para la obtenci&oacute;n del enlace que nos servir&aacute; para la segunda request. Como par&aacute;metro le
            entra la ID del municipio, que es un par&aacute;metro que requiere el enlace de la API para poder hacer la
            request. En este m&eacute;todo a su vez se le llama a las funciones getURL, para extraer de la gama de datos
            la URL, y getTiempo, la request final. Cabe destacar que esta funci&oacute;n tiene dos m&eacute;todos
            internos ya que se apoya en una interfaz que hemos implementado llamada OkHttpClient, uno por si hay alguna
            especie de error (onFailure) y el otro m&eacute;todo es el que recibe la respuesta (onResponse), que es
            donde hemos ejecutado todo el c&oacute;digo previamente dicho.</span></p>
    <p class="c2"><span class="c1 c25"></span></p>
    <p class="c3"><span class="c22">private static void </span><span class="c7">getTiempo</span><span
            class="c14 c11">(String enlace)</span></p>
    <p class="c3"><span class="c25">Este es el m&eacute;todo que hace la request final a la API. Como par&aacute;metro
            le entra el enlace final, obtenido de la funci&oacute;n getURL. Tiene dos sub m&eacute;todos implementados
            debido al uso de la interfaz OkHttpClient, uno para control de errores (onFailure) y el otro que recoge la
            respuesta de la API (onResponse), esta &uacute;ltima abstrae los datos en un JSONArray que posteriormente es
            pasado al constructor de nuestra clase propia ModeloReporte, que se encarga de recoger los datos y
            separarlos en Strings independientes para su posterior impresi&oacute;n en el layout.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <h2 class="c3 c9" id="h.lhlqki3tpo2j"><span class="c13">&iquest;Qu&eacute; es NodeJS?</span></h2>
    <p class="c2"><span class="c14 c18"></span></p>
    <p class="c3"><span class="c1">Es un entorno en tiempo de ejecuci&oacute;n multiplataforma, de c&oacute;digo
            abierto, para la capa del servidor, basado en JavaScript, con E/S de datos en una arquitectura orientada a
            eventos y basado en el motor V8 de Google.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <h2 class="c3 c9" id="h.a8ppru6g3rn0"><span class="c13">&iquest;C&oacute;mo se ha realizado la subida del JSON a
            Firebase?</span></h2>
    <p class="c2"><span class="c14 c18"></span></p>
    <p class="c3"><span>Primero nos descargamos NodeJS en su p&aacute;gina oficial </span><span class="c24"><a
                class="c0"
                href="https://www.google.com/url?q=https://nodejs.org/en/&amp;sa=D&amp;source=editors&amp;ust=1677965118902592&amp;usg=AOvVaw3w3FwVVPD1X2uzXTzMzaH-">https://nodejs.org/en/</a></span><span
            class="c14 c18">.</span></p>
    <p class="c3"><span class="c1">Despu&eacute;s vamos a la consola de Firebase y nos metemos en nuestro proyecto, le
            damos a la rueda de &lsquo;Descripci&oacute;n General&rsquo; y pulsamos la opci&oacute;n de
            Configuraci&oacute;n del proyecto.</span></p>
    <p class="c3"><span class="c1">Nos aparecer&aacute; un men&uacute; como el de abajo, entonces le damos a
            &lsquo;Cuentas de servicio&rsquo; </span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 602.00px; height: 116.11px;"><img
                alt="" src="images/image30.png"
                style="width: 602.00px; height: 116.11px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Nos aparecer&aacute; una ventana como esta, pinchamos en Node.js y le damos a
            &lsquo;Generar nueva clave privada&rsquo; y se nos descargar&aacute; nuestra key para poder hacer la
            subida.</span></p>
    <p class="c17"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 355.50px; height: 219.09px;"><img
                alt="" src="images/image11.png"
                style="width: 355.50px; height: 219.09px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c3"><span class="c1">A continuaci&oacute;n les mostraremos el script que hay que realizar para la
            subida:</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Nota: Hay que tener en cuenta que tiene que estar todo en la misma carpeta, tanto
            como el .js, como el JSON y la key.</span></p>
    <p class="c17"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 549.00px; height: 316.10px;"><img
                alt="" src="images/image21.png"
                style="width: 549.00px; height: 316.10px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Lo que har&iacute;a este script ser&iacute;a leer el json de municipios, filtrar
            valores y subirlo al firebase.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span>Para ejecutarlo abrimos una terminal, primero tenemos que instalar el firebase-admin, entonces
            ponemos: </span><span class="c29">npm install &ndash;save firebase-admin</span><span>&nbsp;. Posteriormente
            realizamos la subida del fichero .js, ponemos: </span><span class="c29">node nombre_del_fichero.js,
        </span><span class="c1">debemos asegurarnos de que estamos en la carpeta del fichero .js, si no, no
            funciona.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <h2 class="c3 c9" id="h.u19bjnrj7lmh"><span class="c13">Correos de verificaci&oacute;n y restablecimiento de la
            contrase&ntilde;a a trav&eacute;s de Firebase</span></h2>
    <p class="c5"><span class="c1"></span></p>
    <p class="c3"><span class="c1">A trav&eacute;s del m&oacute;dulo de Autentificaci&oacute;n, Firebase te da una
            herramienta de enviar un correo de verificaci&oacute;n al usuario con una plantilla predefinida y
            personalizable.</span></p>
    <p class="c3"><span class="c1">Dicha herramienta se implementa a trav&eacute;s del c&oacute;digo.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">El primer paso, es enviarle el correo de verificaci&oacute;n una vez hecho el
            registro.</span></p>
    <p class="c3"><span class="c1">Una vez verificado podr&aacute; acceder al main activity tras iniciar
            sesi&oacute;n.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c17"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 510.00px; height: 170.00px;"><img
                alt="" src="images/image17.png"
                style="width: 510.00px; height: 170.00px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c20"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 601.70px; height: 297.33px;"><img
                alt="" src="images/image14.png"
                style="width: 601.70px; height: 297.33px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Aqu&iacute; verificamos si el usuario ha sido verificado:</span></p>
    <p class="c17"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 491.73px; height: 82.19px;"><img
                alt="" src="images/image38.png"
                style="width: 838.59px; height: 238.33px; margin-left: 0.00px; margin-top: -156.14px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c3"><span class="c1">A continuaci&oacute;n pasaremos a c&oacute;mo se restablece la contrase&ntilde;a en
            nuestra aplicaci&oacute;n:</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Al igual que la verificaci&oacute;n lo gestiona Firebase, la recuperaci&oacute;n de
            la contrase&ntilde;a tambi&eacute;n lo lleva a cabo este servicio. Se implementa de tal manera:</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 601.70px; height: 197.33px;"><img
                alt="" src="images/image3.png"
                style="width: 601.70px; height: 197.33px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Una vez pulsado el bot&oacute;n de &lsquo;Recuperar&rsquo; de nuestra actividad,
            llamamos a la funci&oacute;n getEnviarCorreo, que env&iacute;a un correo al usuario espec&iacute;fico
            &nbsp;permiti&eacute;ndole cambiar la contrase&ntilde;a. Para que esto suceda, se utiliza el m&eacute;todo
            del m&oacute;dulo Authentication, sendPasswordResetEmail para solicitar el cambio de
            contrase&ntilde;a</span></p>
    <p class="c3"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 524.00px; height: 571.00px;"><img
                alt="" src="images/image12.png"
                style="width: 524.00px; height: 571.00px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c3"><span class="c1">.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <h2 class="c3 c9" id="h.qoezg0d3tw1m"><span class="c13">&iquest;Qu&eacute; utilizamos para que no se cierre
            sesi&oacute;n una vez cerrada la aplicaci&oacute;n?</span></h2>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Hemos implementado la opci&oacute;n de que, si el usuario lo requiere, se puedan
            guardar sus datos en la aplicaci&oacute;n para que no le solicite el inicio de sesi&oacute;n siempre que
            abre la aplicaci&oacute;n.</span></p>
    <p class="c3"><span class="c1">Para ello hemos utilizado la interfaz SharedPreferences, la cual sirve para guardar
            las preferencias del usuario en un archivo.</span></p>
    <p class="c3"><span class="c1">En nuestro caso, solo hemos guardado si el usuario quiere que se le recuerde o no, ya
            que nos encargamos de rescatar los datos del usuario de Firebase.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">A continuaci&oacute;n, mostramos como lo hemos implementado:</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Primero, verificamos si el usuario ha marcado si quiere mantener su cuenta
            iniciada.</span></p>
    <p class="c3"><span class="c1">Si es as&iacute;, editamos la preferencia para que guarde el valor que
            queremos.</span></p>
    <p class="c17"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 601.70px; height: 108.00px;"><img
                alt="" src="images/image4.png"
                style="width: 601.70px; height: 108.00px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">A la hora de iniciar la aplicaci&oacute;n, uno de los primeros m&eacute;todos que
            inicia esta actividad es verificar si en las preferencias el usuario ha marcado que quiere mantener su
            sesi&oacute;n iniciada.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span>En este caso, lee las preferencias y si en el apartado &ldquo;name&rdquo; contiene un
            &ldquo;true&rdquo;, inicia directamente el Main Activity.</span></p>
    <p class="c17"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 601.70px; height: 188.00px;"><img
                alt="" src="images/image37.png"
                style="width: 601.70px; height: 188.00px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">A la hora de cerrar sesi&oacute;n, sobreescribimos las preferencias para que no se
            inicie el main Activity nada m&aacute;s abrir la app.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c17"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 601.70px; height: 212.00px;"><img
                alt="" src="images/image23.png"
                style="width: 601.70px; height: 212.00px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c5"><span class="c1"></span></p>
    <h1 class="c19 c9 c34" id="h.pgfmbnpsyip9"><span class="c13"></span></h1>
    <h2 class="c20 c9" id="h.dgjyc0j0d29c"><span class="c13">Eliminar cuenta en Firebase</span></h2>
    <p class="c20"><span class="c1">Para eliminar una cuenta en Firebase utilizamos el siguiente c&oacute;digo: </span>
    </p>
    <p class="c20"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 601.70px; height: 190.67px;"><img
                alt="" src="images/image27.png"
                style="width: 601.70px; height: 190.67px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span><span class="c1">Obtenemos el usuario y utilizamos la funci&oacute;n delete() para
            eliminar al usuario.</span></p>
    <p class="c5"><span class="c1"></span></p>
    <h2 class="c9 c20" id="h.s5z14o10uwsz"><span class="c13">Cambiar la contrase&ntilde;a</span></h2>
    <p class="c20"><span>Para cambiar la contrase&ntilde;a del usuario acudimos a la funci&oacute;n
            updatePassword().</span></p>
    <p class="c20"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 601.70px; height: 216.00px;"><img
                alt="" src="images/image1.png"
                style="width: 601.70px; height: 216.00px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <hr style="page-break-before:always;display:none;">
    <h1 class="c19 c9 c34" id="h.xj1gnsehap4x"><span class="c16"></span></h1>
    <h1 class="c9 c19" id="h.g8kjqkath52b"><span>Especificaciones</span></h1>
    <p class="c5"><span class="c1"></span></p>
    <h2 class="c3 c9" id="h.6xpqfy8isiow"><span class="c13">Firebase</span></h2>
    <p class="c3"><span class="c1">Firebase es una plataforma de Google en la nube que sirve para el desarrollo de
            &nbsp;aplicaciones web y m&oacute;viles.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Su funci&oacute;n es hacer m&aacute;s sencilla el desarrollo de las aplicaciones,
            proporcionando m&oacute;dulos como base de datos, registro por email, &nbsp;env&iacute;o de mensajes por
            email, etc.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <h2 class="c3 c9" id="h.kvho8dwx4yf0"><span class="c13">Implementaci&oacute;n Firebase</span></h2>
    <p class="c20"><span class="c1">A continuaci&oacute;n, mostramos las capturas de los pasos que hemos seguido a la
            hora de crear un proyecto y la configuraci&oacute;n de los m&oacute;dulos.</span></p>
    <p class="c5"><span class="c1"></span></p>
    <p class="c17"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 232.47px; height: 158.14px;"><img
                alt="" src="images/image10.png"
                style="width: 232.47px; height: 158.14px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 195.50px; height: 155.30px;"><img
                alt="" src="images/image34.png"
                style="width: 195.50px; height: 155.30px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c5"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Aqu&iacute; mostramos los pasos para implementarlo en Android Studio:</span></p>
    <p class="c5"><span class="c1"></span></p>
    <p class="c20"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 601.70px; height: 407.84px;"><img
                alt="" src="images/image5.png"
                style="width: 601.70px; height: 407.84px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <h2 class="c20 c9" id="h.mus46d28x3i"><span class="c13">Authentication</span></h2>
    <p class="c3"><span class="c1">Aqu&iacute; mostramos los pasos que hemos seguido para configurar el m&oacute;dulo de
            Authentication.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c17"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 601.70px; height: 417.33px;"><img
                alt="" src="images/image25.png"
                style="width: 601.70px; height: 417.33px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c2"><span class="c1"></span></p>
    <h2 class="c3 c9" id="h.f1z5azbzpj9q"><span class="c13">Cloud Firestore </span></h2>
    <p class="c5"><span class="c1"></span></p>
    <p class="c17"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 212.50px; height: 174.68px;"><img
                alt="" src="images/image29.png"
                style="width: 212.50px; height: 174.68px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c17 c27"><span class="c1"></span></p>
    <p class="c3"><span class="c1">En el m&oacute;dulo de Cloud Firestore hemos subido nuestro JSON con todos los
            municipios de Espa&ntilde;a, siendo el nombre del municipio la id y el c&oacute;digo del municipio el
            valor.</span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Por otro lado, cada vez que un usuario se registra, queda guardado su correo
            el&eacute;ctronico y su nombre.</span></p>
    <p class="c17 c27"><span class="c1"></span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c2"><span class="c1"></span></p>
    <h2 class="c3 c9" id="h.aeuq2yd1v260"><span>Subida del JSON a Firestore Database y configuraci&oacute;n de las
            reglas</span></h2>
    <p class="c3"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 601.70px; height: 136.00px;"><img
                alt="" src="images/image20.png"
                style="width: 601.70px; height: 136.00px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c1">Para subir nuestro JSON ten&iacute;amos dos opciones, una de pago, que lo gestiona el
            propio Firebase y otra empleando NodeJS, finalmente nos decantamos por esta segunda opci&oacute;n.</span>
    </p>
    <p class="c2"><span class="c1"></span></p>
    <p class="c3"><span class="c36">Una vez </span><span>introducidos los municipios en Firestore Database</span><span
            class="c1">, nos dirigimos al apartado regla, y tendremos que implementar lo siguiente:</span></p>
    <p class="c2"><span class="c1"></span></p>
    <h2 class="c20" id="h.nngzdf8s3dov"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 601.70px; height: 253.33px;"><img
                alt="" src="images/image40.png"
                style="width: 601.70px; height: 253.33px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span><span class="c1">&nbsp;</span></h2>
    <p class="c20"><span class="c1">Esto nos sirve para controlar qui&eacute;n puede leer y escribir en la base de
            datos.</span></p>
    <p class="c5"><span class="c1"></span></p>
    <h2 class="c20 c9" id="h.xio6ks9tgvjy"><span>Versionado de Android Studio</span></h2>
    <p class="c20"><span class="c1">Nosotros utilizamos las siguientes versiones :</span></p>
    <ul class="c30 lst-kix_mwmfsvrdjsdo-0 start">
        <li class="c10 li-bullet-0"><span class="c1">build.gradle del proyecto</span></li>
    </ul>
    <p class="c12"><span class="c11">classpath </span><span
            class="c8">&#39;com.google.gms:google-services:4.3.15&#39;</span></p>
    <p class="c12"><span class="c11">id </span><span class="c8">&#39;com.android.application&#39; </span><span
            class="c11">version </span><span class="c8">&#39;7.4.0&#39; </span><span class="c11">apply </span><span
            class="c14 c22">false</span></p>
    <p class="c12"><span class="c11">id </span><span class="c8">&#39;com.android.library&#39; </span><span
            class="c11">version </span><span class="c8">&#39;7.4.0&#39; </span><span class="c11">apply </span><span
            class="c22">false</span></p>
    <ul class="c30 lst-kix_cnm9iiv8nwu5-0 start">
        <li class="c10 li-bullet-0"><span class="c1">build.gradle (Module):</span></li>
    </ul>
    <p class="c12"><span
            style="overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 483.50px; height: 356.60px;"><img
                alt="" src="images/image31.png"
                style="width: 483.50px; height: 356.60px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);"
                title=""></span></p>
    <h1 class="c19 c9" id="h.bsdvrzuznwek"><span>Consideraciones</span></h1>
    <ul class="c30 lst-kix_e35jnv1nerqv-0 start">
        <li class="c10 li-bullet-0"><span>Si le da error de versionado, coja la versi&oacute;n que tiene (generalmente
                sale en el error) y cambiela en el apartado que hemos mostrado anteriormente (build.gradle del
                proyecto).</span></li>     
        <li class="c10 li-bullet-0"><span class="c1">Despu&eacute;s de crear la cuenta, si a la hora de realizar la
                verificaci&oacute;n de la cuenta no ve ning&uacute;n correo en la bandeja de entrada, busque en el
                apartado de &lsquo;Spam&rsquo; o correos no deseados.</span></li>
        <li class="c10 li-bullet-0"><span class="c1">Lo mismo puede ocurrir a la hora de recuperar la
                contrase&ntilde;a.</span></li>
    </ul>
    <p class="c5"><span class="c1"></span></p>
    <h1 class="c19 c9" id="h.cy0ga7enxfxh"><span class="c16">Recursos y herramientas utilizadas</span></h1>
    <p class="c5"><span class="c1"></span></p>
    <ul class="c30 lst-kix_4lsp0mk9f5i7-0 start">
        <li class="c10 li-bullet-0"><span class="c24"><a class="c0"
                    href="https://www.google.com/url?q=https://www.digitalocean.com/community/tutorials/okhttp-android-example-tutorial&amp;sa=D&amp;source=editors&amp;ust=1677965118913841&amp;usg=AOvVaw1Vi0ATza-3cUt3iFsEbILK">OkHttp
                    Android Example Tutorial | DigitalOcean</a></span></li>
        <li class="c10 li-bullet-0"><span class="c24"><a class="c0"
                    href="https://www.google.com/url?q=https://www.youtube.com/watch?v%3DoGWJ8xD2W6k&amp;sa=D&amp;source=editors&amp;ust=1677965118914240&amp;usg=AOvVaw11vrw4Uti84tn9hWc66o0i">(3018)
                    Simple HTTP Request with OkHttp - Android Studio Tutorial - YouTube</a></span></li>
        <li class="c10 li-bullet-0"><span class="c24"><a class="c0"
                    href="https://www.google.com/url?q=https://www.youtube.com/watch?v%3DgntHivOmT_U&amp;sa=D&amp;source=editors&amp;ust=1677965118914608&amp;usg=AOvVaw1p0rYeGWGwt_wSXKBINvzb">(3018)
                    &iquest;C&oacute;mo programar la descarga de informaci&oacute;n gratuita de Aemet en distintos
                    lenguajes de programaci&oacute;n? - YouTube</a></span></li>
        <li class="c10 li-bullet-0"><span class="c24"><a class="c0"
                    href="https://www.google.com/url?q=https://www.youtube.com/watch?v%3DwGNYqLOq4fE&amp;sa=D&amp;source=editors&amp;ust=1677965118914940&amp;usg=AOvVaw0APu2J9Ywmrfm_LpKAZA_2">(3018)
                    &iquest;C&oacute;mo obtener informaci&oacute;n gratuita de Aemet de forma puntual? -
                    YouTube</a></span></li>
        <li class="c10 li-bullet-0"><span class="c24"><a class="c0"
                    href="https://www.google.com/url?q=https://opendata.aemet.es/centrodedescargas/inicio&amp;sa=D&amp;source=editors&amp;ust=1677965118915275&amp;usg=AOvVaw1enSm8sfpgSy-J6HNmS7Cz">AEMET
                    OpenData</a></span></li>
        <li class="c10 li-bullet-0"><span class="c24"><a class="c0"
                    href="https://www.google.com/url?q=https://opendata.aemet.es/centrodedescargas/ejemProgramas?&amp;sa=D&amp;source=editors&amp;ust=1677965118915607&amp;usg=AOvVaw3VPym9a2Fx-zq0xst3s_Aa">AEMET
                    OpenData | Ejemplos de programas</a></span></li>
        <li class="c10 li-bullet-0"><span class="c24"><a class="c0"
                    href="https://www.google.com/url?q=https://opendata.aemet.es/dist/index.html?%23/&amp;sa=D&amp;source=editors&amp;ust=1677965118915946&amp;usg=AOvVaw3bsSusfvMX5TZQxsvM5wp6">Swagger
                    UI (aemet.es)</a></span></li>
        <li class="c10 li-bullet-0"><span class="c24"><a class="c0"
                    href="https://www.google.com/url?q=https://parzibyte.me/blog/2019/02/16/parsear-decodificar-json-java-jsonobject-jsonarray/&amp;sa=D&amp;source=editors&amp;ust=1677965118916321&amp;usg=AOvVaw18zC2ixTabagya2i46TQV6">Parsear
                    o decodificar JSON con Java, JSONObject y JSONArray - Parzibyte&#39;s blog</a></span></li>
        <li class="c10 li-bullet-0"><span class="c24"><a class="c0"
                    href="https://www.google.com/url?q=https://www.youtube.com/watch?v%3DBWNiMQkW3u4&amp;sa=D&amp;source=editors&amp;ust=1677965118916660&amp;usg=AOvVaw1Bao0fS8PYypmx2GY6MHnP">https://www.youtube.com/watch?v=BWNiMQkW3u4</a></span><span
                class="c1">&nbsp;(Subida del json a firebase)</span></li>
        <li class="c10 li-bullet-0"><span class="c24"><a class="c0"
                    href="https://www.google.com/url?q=https://www.youtube.com/watch?v%3DOChDHNUP9cA&amp;sa=D&amp;source=editors&amp;ust=1677965118916990&amp;usg=AOvVaw2lQNVh6DyHIX8GYSN23DkJ">How
                    to Toggle Password Visibility in Android Studio - YouTube</a></span></li>
        <li class="c10 li-bullet-0"><span class="c24"><a class="c0"
                    href="https://www.google.com/url?q=https://stackoverflow.com/questions/39866086/change-password-with-firebase-for-android&amp;sa=D&amp;source=editors&amp;ust=1677965118917363&amp;usg=AOvVaw0MJEM_8gRRZlATN5dc79F5">Change
                    password with Firebase for Android - Stack Overflow</a></span></li>
        <li class="c10 li-bullet-0"><span class="c24"><a class="c0"
                    href="https://www.google.com/url?q=https://github.com/codeforspain/ds-organizacion-administrativa&amp;sa=D&amp;source=editors&amp;ust=1677965118917778&amp;usg=AOvVaw2Ca7QNAjFgfjxOxKMjWOH_">codeforspain/ds-organizacion-administrativa:
                    Listado de comunidades, provincias, municipios con su correspondiente c&oacute;digo INE
                    (github.com)</a></span><span class="c1">&nbsp;(Obtenci&oacute;n del JSON con los c&oacute;digos INE
                de los municipios)</span></li>
        <li class="c10 li-bullet-0"><span class="c24"><a class="c0"
                    href="https://www.google.com/url?q=https://firebase.google.com/docs/auth/android/manage-users?hl%3Des-419%23java_10&amp;sa=D&amp;source=editors&amp;ust=1677965118918596&amp;usg=AOvVaw3O07dTwxuNNlV6EcAyvqM0">https://firebase.google.com/docs/auth/android/manage-users?hl=es-419#java_10</a></span><span>&nbsp;</span>
        </li>
    </ul>
    <div>
        <p class="c27 c33"><span class="c1"></span></p>
    </div>
</body>

</html>
