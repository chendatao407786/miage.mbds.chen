<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="mainNav" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
        <asset:stylesheet src="creat.css"></asset:stylesheet>
        <asset:javascript src="jquery-2.2.0.min.js"></asset:javascript>
        <asset:javascript src="upload.js"></asset:javascript>

    </head>
    <body>
    %{--<a href="#create-user" class="skip" tabindex="-1" style="color: white; font-size: 30px;text-align: center"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>--}%
    %{--<div class="nav" role="navigation">--}%
        %{--<ul>--}%
            %{--<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>--}%
            %{--<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>--}%
        %{--</ul>--}%
    %{--</div>--}%
    <div id="create-user" class="content scaffold-create" role="main">
        <h1 style="color: white; font-size: 30px;text-align: center"><g:message code="default.create.label" args="[entityName]" /></h1>
        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>
        <g:hasErrors bean="${this.user}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.user}" var="error">
                    <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
        </g:hasErrors>
        <br>
        <br>
        <g:uploadForm action="creater" method="POST">
            <fieldset class="form">
                <f:all bean="user" except="picture,userGame"/>
                <div class="fieldcontain">
                    <label for="picture">Upload your profile</label>
                    <input type="file" name="picture" id="picture"/>
                </div>
                <div class="fieldcontain">
                    <label for="create"></label>
                    <g:submitButton name="create" class="save " value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </div>
            </fieldset>
            %{--<fieldset class="buttons">--}%
                %{--<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />--}%
            %{--</fieldset>--}%
        </g:uploadForm>
    </div>
    </body>
</html>
