<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="mainNav" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
        <asset:stylesheet src="index.css"></asset:stylesheet>
    </head>
    <body>
        <a href="#list-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div id="main">
            <g:each in="${userList}" var="user" status="i">
                <div id="user">
                    <div id="pic">
                        <img id="profile" src="${user.picture}">
                        <span>${user.username}</span>
                    </div>

                </div>
            </g:each>

        </div>
    </body>
</html>