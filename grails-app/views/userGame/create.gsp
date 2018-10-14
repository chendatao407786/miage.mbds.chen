<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="mainNav" />
        <g:set var="entityName" value="${message(code: 'userGame.label', default: 'UserGame')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        %{--<a href="#create-userGame" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>--}%
        %{--<div class="nav" role="navigation">--}%
            %{--<ul>--}%
                %{--<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>--}%
                %{--<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>--}%
            %{--</ul>--}%
        %{--</div>--}%
        <br><br>
        <div id="create-userGame" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.userGame}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.userGame}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>

            <g:form resource="${this.userGame}" method="POST">
                <fieldset class="form">
                    <f:all bean="userGame" except="result"/>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    <asset:javascript src="jquery-2.2.0.min.js"></asset:javascript>
    <asset:javascript src="createUserGame.js"></asset:javascript>
    </body>
</html>
