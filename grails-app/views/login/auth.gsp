<html>
    <head>
        %{--<title><g:message code='springSecurity.login.title'/></title>--}%
        <asset:stylesheet src="login.css"></asset:stylesheet>
    </head>
    <style>
        body{
            background-image: url('${resource(dir:"/images",file:"login_background.jpg")}');
        }

    </style>
    <body>
    %{--<body style="background-image: url('${resource(dir:"/images",file:"login_background.jpg")}');">--}%
    <div id="login">
        <div class="inner">
            %{--<div class="fheader"><g:message code='springSecurity.login.header'/></div>--}%
            <form action="${postUrl ?: '/login/authenticate'}" method="POST" id="loginForm" class="login_form" autocomplete="off">
                <p>
                    <input type="text" class="text_ login" name="${usernameParameter ?: 'username'}" id="username" placeholder="Identifiant"/>
                </p>

                <p>
                    <input type="password" class="text_ login" name="${passwordParameter ?: 'password'}" id="password" placeholder="Mot de Passe"/>
                </p>

                <p>
                    <input type="submit" class="buttons_ login buttons_login" id="submit" value="${message(code: 'springSecurity.login.button')}"/>
                </p>
            </form>
            <hr>
            <form>
                <p>
                    <input type="submit" class="buttons_ login buttons_register" value="Enregistrez-vous">
                </p>
            </form>
            <div class="login_message">
                <g:if test='${flash.message}'>
                    ${flash.message}
                </g:if>
            </div>
        </div>


    </div>

    <script>
        (function() {
            document.forms['loginForm'].elements['${usernameParameter ?: 'username'}'].focus();
        })();
    </script>
    </body>
</html>