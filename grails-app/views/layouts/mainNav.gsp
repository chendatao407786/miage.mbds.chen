<!DOCTYPE html>
<html>
    <head>
        %{--<meta name="layout" content="main" />--}%
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
        <asset:stylesheet src="nav.css"></asset:stylesheet>
        <asset:stylesheet src="application.css"/>
        <g:layoutHead/>
    </head>
    <body>
    <div class="nav" role="navigation">
        <div style="position: absolute">
            <img src="/assets/LOGO_MIAGE.png" style="height: 80px"/>
            <img src="/assets/unice.jpg" style="height: 80px"/>
            <span>welcome <sec:username/></span>
        </div>

        <ul id="firstNav">
            <li><a href="${createLink(uri: '/')}">Home</a></li>
            <li>
                <a href="${createLink(uri: '/user/index')}">Users</a>
                <ul class="secondNav">
                    <li><a href="${createLink(uri: '/user/create')}">Create User</a></li>
                </ul>
            </li>
            <li>
                <a href="${createLink(uri:'/game/index')}">Result</a>
                <ul class="secondNav">
                    <li><a href="${createLink(uri: '/game/create')}">Create Game</a></li>
                    <li><a href="${createLink(uri: '/userGame/create')}">Create UserGame</a></li>
                </ul>
            </li>
            <li><a href="#">Message</a></li>
            %{--<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>--}%
            %{--<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>--}%
        </ul>
    </div>
    <g:layoutBody/>
    </body>
</html>